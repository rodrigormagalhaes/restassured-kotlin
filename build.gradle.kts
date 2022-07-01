import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
}

repositories {
    mavenCentral()
}

java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    testImplementation("io.rest-assured:rest-assured:5.1.1")
    testImplementation("io.rest-assured:kotlin-extensions:5.1.1")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    testImplementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("profile", System.getProperty("profile"))
}
