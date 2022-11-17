package tech.antee.products

import android.app.Application
import tech.antee.products.di.AppProvider

// TODO("Implement your app")
class ProductsApp : Application() {

    lateinit var appProvider: AppProvider

//    override fun onCreate() {
//        super.onCreate()
//        appProvider = DaggerProductsAppComponent.factory().create(this).apply {
//            inject(this@App)
//        }
//    }
}

val Application.appProvider: AppProvider
    get() = (this as ProductsApp).appProvider