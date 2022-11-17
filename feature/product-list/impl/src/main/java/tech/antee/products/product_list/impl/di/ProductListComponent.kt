package tech.antee.products.product_list.impl.di

import dagger.Component
import tech.antee.products.di.scopes.FeatureScope
import tech.antee.products.product_list.impl.ui.ProductListViewModel

@FeatureScope
@Component(
    modules = [ProductListModule::class],
    dependencies = [ProductListDependencies::class]
)
interface ProductListComponent {

    val viewModel: ProductListViewModel

    @Component.Factory
    interface Factory {
        fun create(deps: ProductListDependencies): ProductListComponent
    }
}
