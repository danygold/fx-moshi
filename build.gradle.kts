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
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "com.github.danygold"
version = "1.0.0-SNAPSHOT"
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
    modules = listOf("javafx.base", "javafx.graphics")
}

repositories {
    mavenCentral()
}

dependencies {
    api("com.squareup.moshi:moshi:1.14.0")
    compileOnlyApi("org.jetbrains:annotations:23.1.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.getByName<Test>("test") {
    defaultCharacterEncoding = "UTF-8"
    useJUnitPlatform()
}