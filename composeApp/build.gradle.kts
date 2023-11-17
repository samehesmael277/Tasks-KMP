import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.android.application)
    alias(libs.plugins.sqlDelight)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    jvm()

    js {
        browser()
        binaries.executable()
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(libs.composeImageLoader)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.moko.mvvm)
            implementation(libs.composeIcons.featherIcons)
            implementation(libs.koin.core)
            implementation(libs.coroutines.extensions)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.activityCompose)
            implementation(libs.compose.uitooling)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.sqlDelight.driver.android)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.common)
            implementation(compose.desktop.currentOs)
            implementation(libs.sqlDelight.driver.sqlite)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.sqlDelight.driver.js)
        }

        iosMain.dependencies {
            implementation(libs.sqlDelight.driver.native)
        }

    }
}

android {
    namespace = "com.sameh.taskskmp"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

        applicationId = "com.sameh.taskskmp.androidApp"
        versionCode = 1
        versionName = "1.0.0"
    }
    sourceSets["main"].apply {
        manifest.srcFile("src/androidMain/AndroidManifest.xml")
        res.srcDirs("src/androidMain/resources")
        resources.srcDirs("src/commonMain/resources")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}
dependencies {
    implementation(libs.androidx.work.runtime.ktx)
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.sameh.taskskmp.desktopApp"
            packageVersion = "1.0.0"
        }
    }
}

compose.experimental {
    web.application {}
}

sqldelight {
    databases {
        create("TasksDatabase") {
            // Database configuration here.
            // https://cashapp.github.io/sqldelight
            packageName.set("com.sameh.taskskmp.db")
//            sourceFolders(listOf("sqldelight"))
//            linkSqlite = true
//            generateAsync.set(true)
        }
    }
}
