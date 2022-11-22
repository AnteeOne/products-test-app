package tech.antee.products.common.ui.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val RedVolcano = Color(0xFFF91055)
val BlueCornflower = Color(0x8010A7C8)
val GreenJungle = Color(0XFF39DF68)
val BlueDino = Color(0xFF042C47)
val BlueArctic = Color(0xB3032B44)

// Text Colors
val GrayMid = Color(0xFF5D5E64)

// Secondary Colors
val WhiteHeather = Color(0xFFB2BACA)
val WhiteSnuff = Color(0xFFDBDBEA)
val BlackSilverChalice = Color(0x59000000)
val BlackDove = Color(0x80000000)
val White = Color(0xFFFFFFFF)

internal val LightColorPalette = lightColorScheme(
    background = BlueDino,
    onBackground = White,
    primary = RedVolcano,
    onPrimary = White,
    primaryContainer = BlueCornflower,
    onPrimaryContainer = White,
    inversePrimary = BlueCornflower,
    secondary = GreenJungle,
    onSecondary = White,
    secondaryContainer = WhiteHeather,
    onSecondaryContainer = White,
    tertiary = WhiteSnuff,
    onTertiary = White,
    tertiaryContainer = WhiteSnuff,
    onTertiaryContainer = White,
    surface = BlueArctic,
    onSurface = White,
    surfaceVariant = BlackSilverChalice,
    onSurfaceVariant = GrayMid,
    inverseSurface = BlackSilverChalice,
    inverseOnSurface = BlackDove,
    outline = RedVolcano,
    onErrorContainer = White
)
