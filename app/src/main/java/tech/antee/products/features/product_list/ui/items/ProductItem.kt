package tech.antee.products.features.product_list.ui.items

data class ProductItem(
    val id: String,
    val name: String,
    val description: String?,
    val image: String?,
    val price: Int,
    val isChecked: Boolean
)
