
plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = 34
    namespace = "com.motolink.android.contract"

    defaultConfig {
        minSdk = 16
    }

//    buildTypes {
//        create("release") {
//            postprocessing {
//                removeUnusedCode = false
//                removeUnusedResources = false
//                obfuscate = false
//                optimizeCode = false
//                proguardFile("proguard-rules.pro")
//            }
//        }
//    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    lint {
        targetSdk = 34
    }
    testOptions {
        targetSdk = 34
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0")
}
