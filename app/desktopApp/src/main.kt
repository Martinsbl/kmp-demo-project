package org.example.demo

import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toPainter
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.imageio.ImageIO

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Penguin Mail", icon = remember { appIcon() }) {
        App()
    }
}

private fun appIcon(): Painter = ImageIO.read(object {}.javaClass.getResource("/icon.png")).toPainter()
