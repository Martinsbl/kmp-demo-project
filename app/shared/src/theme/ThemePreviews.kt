package org.example.demo.theme

import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_NO
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Preview

/** Previews a screen in light and dark mode, at normal, large and the largest system font size. */
@Preview(name = "Light", group = "100%", uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL)
@Preview(name = "Dark", group = "100%", uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
@Preview(name = "Light 150%", group = "150%", fontScale = 1.5f, uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL)
@Preview(name = "Dark 150%", group = "150%", fontScale = 1.5f, uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
@Preview(name = "Light 200%", group = "200%", fontScale = 2f, uiMode = UI_MODE_NIGHT_NO or UI_MODE_TYPE_NORMAL)
@Preview(name = "Dark 200%", group = "200%", fontScale = 2f, uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
annotation class ThemePreviews
