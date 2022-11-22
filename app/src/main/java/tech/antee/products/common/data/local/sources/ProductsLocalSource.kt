package tech.antee.products.common.data.local.sources

import kotlinx.coroutines.flow.Flow
import tech.antee.products.common.data.local.mock.ProductDto

interface ProductsLocalSource {

    val productsFlow: Flow<List<ProductDto>>

    suspend fun fetch()

    suspend fun delete(id: String)

    suspend fun delete(ids: Set<String>)
}
