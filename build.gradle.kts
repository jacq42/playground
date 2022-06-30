import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra["kotlinVersion"] = "1.6.20"
}

plugins {
    val kotlinVersion: String by project

    kotlin("jvm") version kotlinVersion
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation platform('org.jetbrains.kotlin:kotlin-bom')
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
}

val JVM_TARGET = "17"
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = JVM_TARGET
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    val category = System.getProperty("testCategory")
    useJUnitPlatform {
        includeTags(category)
    }
}
