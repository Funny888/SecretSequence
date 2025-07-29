plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.funny.config)
}
android {
  namespace = "com.funny.local.ds"
}

dependencies {
  api(libs.androidx.foundation)
  api(libs.compose.material)
  api(libs.compose.ui)
  api(libs.compose.preview)
  debugApi(libs.compose.tooling)
  implementation(libs.androidx.runtime)
}