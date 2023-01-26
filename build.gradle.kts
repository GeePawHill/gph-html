import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"

    // publishing
    `maven-publish`
    id("io.github.gradle-nexus.publish-plugin") version "1.1.0"

    // Check for updates with ./gradlew dependencyUpdates
    id("com.github.ben-manes.versions") version "0.44.0"

    // Formatting & Style
    id("io.gitlab.arturbosch.detekt") version "1.22.0"

}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jsoup:jsoup:1.15.3")

    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")

    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")
}

val jvmVersion: JavaLanguageVersion = JavaLanguageVersion.of(17)
kotlin {
    jvmToolchain(jvmVersion.asInt())
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = jvmVersion.toString()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {  //only for users registered in Sonatype after 24 Feb 2021
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}

