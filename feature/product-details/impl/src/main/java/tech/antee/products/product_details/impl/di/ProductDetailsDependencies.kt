package tech.antee.products.product_details.impl.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.products.domain.use_cases.FetchProductsUseCase
import tech.antee.products.domain.use_cases.ObserveProductUseCase

interface ProductDetailsDependencies {

    val observeProductUseCase: ObserveProductUseCase

    val fetchProductsUseCase: FetchProductsUseCase
}

val LocalProductDetailsDependencies = compositionLocalOf<ProductDetailsDependencies> {
    error("No feature deps provider found!")
}
