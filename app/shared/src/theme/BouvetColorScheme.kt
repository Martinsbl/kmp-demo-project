package org.example.demo.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

// The template is flat: one navy surface everywhere, so nothing gets a tonal tint or looks raised.
internal val bouvetDarkColorScheme =
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

// The same flat look on cream. Orange and mint are too faint on cream for text, so blue takes the accent.
internal val bouvetLightColorScheme =
    lightColorScheme(
        primary = BouvetColors.Blue,
        onPrimary = BouvetColors.Cream,
        primaryContainer = BouvetColors.Mist,
        onPrimaryContainer = BouvetColors.Navy,
        secondary = BouvetColors.Navy,
        onSecondary = BouvetColors.Cream,
        secondaryContainer = BouvetColors.Mist,
        onSecondaryContainer = BouvetColors.Navy,
        tertiary = BouvetColors.Blue,
        onTertiary = BouvetColors.Cream,
        background = BouvetColors.Cream,
        onBackground = BouvetColors.Navy,
        surface = BouvetColors.Cream,
        onSurface = BouvetColors.Navy,
        surfaceVariant = BouvetColors.Cream,
        onSurfaceVariant = BouvetColors.Navy.copy(alpha = 0.7f),
        surfaceTint = BouvetColors.Cream,
        surfaceBright = BouvetColors.Cream,
        surfaceDim = BouvetColors.Cream,
        surfaceContainerLowest = BouvetColors.Cream,
        surfaceContainerLow = BouvetColors.Cream,
        surfaceContainer = BouvetColors.Cream,
        surfaceContainerHigh = BouvetColors.Cream,
        surfaceContainerHighest = BouvetColors.Cream,
        outline = BouvetColors.Orange,
        outlineVariant = BouvetColors.Navy.copy(alpha = 0.25f),
        error = BouvetColors.Red,
        onError = BouvetColors.Cream,
    )
