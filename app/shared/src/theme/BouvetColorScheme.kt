package org.example.demo.theme

import androidx.compose.material3.darkColorScheme

// The template is flat: one navy surface everywhere, so nothing gets a tonal tint or looks raised.
internal val bouvetColorScheme =
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
