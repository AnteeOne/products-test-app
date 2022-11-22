package tech.antee.products.features.product_list.ui.items

data class UiState(
    val products: List<ProductItem>,
    val isLoading: Boolean,
    val isError: Boolean
) {

    fun withLoading(isLoading: Boolean) = copy(isLoading = isLoading)

    fun withSuccess(products: List<ProductItem>) = copy(
        products = products,
        isError = false
    )

    fun withCheckedProduct(id: String) = copy(
        products = products.map { oldProduct ->
            if (oldProduct.id == id) {
                oldProduct.copy(isChecked = !oldProduct.isChecked)
            } else {
                oldProduct
            }
        }
    )

    fun withError() = copy(isError = true)

    companion object {

        fun empty(): UiState = UiState(
            products = listOf(),
            isLoading = false,
            isError = false
        )
    }
}
