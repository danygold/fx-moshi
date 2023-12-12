/*
 * Copyright 2023 danygold
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("java-library")
    id("org.openjfx.javafxplugin") version "0.0.14"
    id("maven-publish")
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    signing
    jacoco
}

group = "io.github.danygold"
version = "1.1.0-SNAPSHOT"
description = "FX Moshi, a set of Moshi adapters to support serialization/deserialization of JavaFX properties."

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
    withJavadocJar()
    withSourcesJar()
}

javafx {
    version = "11"
    modules = listOf("javafx.base")
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.squareup.moshi:moshi:1.15.0")
    compileOnlyApi("org.jetbrains:annotations:24.1.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.getByName<Test>("test") {
    defaultCharacterEncoding = "UTF-8"
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

tasks.check {
    dependsOn(tasks.jacocoTestReport)
}

nexusPublishing {
    packageGroup.set("io.github.danygold")
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set(project.name)
                description.set(project.description)
                url.set("https://github.com/danygold/fx-moshi")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("daniele-vianini")
                        name.set("Daniele Vianini")
                        email.set("danidani95dani@gmail.com")
                        url.set("https://github.com/danygold")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/danygold/fx-moshi.git")
                    developerConnection.set("scm:git:git@github.com:danygold/fx-moshi.git")
                    url.set("https://github.com/danygold/fx-moshi")
                }
            }
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["maven"])
}
