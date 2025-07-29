plugins {
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.funny.config)
}

android {
  namespace = "com.funny.main.screen"
}

dependencies {
  implementation(project(":local-ds"))
}