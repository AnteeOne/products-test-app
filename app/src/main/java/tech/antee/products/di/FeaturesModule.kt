package tech.antee.products.di

import dagger.Module
import tech.antee.products.product_list.impl.di.ProductListFeatureModule

@Module(
    includes = [
        ProductListFeatureModule::class
    ]
)
interface FeaturesModule
