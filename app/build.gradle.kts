plugins {
    id(Plugins.androidApplication)
    id(Plugins.androidBase)
    id(Plugins.compose)
    id(Plugins.kotlinKapt)
}

android {
    defaultConfig {
        applicationId = AppConfig.applicationId
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName
    }
}

dependencies {
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.foundation)
    implementation(Deps.Compose.material)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.toolsPreview)
    implementation(Deps.Compose.koil)
    debugImplementation(Deps.Compose.tools)

    implementation(Deps.appCompat)
    implementation(Deps.coreKtx)
    implementation(Deps.material)
    implementation(Deps.constraintLayout)
    implementation(Deps.Compose.navigation)

    implementation(Deps.Coroutines.kotlinCore)

    implementation(Deps.Dagger.core)
    kapt(Deps.Dagger.compiler)

    testImplementation(Deps.Test.androidJUnit)
    androidTestImplementation(Deps.Test.espresso)
    androidTestImplementation(Deps.Test.jUnit)
}
