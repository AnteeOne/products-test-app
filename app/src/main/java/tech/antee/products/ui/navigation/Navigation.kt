package tech.antee.products.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.antee.products.features.product_details.ui.ProductDetailsFeature
import tech.antee.products.features.product_list.ui.ProductListFeature

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Box(modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = Feature.ProductList.route
        ) {
            composable(
                route = Feature.ProductList.route
            ) {
                ProductListFeature(
                    onNavToDetails = { id -> navController.navigate(Feature.ProductDetails.destination(id)) }
                )
            }
            composable(
                route = Feature.ProductDetails.route,
                arguments = Feature.ProductDetails.arguments
            ) { backStackEntry ->
                ProductDetailsFeature(
                    productId = requireNotNull(
                        backStackEntry.arguments?.getString(Feature.ProductDetails.argumentProductId)
                    ),
                    onNavBack = { navController.popBackStack() }
                )
            }
        }
    }
}
