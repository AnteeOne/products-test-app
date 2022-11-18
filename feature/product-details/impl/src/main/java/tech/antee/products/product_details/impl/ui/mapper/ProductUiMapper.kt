package tech.antee.products.product_details.impl.ui.mapper

import tech.antee.products.domain.models.Product
import tech.antee.products.product_details.impl.ui.items.ProductItem
import javax.inject.Inject

class ProductUiMapper @Inject constructor() {

    fun mapFromDomain(model: Product): ProductItem = with(model) {
        ProductItem(
            id = id,
            name = name,
            description = description,
            image = image,
            price = price
        )
    }
}
