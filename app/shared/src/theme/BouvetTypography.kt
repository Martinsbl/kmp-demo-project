package org.example.demo.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import shared.generated.resources.Res
import shared.generated.resources.inter_bold
import shared.generated.resources.inter_medium
import shared.generated.resources.inter_regular

@Composable
internal fun bouvetTypography(): Typography {
    val inter =
        FontFamily(
            Font(Res.font.inter_regular, FontWeight.Normal),
            Font(Res.font.inter_medium, FontWeight.Medium),
            Font(Res.font.inter_bold, FontWeight.Bold),
        )

    fun TextStyle.inter(weight: FontWeight? = fontWeight) = copy(fontFamily = inter, fontWeight = weight)

    val base = Typography()
    return Typography(
        displayLarge = base.displayLarge.inter(FontWeight.Bold),
        displayMedium = base.displayMedium.inter(FontWeight.Bold),
        displaySmall = base.displaySmall.inter(FontWeight.Bold),
        headlineLarge = base.headlineLarge.inter(FontWeight.Bold),
        headlineMedium = base.headlineMedium.inter(FontWeight.Bold),
        headlineSmall = base.headlineSmall.inter(FontWeight.Bold),
        titleLarge = base.titleLarge.inter(),
        titleMedium = base.titleMedium.inter(),
        titleSmall = base.titleSmall.inter(),
        bodyLarge = base.bodyLarge.inter(),
        bodyMedium = base.bodyMedium.inter(),
        bodySmall = base.bodySmall.inter(),
        labelLarge = base.labelLarge.inter(),
        labelMedium = base.labelMedium.inter(),
        labelSmall = base.labelSmall.inter(),
    )
}
