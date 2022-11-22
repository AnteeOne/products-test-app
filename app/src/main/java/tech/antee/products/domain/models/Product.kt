package tech.antee.products.domain.models

data class Product(
    val id: String,
    val name: String,
    val description: String?,
    val image: String?,
    val price: Int
)
