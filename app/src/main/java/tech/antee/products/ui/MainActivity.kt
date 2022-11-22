package tech.antee.products.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import tech.antee.products.common.ui.theme.MyApplicationTheme
import tech.antee.products.di.LocalAppProvider
import tech.antee.products.features.product_details.di.LocalProductDetailsDependencies
import tech.antee.products.features.product_list.di.LocalProductListDependencies
import tech.antee.products.ui.navigation.Navigation

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
