plugins {
    kotlin("jvm") version "2.3.21"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

kotlin {
    jvmToolchain(25)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.mockito.kotlin:mockito-kotlin:6.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.0")
}

tasks.test {
    useJUnitPlatform()
}