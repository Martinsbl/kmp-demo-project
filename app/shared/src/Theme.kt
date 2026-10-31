package org.example.demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.Font
import shared.generated.resources.Res
import shared.generated.resources.inter_bold
import shared.generated.resources.inter_medium
import shared.generated.resources.inter_regular

/** The colors from the Bouvet presentation template. */
object BouvetColors {
    val Navy = Color(0xFF11133C)
    val Cream = Color(0xFFF9EAD3)
    val Mint = Color(0xFF78FE9C)
    val Mist = Color(0xFFC3D5E1)
    val Orange = Color(0xFFF9A86F)
    val Blue = Color(0xFF1D43C6)
    val Red = Color(0xFFEE2950)
}

/** The template draws every line 2 points thick. */
val LineThickness = 2.dp

// The template is flat: one navy surface everywhere, so nothing gets a tonal tint or looks raised.
private val bouvetColors =
    darkColorScheme(
        primary = BouvetColors.Orange,
        onPrimary = BouvetColors.Navy,
        primaryContainer = BouvetColors.Blue,
        onPrimaryContainer = BouvetColors.Cream,
        secondary = BouvetColors.Mist,
        onSecondary = BouvetColors.Navy,
        secondaryContainer = BouvetColors.Blue,
        onSecondaryContainer = BouvetColors.Cream,
        tertiary = BouvetColors.Mint,
        onTertiary = BouvetColors.Navy,
        background = BouvetColors.Navy,
        onBackground = BouvetColors.Cream,
        surface = BouvetColors.Navy,
        onSurface = BouvetColors.Cream,
        surfaceVariant = BouvetColors.Navy,
        onSurfaceVariant = BouvetColors.Mist,
        surfaceTint = BouvetColors.Navy,
        surfaceBright = BouvetColors.Navy,
        surfaceDim = BouvetColors.Navy,
        surfaceContainerLowest = BouvetColors.Navy,
        surfaceContainerLow = BouvetColors.Navy,
        surfaceContainer = BouvetColors.Navy,
        surfaceContainerHigh = BouvetColors.Navy,
        surfaceContainerHighest = BouvetColors.Navy,
        outline = BouvetColors.Orange,
        outlineVariant = BouvetColors.Mist.copy(alpha = 0.25f),
        error = BouvetColors.Red,
        onError = BouvetColors.Cream,
    )

// Square corners, never rounded.
private val bouvetShapes =
    Shapes(
        extraSmall = RoundedCornerShape(0.dp),
        small = RoundedCornerShape(0.dp),
        medium = RoundedCornerShape(0.dp),
        large = RoundedCornerShape(0.dp),
        extraLarge = RoundedCornerShape(0.dp),
    )

@Composable
private fun interTypography(): Typography {
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

@Composable
fun BouvetTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = bouvetColors,
        typography = interTypography(),
        shapes = bouvetShapes,
        content = content,
    )
}

/** A top bar with the template's orange rule under it. Icons are white, never orange. */
@Composable
fun BouvetTopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
) {
    Column {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            colors =
                TopAppBarDefaults.topAppBarColors(
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),
        )
        HorizontalDivider(thickness = LineThickness, color = MaterialTheme.colorScheme.outline)
    }
}
