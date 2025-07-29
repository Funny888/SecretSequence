plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.funny.config)
}
android {
  namespace = "com.funny.splash.screen"
}

dependencies {
  implementation(project(":local-ds"))
}