package tech.antee.products.product_list.impl.ui.mappers

import tech.antee.products.domain.models.Product
import tech.antee.products.product_list.impl.ui.items.ProductItem
import javax.inject.Inject

class ProductUiMapper @Inject constructor() {

    fun mapFromDomain(model: Product): ProductItem = with(model) {
        ProductItem(
            id = id,
            name = name,
            description = description,
            image = image,
            price = price,
            isChecked = false
        )
    }
}
