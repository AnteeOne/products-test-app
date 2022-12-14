plugins {
    id(Plugins.androidLibrary)
    id(Plugins.androidBase)
    id(Plugins.compose)
    id(Plugins.kotlinKapt)
}

dependencies {
    projectImplementation(Modules.coreUi)
    projectImplementation(Modules.coreStrings)
    projectImplementation(Modules.commonDomain)
    projectImplementation(Modules.commonDi)
    projectImplementation(Modules.commonUi)
    projectImplementation(Modules.commonMultiCompose)

    projectApi(Modules.featureProductListApi)
    projectImplementation(Modules.featureProductDetailsApi)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.material)
    implementation(Deps.Coroutines.viewModel)
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.navigation)
    implementation(Deps.Compose.toolsPreview)
    implementation(Deps.Compose.tools)
    implementation(Deps.Compose.koil)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)
}
