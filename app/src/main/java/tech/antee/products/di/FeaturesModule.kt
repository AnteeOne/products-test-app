package tech.antee.products.di

import dagger.Module
import tech.antee.products.features.product_details.impl.di.ProductDetailsFeatureModule
import tech.antee.products.features.product_list.impl.di.ProductListFeatureModule

@Module(
    includes = [
        ProductListFeatureModule::class,
        ProductDetailsFeatureModule::class
    ]
)
interface FeaturesModule
