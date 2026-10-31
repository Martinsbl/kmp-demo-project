package org.example.demo.ktlint

import com.pinterest.ktlint.rule.engine.api.Code
import com.pinterest.ktlint.rule.engine.api.KtLintRuleEngine
import com.pinterest.ktlint.rule.engine.api.LintError
import com.pinterest.ktlint.rule.engine.core.api.AutocorrectDecision
import com.pinterest.ktlint.ruleset.standard.StandardRuleSetProvider
import org.jetbrains.amper.plugins.Input
import org.jetbrains.amper.plugins.TaskAction
import java.nio.file.Path
import kotlin.io.path.Path
import kotlin.io.path.extension
import kotlin.io.path.invariantSeparatorsPathString
import kotlin.io.path.isDirectory
import kotlin.io.path.name
import kotlin.io.path.relativeTo
import kotlin.io.path.walk
import kotlin.io.path.writeText

// Rules are configured in the project's .editorconfig, which ktlint picks up for every file it checks
private val ktlint = KtLintRuleEngine(ruleProviders = StandardRuleSetProvider().getRuleProviders())

@TaskAction
fun lint(
    @Input moduleDir: Path,
    projectDir: String,
) {
    val violations = kotlinFiles(moduleDir).sumOf { file ->
        var count = 0
        ktlint.lint(Code.fromFile(file.toFile())) { error ->
            report(file, projectDir, error)
            count++
        }
        count
    }
    check(violations == 0) {
        "ktlint found $violations violation(s). Run `./kotlin do ktlintFormat` to fix the ones that can be fixed automatically."
    }
}

@TaskAction
fun format(
    @Input moduleDir: Path,
    projectDir: String,
) {
    var remaining = 0
    kotlinFiles(moduleDir).forEach { file ->
        val code = Code.fromFile(file.toFile())
        // The callback is invoked again on every format pass, so the same error can be reported more than once
        val unfixable = mutableSetOf<LintError>()
        val formatted = ktlint.format(code) { error ->
            if (!error.canBeAutoCorrected) unfixable += error
            AutocorrectDecision.ALLOW_AUTOCORRECT
        }
        if (formatted != code.content) {
            file.writeText(formatted)
            println("Formatted ${file.relativeTo(Path(projectDir)).invariantSeparatorsPathString}")
        }
        unfixable.forEach { report(file, projectDir, it) }
        remaining += unfixable.size
    }
    check(remaining == 0) { "ktlint could not fix $remaining violation(s) automatically, fix them by hand." }
}

private fun kotlinFiles(moduleDir: Path): List<Path> = moduleDir
    .walk()
    .filter { it.extension == "kt" || it.extension == "kts" }
    .filterNot { file -> file.relativeTo(moduleDir).any { it.name == "build" || it.name.startsWith(".") } }
    .filterNot { it.isDirectory() }
    .sorted()
    .toList()

private fun report(
    file: Path,
    projectDir: String,
    error: LintError,
) {
    val path = file.relativeTo(Path(projectDir)).invariantSeparatorsPathString
    println("$path:${error.line}:${error.col}: ${error.detail} (${error.ruleId.value})")
}
