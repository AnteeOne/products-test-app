package tech.antee.products.features.product_details.impl.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import tech.antee.products.features.product_details.api.ProductDetailsFeature
import tech.antee.products.features.product_details.impl.ui.ProductDetailsFeatureImpl
import tech.antee.products.multi_compose.Feature
import tech.antee.products.multi_compose.di.FeatureKey
import javax.inject.Singleton

@Module
interface ProductDetailsFeatureModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureKey(ProductDetailsFeature::class)
    fun productDetailsFeature(feature: ProductDetailsFeatureImpl): Feature
}
