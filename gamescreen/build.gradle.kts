plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.funny.config)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.funny.gamescreen"
}

dependencies {
    implementation(project(":local-ds"))
    implementation(libs.dagger)
    implementation(libs.androidx.lifecycle.viewmodel.android)
    kapt(libs.dagger.compiler)

}