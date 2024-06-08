import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    `maven-publish`
    signing
}

group = "github.leavesczy.matisse.build.logic"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_11)
    }
}

dependencies {
    implementation(libs.android.gradle)
    implementation(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "matisse.android.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "matisse.android.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "matisse.android.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}