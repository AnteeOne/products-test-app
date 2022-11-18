package tech.antee.products.di

import dagger.Module
import tech.antee.products.product_details.impl.di.ProductDetailsFeatureModule
import tech.antee.products.product_list.impl.di.ProductListFeatureModule

@Module(
    includes = [
        ProductListFeatureModule::class,
        ProductDetailsFeatureModule::class
    ]
)
interface FeaturesModule
