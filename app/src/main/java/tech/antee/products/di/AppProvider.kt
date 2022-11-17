package tech.antee.products.di

import androidx.compose.runtime.compositionLocalOf
import tech.antee.products.multi_compose.Destinations

interface AppProvider {
    val destinations: Destinations
}

val LocalAppProvider = compositionLocalOf<AppProvider> { error("No app provider found!") }
