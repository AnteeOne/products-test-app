object Versions {
    const val kotlin = "1.6.0"
    const val coroutine = "1.6.0"

    const val androidxAppcompat = "1.4.0"
    const val androidxCoreKtx = "1.7.0"
    const val androidxConstraint = "2.1.1"
    const val androidxNavigation = "2.4.2"

    const val material = "1.5.0-alpha04"

    const val dagger = "2.41"
    const val compose = "1.1.0-beta04"
    const val composeMaterial = "1.0.0-alpha02"
    const val koil = "2.1.0"

    const val junit = "4.12"
    const val androidxEspresso = "3.4.0"
    const val androidxCoreTesting = "1.1.3"

    const val gradle = "7.0.3"
}

object Deps {
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidxCoreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.androidxAppcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidxConstraint}"

    object Test {
        const val jUnit = "junit:junit:${Versions.junit}"
        const val androidJUnit = "androidx.test.ext:junit:${Versions.androidxCoreTesting}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"
    }

    object Gradle {
        const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    }

    object Coroutines {
        const val kotlinCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    }

    object Dagger {
        const val core = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.compose}"
        const val tools = "androidx.compose.ui:ui-tooling:${Versions.compose}"
        const val toolsPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
        const val material = "androidx.compose.material:material:${Versions.compose}"
        const val material3 = "androidx.compose.material3:material3:${Versions.composeMaterial}"
        const val activity = "androidx.activity:activity-compose:${Versions.androidxAppcompat}"
        const val navigation = "androidx.navigation:navigation-compose:${Versions.androidxNavigation}"
        const val jUnit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"
        const val koil = "io.coil-kt:coil-compose:${Versions.koil}"
    }
}
