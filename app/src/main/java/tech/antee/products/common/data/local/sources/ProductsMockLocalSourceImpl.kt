package tech.antee.products.common.data.local.sources

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import tech.antee.products.common.data.local.mock.ProductDto
import tech.antee.products.common.data.local.mock.Stubs
import javax.inject.Inject

class ProductsMockLocalSourceImpl @Inject constructor() : ProductsLocalSource {

    private val _productsFlow: MutableStateFlow<List<ProductDto>> = MutableStateFlow(emptyList())

    override val productsFlow: Flow<List<ProductDto>> = _productsFlow

    override suspend fun fetch() {
        delay(DATA_LOADING_DELAY)
        _productsFlow.emit(Stubs.products)
    }

    override suspend fun delete(id: String) {
        _productsFlow.update { oldList ->
            oldList.filter { productDto -> productDto.id != id }
        }
    }

    override suspend fun delete(ids: Set<String>) {
        _productsFlow.update { oldList ->
            delay(DATA_DELETE_DELAY)
            oldList.filter { productDto -> productDto.id !in ids }
        }
    }

    private companion object {
        const val DATA_LOADING_DELAY = 2_000L
        const val DATA_DELETE_DELAY = 1_000L
    }
}
