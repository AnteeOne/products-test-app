package tech.antee.products.product_list.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.products.multi_compose.Feature
import tech.antee.products.multi_compose.di.FeatureKey
import tech.antee.products.product_list.api.ProductListFeature
import tech.antee.products.product_list.impl.ui.ProductListFeatureImpl
import javax.inject.Singleton

@Module
interface ProductListFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductListFeature::class)
    fun bookSearchFeature(feature: ProductListFeatureImpl): Feature
}
