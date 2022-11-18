package tech.antee.products.product_details.impl.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import tech.antee.products.multi_compose.Destinations
import tech.antee.products.multi_compose.di.injectedViewModel
import tech.antee.products.product_details.api.ProductDetailsFeature
import tech.antee.products.product_details.impl.di.DaggerProductDetailsComponent
import tech.antee.products.product_details.impl.di.LocalProductDetailsDependencies
import javax.inject.Inject

class ProductDetailsFeatureImpl @Inject constructor() : ProductDetailsFeature() {

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val deps = LocalProductDetailsDependencies.current
        val viewModel = injectedViewModel {
            DaggerProductDetailsComponent.factory()
                .create(
                    deps = deps,
                    productId = requireNotNull(backStackEntry.arguments?.getString(productIdArgument))
                )
                .viewModel
        }

        ProductDetailsScreen(
            viewModel = viewModel,
            onNavBack = { navController.popBackStack() }
        )
    }
}
