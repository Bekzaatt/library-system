plugins {
    kotlin("jvm") version "1.9.22"
    application
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(17)
}
