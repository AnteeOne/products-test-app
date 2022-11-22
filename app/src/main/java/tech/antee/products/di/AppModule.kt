package tech.antee.products.di

import dagger.Module
import tech.antee.products.common.data.di.DataModule

@Module(
    includes = [DataModule::class]
)
interface AppModule
