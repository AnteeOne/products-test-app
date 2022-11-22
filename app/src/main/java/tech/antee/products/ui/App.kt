package tech.antee.products.ui

import android.app.Application
import tech.antee.products.di.AppProvider
import tech.antee.products.di.DaggerAppComponent

class App : Application() {

    lateinit var appProvider: AppProvider

    override fun onCreate() {
        super.onCreate()
        appProvider = DaggerAppComponent.factory().create(this).apply {
            inject(this@App)
        }
    }
}

val Application.appProvider: AppProvider
    get() = (this as App).appProvider
