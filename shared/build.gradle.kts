plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}



@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    androidTarget()
    iosArm64()
    iosSimulatorArm64()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.animation)
                implementation(compose.material)
                implementation("app.cash.paging:paging-compose-common:3.3.0-alpha02-0.4.0")
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api(compose.materialIconsExtended)
                api("io.github.qdsfdhvh:image-loader:1.7.1")

                val tlaster = "1.5.7"
                api("moe.tlaster:precompose:$tlaster")
                api("moe.tlaster:precompose-viewmodel:$tlaster")

                implementation("io.ktor:ktor-client-json:2.3.6")
                implementation("io.ktor:ktor-client-core:2.3.6")
                implementation("io.ktor:ktor-client-logging:2.3.6")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.6")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.6")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        iosMain {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.6")
                implementation("io.ktor:ktor-client-ios:2.3.6")
            }
        }
    }
}

android {
    namespace = "com.AmirHusseinSoori.attackOnTitan"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    dependencies {
        api(compose.runtime)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

