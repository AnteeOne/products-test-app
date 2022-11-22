package tech.antee.products.features.product_details.impl.ui.items

data class ProductDetailsUiState(
    val product: ProductDetailsItem?,
    val isLoading: Boolean,
    val isError: Boolean
) {

    fun withLoading(isLoading: Boolean) = copy(isLoading = isLoading)

    fun withSuccess(product: ProductDetailsItem) = copy(
        product = product,
        isError = false
    )

    fun withError() = copy(isError = true)

    companion object {

        fun empty(): ProductDetailsUiState = ProductDetailsUiState(
            product = null,
            isLoading = false,
            isError = false
        )
    }
}
