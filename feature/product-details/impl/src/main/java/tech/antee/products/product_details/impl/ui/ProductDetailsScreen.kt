package tech.antee.products.product_details.impl.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import tech.antee.products.product_details.impl.ui.components.ProductImageComponent
import tech.antee.products.product_details.impl.ui.items.Event
import tech.antee.products.top_app_bar.BackButton
import tech.antee.products.top_app_bar.TopAppBar
import tech.antee.products.ui.theme.Dimensions

@Composable
fun ProductDetailsScreen(
    viewModel: ProductDetailsViewModel,
    onNavBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.uiEvents.collect { event ->
            when (event) {
                Event.OnNavBack -> onNavBack()
            }
        }
    }
    with(uiState) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            product?.also { productItem ->
                with(productItem) {
                    Column(Modifier.fillMaxSize()) {
                        ProductImageComponent(image)
                        Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = Dimensions.paddingHorizontalM),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = name,
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                            )
                            Text(
                                text = price.toString(),
                                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimensions.spacingVerticalM))
                        if (description != null) {
                            Text(
                                modifier = Modifier.padding(horizontal = Dimensions.paddingHorizontalM),
                                text = description
                            )
                        }
                    }
                }
            }
            Column(Modifier.fillMaxSize()) {
                TopAppBar(
                    leftAction = { BackButton(onClick = onNavBack) }
                )
            }
            if (isLoading) CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
