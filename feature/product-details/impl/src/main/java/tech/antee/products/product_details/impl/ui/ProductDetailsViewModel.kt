package tech.antee.products.product_details.impl.ui

import kotlinx.coroutines.flow.MutableStateFlow
import tech.antee.products.domain.use_cases.ObserveProductUseCase
import tech.antee.products.product_details.impl.di.qualifiers.ProductId
import tech.antee.products.product_details.impl.ui.items.Action
import tech.antee.products.product_details.impl.ui.items.Event
import tech.antee.products.product_details.impl.ui.items.UiState
import tech.antee.products.product_details.impl.ui.mapper.ProductUiMapper
import tech.antee.products.ui.common.BaseViewModel
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    @ProductId private val productId: String,
    private val observeProductUseCase: ObserveProductUseCase,
    private val productUiMapper: ProductUiMapper
) : BaseViewModel<UiState, Event, Action>() {

    override val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.empty())

    init {
        observeProduct()
    }

    override fun onAction(action: Action) {
        when (action) {
            Action.OnBackButtonClick -> emitEvent(Event.OnNavBack)
        }
    }

    private fun observeProduct() {
        launchSafely {
            observeProductUseCase(productId)
                .collect { product ->
                    updateState { it.withSuccess(productUiMapper.mapFromDomain(product)) }
                }
        }
    }
}
