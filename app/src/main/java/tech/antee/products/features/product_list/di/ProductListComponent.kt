package tech.antee.products.features.product_list.di

import dagger.Component
import tech.antee.products.common.di.scopes.FeatureScope
import tech.antee.products.features.product_list.ui.ProductListViewModel

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
