package tech.antee.products.common.data.di

import dagger.Binds
import dagger.Module
import tech.antee.products.common.data.local.di.LocalModule
import tech.antee.products.common.data.repositories.ProductsRepositoryImpl
import tech.antee.products.domain.repositories.ProductsRepository
import javax.inject.Singleton

@Module(
    includes = [
        LocalModule::class
    ]
)
interface DataModule {

    @Binds
    @Singleton
    fun bindProductsRepository(impl: ProductsRepositoryImpl): ProductsRepository
}
