package tech.antee.products.domain.use_cases

import tech.antee.products.domain.repositories.ProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FetchProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(): Unit = productsRepository.fetch()
}
