package tech.antee.products.features.product_details.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import tech.antee.products.R
import tech.antee.products.common.ui.theme.Dimensions

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? = null,
    leftAction: @Composable (() -> Unit)? = null,
    rightAction: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = modifier
            .height(TopAppBarDefaults.height)
            .padding(horizontal = Dimensions.paddingHorizontalM),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row { leftAction?.invoke() }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            title?.invoke()
        }
        Row { rightAction?.invoke() }
    }
}

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) = IconButton(
    modifier = modifier.size(Dimensions.sizeIconXs),
    onClick = onClick
) {
    Image(
        modifier = Modifier
            .fillMaxSize(),
        painter = painterResource(R.drawable.ic_back),
        contentDescription = null
    )
}

private object TopAppBarDefaults {
    val height = 56.dp
}
