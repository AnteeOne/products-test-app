package tech.antee.products.features.product_details.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.antee.products.common.di.injectedViewModel
import tech.antee.products.features.product_details.di.DaggerProductDetailsComponent
import tech.antee.products.features.product_details.di.LocalProductDetailsDependencies

@Composable
fun ProductDetailsFeature(
    productId: String,
    onNavBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val deps = LocalProductDetailsDependencies.current
    val viewModel = injectedViewModel {
        DaggerProductDetailsComponent.factory()
            .create(
                deps = deps,
                productId = productId
            )
            .viewModel
    }

    ProductDetailsScreen(
        modifier = modifier,
        viewModel = viewModel,
        onNavBack = onNavBack
    )
}
