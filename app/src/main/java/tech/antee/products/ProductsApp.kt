package tech.antee.products

import android.app.Application
import tech.antee.products.di.AppProvider
import tech.antee.products.di.DaggerAppComponent

class ProductsApp : Application() {

    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()
        appProvider = DaggerAppComponent.factory().create(this).apply {
            inject(this@ProductsApp)
        }
    }
}

val Application.appProvider: AppProvider
    get() = (this as ProductsApp).appProvider
