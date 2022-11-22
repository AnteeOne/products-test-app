package tech.antee.products.features.product_details.di

import dagger.BindsInstance
import dagger.Component
import tech.antee.products.common.di.scopes.FeatureScope
import tech.antee.products.features.product_details.di.qualifiers.ProductId
import tech.antee.products.features.product_details.ui.ProductDetailsViewModel

@FeatureScope
@Component(
    modules = [ProductDetailsModule::class],
    dependencies = [ProductDetailsDependencies::class]
)
interface ProductDetailsComponent {

    val viewModel: ProductDetailsViewModel

    @Component.Factory
    interface Factory {
        fun create(
            deps: ProductDetailsDependencies,
            @ProductId
            @BindsInstance
            productId: String
        ): ProductDetailsComponent
    }
}
