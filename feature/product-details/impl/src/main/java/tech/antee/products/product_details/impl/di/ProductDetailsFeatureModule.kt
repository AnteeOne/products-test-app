package tech.antee.products.product_details.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.products.multi_compose.Feature
import tech.antee.products.multi_compose.di.FeatureKey
import tech.antee.products.product_details.api.ProductDetailsFeature
import tech.antee.products.product_details.impl.ui.ProductDetailsFeatureImpl
import javax.inject.Singleton

@Module
interface ProductDetailsFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductDetailsFeature::class)
    fun productDetailsFeature(feature: ProductDetailsFeatureImpl): Feature
}
