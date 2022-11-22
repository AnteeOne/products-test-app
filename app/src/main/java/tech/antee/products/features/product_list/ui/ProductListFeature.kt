package tech.antee.products.features.product_list.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.antee.products.common.di.injectedViewModel
import tech.antee.products.features.product_list.di.DaggerProductListComponent
import tech.antee.products.features.product_list.di.LocalProductListDependencies

@Composable
fun ProductListFeature(
    onNavToDetails: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val deps = LocalProductListDependencies.current
    val viewModel = injectedViewModel {
        DaggerProductListComponent.factory()
            .create(deps)
            .viewModel
    }

    ProductListScreen(
        modifier = modifier,
        viewModel = viewModel,
        onNavToDetails = onNavToDetails
    )
}
