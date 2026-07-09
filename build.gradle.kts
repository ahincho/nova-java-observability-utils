plugins {
    id("java-library")
    id("maven-publish")
    id("net.nemerosa.versioning") version "4.0.1"
}

versioning {
    releaseMode = "snapshot"
    displayMode = "snapshot"
    dirty = { it }
    releaseBuild = false
}

group = "pe.edu.nova.java.libs"
version = findProperty("version") as String

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

repositories {
    mavenCentral()
}

tasks.javadoc {
    (options as StandardJavadocDocletOptions).apply {
        addStringOption("Xdoclint:all", "-quiet")
        encoding = "UTF-8"
        charSet = "UTF-8"
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ahincho/nova-java-spring-boot-observability-utils")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
