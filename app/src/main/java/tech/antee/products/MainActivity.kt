package tech.antee.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import tech.antee.products.common.ui.theme.MyApplicationTheme
import tech.antee.products.di.LocalAppProvider
import tech.antee.products.features.product_details.api.ProductDetailsFeature
import tech.antee.products.features.product_details.impl.di.LocalProductDetailsDependencies
import tech.antee.products.features.product_list.api.ProductListFeature
import tech.antee.products.features.product_list.impl.di.LocalProductListDependencies
import tech.antee.products.multi_compose.find

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                GlobalDependenciesProvider {
                    Navigation()
                }
            }
        }
    }

    @Composable
    private fun Navigation(modifier: Modifier = Modifier) {
        val navController = rememberNavController()
        val destinations = LocalAppProvider.current.destinations

        val productListFeature = destinations.find<ProductListFeature>()
        val productDetailsFeature = destinations.find<ProductDetailsFeature>()

        Box(modifier.fillMaxSize()) {
            NavHost(navController, productListFeature.featureRoute) {
                with(productListFeature) { composable(navController, destinations) }
                with(productDetailsFeature) { composable(navController, destinations) }
            }
        }
    }

    @Composable
    private fun GlobalDependenciesProvider(
        content: @Composable () -> Unit
    ) {
        CompositionLocalProvider(
            LocalAppProvider provides application.appProvider,
            LocalProductListDependencies provides application.appProvider,
            LocalProductDetailsDependencies provides application.appProvider,
            content = content
        )
    }
}
