package tech.antee.products.data.local.sources

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import tech.antee.products.data.local.mock.ProductDto
import tech.antee.products.data.local.mock.Stubs
import javax.inject.Inject

class ProductsMockLocalSourceImpl @Inject constructor() : ProductsLocalSource {

    private val _productsFlow: MutableStateFlow<List<ProductDto>> = MutableStateFlow(emptyList())

    override val productsFlow: Flow<List<ProductDto>> = _productsFlow
        .onStart {
            delay(DATA_LOADING_DELAY)
            emit(Stubs.products)
        }
        .distinctUntilChanged()

    override fun delete(id: String) {
        _productsFlow.update { oldList ->
            oldList.filter { productDto -> productDto.id != id }
        }
    }

    private companion object {
        const val DATA_LOADING_DELAY = 2_000L
    }
}
