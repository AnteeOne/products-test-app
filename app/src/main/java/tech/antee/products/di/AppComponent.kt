package tech.antee.products.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tech.antee.products.common.di.qualifiers.ApplicationContext
import tech.antee.products.ui.App
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent : AppProvider {

    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context
        ): AppComponent
    }
}
