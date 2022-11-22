package tech.antee.products.features.product_list.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.products.features.product_list.api.ProductListFeature
import tech.antee.products.features.product_list.impl.ui.ProductListFeatureImpl
import tech.antee.products.multi_compose.Feature
import tech.antee.products.multi_compose.di.FeatureKey
import javax.inject.Singleton

@Module
interface ProductListFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductListFeature::class)
    fun productListFeature(feature: ProductListFeatureImpl): Feature
}
