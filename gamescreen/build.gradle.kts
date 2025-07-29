plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.funny.config)
}

android {
    namespace = "com.funny.gamescreen"
}

dependencies {
    implementation(project(":local-ds"))
}