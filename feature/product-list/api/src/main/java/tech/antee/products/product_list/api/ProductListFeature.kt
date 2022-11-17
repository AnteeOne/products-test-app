package tech.antee.products.product_list.api

import tech.antee.products.multi_compose.ComposableFeature

abstract class ProductListFeature : ComposableFeature {

    override val featureRoute: String = "product_list"
}
