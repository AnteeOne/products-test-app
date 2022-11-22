package tech.antee.products.features.product_details.ui.items

sealed interface ProductDetailsEvent {
    object OnNavBack : ProductDetailsEvent
}
