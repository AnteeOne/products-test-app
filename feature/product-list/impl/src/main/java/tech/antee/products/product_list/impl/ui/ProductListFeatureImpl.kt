package tech.antee.products.product_list.impl.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import tech.antee.products.multi_compose.Destinations
import tech.antee.products.multi_compose.di.injectedViewModel
import tech.antee.products.product_list.api.ProductListFeature
import tech.antee.products.product_list.impl.di.DaggerProductListComponent
import tech.antee.products.product_list.impl.di.LocalProductListDependencies
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

        ProductListScreen(
            viewModel = viewModel,
            onNavToDetails = { } // TODO: implement navigation to the details
        )
    }
}
