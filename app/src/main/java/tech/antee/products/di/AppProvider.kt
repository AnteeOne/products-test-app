package tech.antee.products.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.products.features.product_details.di.ProductDetailsDependencies
import tech.antee.products.features.product_list.di.ProductListDependencies

interface AppProvider : ProductListDependencies, ProductDetailsDependencies

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
