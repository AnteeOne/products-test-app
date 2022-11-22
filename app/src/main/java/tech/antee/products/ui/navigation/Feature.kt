package tech.antee.products.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Feature(val route: String) {
    object ProductList : Feature("product_list")
    object ProductDetails : Feature("productDetails?productId={productId}") {

        const val argumentProductId = "productId"

        val arguments = listOf(
            navArgument(argumentProductId) {
                type = NavType.StringType
            }
        )

        fun destination(guid: String) = "productDetails?productId=$guid"
    }
}
