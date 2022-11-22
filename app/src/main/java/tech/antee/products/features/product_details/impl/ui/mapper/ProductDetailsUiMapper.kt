package tech.antee.products.features.product_details.impl.ui.mapper

import tech.antee.products.domain.models.Product
import tech.antee.products.features.product_details.impl.ui.items.ProductDetailsItem
import javax.inject.Inject

class ProductDetailsUiMapper @Inject constructor() {

    fun mapFromDomain(model: Product): ProductDetailsItem = with(model) {
        ProductDetailsItem(
            id = id,
            name = name,
            description = description,
            image = image,
            price = price
        )
    }
}
