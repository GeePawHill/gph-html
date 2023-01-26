import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"

    // publishing
    `maven-publish`
    signing
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

/**
 * Publishing support
 */

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name.set("gph-html")
                description.set("An ultra-light change-friendly dsl for generating html output.")
                url.set("https://github.com/GeePawHill/gph-html")
                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://github.com/GeePawHill/gph-html/blob/main/LICENSE")
                    }
                }
                developers {
                    developer {
                        id.set("GeePawHill")
                        name.set("GeePaw Hill")
                        email.set("GeePawHill@geepawhill.org")
                    }
                }
                scm {
                    connection.set("git@github.com:GeePawHill/gph-html.git")
                    developerConnection.set("git@github.com:GeePawHill/gph-html.git")
                    url.set("https://github.com/GeePawHill/gph-html.git")
                }
            }

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

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["mavenJava"])
}
