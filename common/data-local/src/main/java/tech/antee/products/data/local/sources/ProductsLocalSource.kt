package tech.antee.products.data.local.sources

import kotlinx.coroutines.flow.Flow
import tech.antee.products.data.local.mock.ProductDto

interface ProductsLocalSource {

    val productsFlow: Flow<List<ProductDto>>

    fun delete(id: String)
}
