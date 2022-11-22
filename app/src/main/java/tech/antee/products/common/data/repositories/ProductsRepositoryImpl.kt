package tech.antee.products.common.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import tech.antee.products.common.data.local.sources.ProductsLocalSource
import tech.antee.products.common.data.mappers.ProductDomainMapper
import tech.antee.products.domain.models.Product
import tech.antee.products.domain.repositories.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val productsLocalSource: ProductsLocalSource,
    private val productDomainMapper: ProductDomainMapper
) : ProductsRepository {

    override val productsFlow: Flow<List<Product>> = productsLocalSource
        .productsFlow
        .map(productDomainMapper::mapListFromData)

    override suspend fun fetch() = productsLocalSource.fetch()

    override suspend fun delete(id: String) = productsLocalSource.delete(id)

    override suspend fun delete(ids: List<String>) = productsLocalSource.delete(ids.toHashSet())
}
