package tech.antee.products.product_list.impl.ui

import kotlinx.coroutines.flow.MutableStateFlow
import tech.antee.products.domain.use_cases.DeleteProductsUseCase
import tech.antee.products.domain.use_cases.FetchProductsUseCase
import tech.antee.products.domain.use_cases.ObserveProductsUseCase
import tech.antee.products.product_list.impl.ui.items.Action
import tech.antee.products.product_list.impl.ui.items.Event
import tech.antee.products.product_list.impl.ui.items.UiState
import tech.antee.products.product_list.impl.ui.mappers.ProductUiMapper
import tech.antee.products.ui.common.BaseViewModel
import javax.inject.Inject

class ProductListViewModel @Inject constructor(
    private val observeProductsUseCase: ObserveProductsUseCase,
    private val fetchProductsUseCase: FetchProductsUseCase,
    private val deleteProductsUseCase: DeleteProductsUseCase,
    private val productUiMapper: ProductUiMapper
) : BaseViewModel<UiState, Event, Action>() {

    override val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.empty())

    init {
        observeProducts()
        fetchProducts()
    }

    override fun onAction(action: Action) {
        when (action) {
            is Action.OnItemClick -> emitEvent(Event.OnNavToDetails(action.id))
            is Action.OnItemCheckboxClick -> checkItem(action.id)
            is Action.OnDeleteButtonClick -> deleteProducts()
        }
    }

    private fun checkItem(id: String) {
        launchSafely {
            updateState {
                it.withCheckedProduct(id)
            }
        }
    }

    private fun deleteProducts() {
        launchSafely(
            onLoading = { isLoading -> updateState { it.withLoading(isLoading) } }
        ) {
            deleteProductsUseCase(
                ids = uiState.value.products
                    .filter { it.isChecked }
                    .map { it.id }
            )
        }
    }

    private fun fetchProducts() {
        launchSafely(
            onLoading = { isLoading -> updateState { it.withLoading(isLoading) } }
        ) {
            fetchProductsUseCase()
        }
    }

    private fun observeProducts() {
        launchSafely {
            observeProductsUseCase().collect { products ->
                updateState { it.withSuccess(products.map(productUiMapper::mapFromDomain)) }
            }
        }
    }
}
