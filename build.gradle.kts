import com.github.gradle.node.npm.task.NpmTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    extra["kotlinVersion"] = "1.6.20"
}

plugins {
    val kotlinVersion: String by project

    kotlin("jvm") version kotlinVersion
    id("com.github.node-gradle.node") version "7.0.2"
}

repositories {
    mavenCentral()
}

node {
    download.set(true)
    distBaseUrl.set("https://www.example.com/")
    version.set("20.14.0")
    nodeProjectDir.set(file("${project.projectDir}/frontend"))
}

tasks.register<NpmTask>("npmEsLint") {
    group = "frontend"
    description = "Runs eslint on frontend"

    dependsOn("npmInstall")
    args.addAll("run", "eslint")
}

tasks.register<NpmTask>("npmTest") {
    group = "frontend"
    description = "Runs frontend tests"

    dependsOn("npmInstall")
    args.addAll("run", "test")
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
