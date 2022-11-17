package tech.antee.products.product_list.impl.ui.items

data class ProductItem(
    val id: String,
    val name: String,
    val description: String?,
    val image: String?,
    val price: Int,
    val isChecked: Boolean
)
