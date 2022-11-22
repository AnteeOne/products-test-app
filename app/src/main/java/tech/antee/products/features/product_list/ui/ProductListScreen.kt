package tech.antee.products.features.product_list.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import tech.antee.products.common.ui.theme.Dimensions
import tech.antee.products.features.product_list.ui.components.ProductItemComponent
import tech.antee.products.features.product_list.ui.items.Event

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    onNavToDetails: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.uiEvents.collect { event ->
            when (event) {
                is Event.OnNavToDetails -> onNavToDetails(event.id)
            }
        }
    }

    with(uiState) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = Dimensions.paddingVerticalM)
            ) {
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(
                        items = products,
                        key = { product -> product.id }
                    ) { item ->
                        ProductItemComponent(
                            item = item,
                            onClick = {
                                viewModel.onAction(
                                    tech.antee.products.features.product_list.ui.items.Action.OnItemClick(
                                        item.id
                                    )
                                )
                            },
                            onCheckedChange = {
                                viewModel.onAction(
                                    tech.antee.products.features.product_list.ui.items.Action.OnItemCheckboxClick(
                                        item.id
                                    )
                                )
                            }
                        )
                        Spacer(modifier = Modifier.height(Dimensions.spacingVerticalXs))
                    }
                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimensions.paddingHorizontalXs),
                    enabled = products.any { it.isChecked },
                    colors = ButtonDefaults.buttonColors(
                        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                    ),
                    onClick = { viewModel.onAction(tech.antee.products.features.product_list.ui.items.Action.OnDeleteButtonClick) }
                ) {
                    Text(
                        modifier = Modifier.padding(Dimensions.paddingHorizontalXs),
                        text = "Delete", // TODO: to res
                        color = Color.White
                    )
                }
            }
            if (isLoading) CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
