package tech.antee.products.product_list.impl.ui.items

sealed interface Event {
    data class OnNavToDetails(val id: String) : Event
}
