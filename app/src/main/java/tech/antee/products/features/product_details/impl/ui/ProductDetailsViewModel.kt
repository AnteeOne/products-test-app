package tech.antee.products.features.product_details.impl.ui

import kotlinx.coroutines.flow.MutableStateFlow
import tech.antee.products.domain.use_cases.ObserveProductUseCase
import tech.antee.products.features.product_details.impl.di.qualifiers.ProductId
import tech.antee.products.features.product_details.impl.ui.items.ProductDetailsAction
import tech.antee.products.features.product_details.impl.ui.items.ProductDetailsEvent
import tech.antee.products.features.product_details.impl.ui.items.ProductDetailsUiState
import tech.antee.products.features.product_details.impl.ui.mapper.ProductDetailsUiMapper
import tech.antee.products.common.ui.BaseViewModel
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    @ProductId private val productId: String,
    private val observeProductUseCase: ObserveProductUseCase,
    private val productUiMapper: ProductDetailsUiMapper
) : BaseViewModel<ProductDetailsUiState, ProductDetailsEvent, ProductDetailsAction>() {

    override val _uiState: MutableStateFlow<ProductDetailsUiState> = MutableStateFlow(ProductDetailsUiState.empty())

    init {
        observeProduct()
    }

    override fun onAction(action: ProductDetailsAction) {
        when (action) {
            ProductDetailsAction.OnBackButtonClick -> emitEvent(ProductDetailsEvent.OnNavBack)
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
