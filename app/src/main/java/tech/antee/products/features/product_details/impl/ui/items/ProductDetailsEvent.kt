package tech.antee.products.features.product_details.impl.ui.items

sealed interface ProductDetailsEvent {
    object OnNavBack : ProductDetailsEvent
}
