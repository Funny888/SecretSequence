plugins {
  `kotlin-dsl`
  `java-gradle-plugin`
}


gradlePlugin.plugins.register("configurePlugin"){
  id = "funny-configure"
  implementationClass = "com.funny.custom.plugins.ConfigurePlugin"
}

dependencies {
  implementation(libs.android.gradle.plugin)
  implementation(libs.kotlin.gradle.plugin)
}