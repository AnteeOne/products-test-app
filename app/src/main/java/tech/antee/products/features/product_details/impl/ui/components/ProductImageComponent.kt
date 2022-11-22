package tech.antee.products.features.product_details.impl.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import coil.compose.AsyncImage

@Composable
internal fun ProductImageComponent(
    imageUrl: String?,
    modifier: Modifier = Modifier
) {
    val localDensity = LocalDensity.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = imageUrl
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.5f)),
                        startY = 500f
                    )
                )
        )
    }
}
