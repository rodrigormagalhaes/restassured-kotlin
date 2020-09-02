import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.0"
}

repositories {
    jcenter()
}

java.sourceCompatibility = JavaVersion.VERSION_13

dependencies {
    testImplementation("io.rest-assured:rest-assured-all:4.3.1")
    testImplementation("io.rest-assured:kotlin-extensions:4.3.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.6.2")

    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "13"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("profile", System.getProperty("profile"))
}