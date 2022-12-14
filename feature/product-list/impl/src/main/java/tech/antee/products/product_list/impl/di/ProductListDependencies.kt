package tech.antee.products.product_list.impl.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.products.domain.use_cases.DeleteProductsUseCase
import tech.antee.products.domain.use_cases.FetchProductsUseCase
import tech.antee.products.domain.use_cases.ObserveProductsUseCase

interface ProductListDependencies {

    val observeProductsUseCase: ObserveProductsUseCase

    val fetchProductsUseCase: FetchProductsUseCase

    val deleteProductsUseCase: DeleteProductsUseCase
}

val LocalProductListDependencies = compositionLocalOf<ProductListDependencies> {
    error("No feature deps provider found!")
}
