package tech.antee.products.features.product_list.impl.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import tech.antee.products.features.product_details.api.ProductDetailsFeature
import tech.antee.products.features.product_list.api.ProductListFeature
import tech.antee.products.features.product_list.impl.di.DaggerProductListComponent
import tech.antee.products.features.product_list.impl.di.LocalProductListDependencies
import tech.antee.products.multi_compose.Destinations
import tech.antee.products.multi_compose.di.injectedViewModel
import tech.antee.products.multi_compose.find
import javax.inject.Inject

class ProductListFeatureImpl @Inject constructor() : ProductListFeature() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val deps = LocalProductListDependencies.current
        val viewModel = injectedViewModel {
            DaggerProductListComponent.factory()
                .create(deps)
                .viewModel
        }

        val productDetailsFeature = destinations.find<ProductDetailsFeature>()
        ProductListScreen(
            viewModel = viewModel,
            onNavToDetails = { id -> navController.navigate(productDetailsFeature.destination(id)) }
        )
    }
}
