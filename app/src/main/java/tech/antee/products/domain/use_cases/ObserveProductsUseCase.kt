package tech.antee.products.domain.use_cases

import kotlinx.coroutines.flow.Flow
import tech.antee.products.domain.models.Product
import tech.antee.products.domain.repositories.ProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ObserveProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {

    operator fun invoke(): Flow<List<Product>> = productsRepository.productsFlow
}
