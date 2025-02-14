plugins {
    id ("org.jetbrains.kotlin.jvm") version "2.0.0"
}

group = "ru.netology.pusher"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    implementation ("com.google.firebase:firebase-admin:9.3.0")
    implementation ("org.slf4j:slf4j-simple:2.0.13")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}