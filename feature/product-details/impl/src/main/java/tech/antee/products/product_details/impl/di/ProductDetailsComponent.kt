package tech.antee.products.product_details.impl.di

import dagger.BindsInstance
import dagger.Component
import tech.antee.products.di.scopes.FeatureScope
import tech.antee.products.product_details.impl.di.qualifiers.ProductId
import tech.antee.products.product_details.impl.ui.ProductDetailsViewModel

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
