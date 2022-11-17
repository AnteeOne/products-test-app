plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.kotlinKapt)
}

dependencies {
    projectApi(Modules.commonDomain)
    projectImplementation(Modules.coreUtils)
    projectImplementation(Modules.commonDi)
    projectImplementation(Modules.commonDataLocal)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.Coroutines.kotlinCore)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
