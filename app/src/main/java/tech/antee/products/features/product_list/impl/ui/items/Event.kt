package tech.antee.products.features.product_list.impl.ui.items

sealed interface Event {
    data class OnNavToDetails(val id: String) : Event
}
