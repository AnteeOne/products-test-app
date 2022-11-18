package tech.antee.products.domain.use_cases

import tech.antee.products.domain.repositories.ProductsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeleteProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {

    suspend operator fun invoke(ids: List<String>): Unit = productsRepository.delete(ids)
}
