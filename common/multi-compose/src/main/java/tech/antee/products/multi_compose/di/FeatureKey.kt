package tech.antee.products.multi_compose.di

import dagger.MapKey
import tech.antee.products.multi_compose.Feature
import kotlin.reflect.KClass

@MapKey
annotation class FeatureKey(val value: KClass<out Feature>)
