package tech.antee.products.domain.repositories

import kotlinx.coroutines.flow.Flow
import tech.antee.products.domain.models.Product

interface ProductsRepository {

    val productsFlow: Flow<List<Product>>

    suspend fun fetch()

    suspend fun delete(id: String)

    suspend fun delete(ids: List<String>)
}
