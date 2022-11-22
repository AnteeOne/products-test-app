package tech.antee.products.common.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

internal val AppTypography = Typography(
    displayLarge = TextStyle(
        fontSize = TextSize.display1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    displayMedium = TextStyle(
        fontSize = TextSize.display2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    displaySmall = TextStyle(
        fontSize = TextSize.display3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    headlineLarge = TextStyle(
        fontSize = TextSize.headline1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    headlineMedium = TextStyle(
        fontSize = TextSize.headline2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    headlineSmall = TextStyle(
        fontSize = TextSize.headline3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    titleLarge = TextStyle(
        fontSize = TextSize.title1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    titleMedium = TextStyle(
        fontSize = TextSize.title2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    titleSmall = TextStyle(
        fontSize = TextSize.title3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    bodyLarge = TextStyle(
        fontSize = TextSize.body1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    bodyMedium = TextStyle(
        fontSize = TextSize.body2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    bodySmall = TextStyle(
        fontSize = TextSize.body3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    labelLarge = TextStyle(
        fontSize = TextSize.label1,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    labelMedium = TextStyle(
        fontSize = TextSize.label2,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    labelSmall = TextStyle(
        fontSize = TextSize.label3,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    )
)

internal object TextSize {
    val display1 = 60.sp
    val display2 = 48.sp
    val display3 = 34.sp

    val headline1 = 28.sp
    val headline2 = 22.sp
    val headline3 = 20.sp

    val title1 = 17.sp
    val title2 = 16.sp
    val title3 = 15.sp

    val body1 = 17.sp
    val body2 = 17.sp
    val body3 = 13.sp

    val label1 = 12.sp
    val label2 = 11.sp
    val label3 = 10.sp
}
