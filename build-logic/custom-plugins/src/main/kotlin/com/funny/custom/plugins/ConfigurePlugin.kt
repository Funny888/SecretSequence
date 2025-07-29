package com.funny.custom.plugins

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ConfigurePlugin : Plugin<Project> {
    override fun apply(project: Project) = project.commonGradleSettings()


    private fun Project.commonGradleSettings() {
        plugins.run {
            apply("com.android.library")
            apply("kotlin-android")
        }
        androidConfigureFunny()
    }

    private fun Project.androidConfigureFunny() {
        extensions.configure<LibraryExtension>() {
            compileSdk = 35

            defaultConfig {
                minSdk = 29
            }

            buildFeatures {
                compose = true
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }
        }
    }

}