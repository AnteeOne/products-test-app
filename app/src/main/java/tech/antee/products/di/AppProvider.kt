package tech.antee.products.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.products.multi_compose.Destinations
import tech.antee.products.features.product_details.impl.di.ProductDetailsDependencies
import tech.antee.products.features.product_list.impl.di.ProductListDependencies

interface AppProvider : ProductListDependencies, ProductDetailsDependencies {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
