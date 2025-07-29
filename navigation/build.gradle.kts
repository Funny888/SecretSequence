plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.kotlin.serialization)
  alias(libs.plugins.funny.config)
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
}