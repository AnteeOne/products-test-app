package tech.antee.products.common.data.local.di

import dagger.Binds
import dagger.Module
import tech.antee.products.common.data.local.sources.ProductsLocalSource
import tech.antee.products.common.data.local.sources.ProductsMockLocalSourceImpl
import javax.inject.Singleton

@Module
interface DataSourcesModule {

    @Binds
    @Singleton
    fun bindProductsLocalSource(impl: ProductsMockLocalSourceImpl): ProductsLocalSource
}
