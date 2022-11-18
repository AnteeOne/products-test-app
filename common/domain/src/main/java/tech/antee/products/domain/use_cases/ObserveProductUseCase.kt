package tech.antee.products.domain.use_cases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull
import tech.antee.products.domain.models.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ObserveProductUseCase @Inject constructor(
    private val observeProductsUseCase: ObserveProductsUseCase
) {

    operator fun invoke(id: String): Flow<Product> = observeProductsUseCase()
        .mapNotNull { products -> products.firstOrNull { it.id == id } }
}
