package tech.antee.products.product_list.impl.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tech.antee.products.product_list.impl.ui.items.ProductItem
import tech.antee.products.ui.theme.Dimensions

@Composable
fun ProductItemComponent(
    item: ProductItem,
    onClick: () -> Unit,
    onCheckedChange: ((Boolean) -> Unit),
    modifier: Modifier = Modifier
) = with(item) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                horizontal = Dimensions.paddingHorizontalM,
                vertical = Dimensions.paddingVerticalXs
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            AsyncImage(
                modifier = Modifier.size(ProductItemComponentDefaults.IMAGE_SIZE),
                model = item.image,
                contentScale = ContentScale.Crop,
                contentDescription = item.name
            )
            Spacer(Modifier.width(Dimensions.spacingHorizontalXs))
            Column {
                Text(
                    modifier = Modifier.width(ProductItemComponentDefaults.NAME_WIDTH),
                    text = name,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(Dimensions.spacingVerticalXxs))
                Text(
                    text = price.toString(),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
        Column {
            Checkbox(
                checked = isChecked,
                onCheckedChange = onCheckedChange,
                colors = CheckboxDefaults.colors(uncheckedColor = MaterialTheme.colorScheme.surface)
            )
        }
    }
}

private object ProductItemComponentDefaults {
    val NAME_WIDTH = 180.dp
    val IMAGE_SIZE = 64.dp
}
