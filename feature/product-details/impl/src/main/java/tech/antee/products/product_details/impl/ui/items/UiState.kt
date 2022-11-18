package tech.antee.products.product_details.impl.ui.items

data class UiState(
    val product: ProductItem?,
    val isLoading: Boolean,
    val isError: Boolean
) {

    fun withLoading(isLoading: Boolean) = copy(isLoading = isLoading)

    fun withSuccess(product: ProductItem) = copy(
        product = product,
        isError = false
    )

    fun withError() = copy(isError = true)

    companion object {

        fun empty(): UiState = UiState(
            product = null,
            isLoading = false,
            isError = false
        )
    }
}
