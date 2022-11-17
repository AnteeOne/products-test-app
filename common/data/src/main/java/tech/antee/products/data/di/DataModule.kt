package tech.antee.products.data.di

import dagger.Module
import tech.antee.products.data.local.di.LocalModule

@Module(
    includes = [
        LocalModule::class
    ]
)
interface DataModule
