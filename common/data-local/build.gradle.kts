plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
}

dependencies {
    projectImplementation(Modules.coreUtils)
    projectApi(Modules.commonDomain)
    projectImplementation(Modules.commonDi)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Coroutines.kotlinCore)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
