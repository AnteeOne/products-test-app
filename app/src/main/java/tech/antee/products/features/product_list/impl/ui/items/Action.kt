package tech.antee.products.features.product_list.impl.ui.items

sealed interface Action {

    data class OnItemClick(val id: String) : Action

    data class OnItemCheckboxClick(val id: String) : Action

    object OnDeleteButtonClick : Action
}
