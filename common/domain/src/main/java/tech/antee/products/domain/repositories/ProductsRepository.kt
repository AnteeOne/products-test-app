package tech.antee.products.domain.repositories

import kotlinx.coroutines.flow.Flow
import tech.antee.products.domain.models.Product

interface ProductsRepository {

    val productsFlow: Flow<List<Product>>

    fun delete(id: String)
}
