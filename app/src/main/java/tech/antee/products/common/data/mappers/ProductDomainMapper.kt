package tech.antee.products.common.data.mappers

import tech.antee.products.common.data.local.mock.ProductDto
import tech.antee.products.domain.models.Product
import javax.inject.Inject

class ProductDomainMapper @Inject constructor() {

    fun mapFromData(productDto: ProductDto): Product = with(productDto) {
        Product(
            id = id,
            name = name,
            description = description,
            image = image,
            price = price
        )
    }

    fun mapListFromData(productDtos: List<ProductDto>) = productDtos.map { mapFromData(it) }
}
