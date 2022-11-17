package tech.antee.products.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tech.antee.products.ProductsApp
import tech.antee.products.di.qualifiers.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, FeaturesModule::class])
interface AppComponent : AppProvider {

    fun inject(app: ProductsApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }
}
