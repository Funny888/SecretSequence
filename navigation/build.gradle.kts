plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.funny.config)
  alias(libs.plugins.kotlin.kapt)
}
android {
  namespace = "com.funny.navigation"
}

dependencies {
  implementation(project(":splashscreen"))
  implementation(project(":mainscreen"))
  implementation(project(":gamescreen"))
  implementation(project(":settingsscreen"))
  implementation(libs.androidx.navigation)

  implementation(libs.dagger)
  kapt(libs.dagger.compiler)
}