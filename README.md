# FX Moshi

![build](https://github.com/danygold/fx-moshi/actions/workflows/build.yml/badge.svg)
[![codecov](https://codecov.io/gh/danygold/fx-moshi/branch/master/graph/badge.svg)](https://codecov.io/gh/danygold/fx-moshi)
![release](https://img.shields.io/badge/version-1.0.0-yellow)
![license](https://img.shields.io/badge/License-Apache_2.0-blue)

FX Moshi is a set of [Moshi](https://github.com/square/moshi) adapters to support serialization/deserialization of
JavaFX properties.

## Download

You can manually download the JAR from
[Maven Central](https://repo1.maven.org/maven2/io/danygold/danygold/fx-moshi/), otherwise you can use a build tool

### Gradle

Kotlin

```kotlin
implementation("io.github.danygold:fx-moshi:1.0.0")
```

Groovy

```groovy
implementation "io.github.danygold:fx-moshi:1.0.0"
```

### Maven

```xml

<dependency>
  <groupId>io.github.danygold</groupId>
  <artifactId>fx-moshi</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Build requirements

- [Gradle](https://gradle.org/) - Build Tool
- JDK 11 or above

## Testing

The repository contains several unit and integration tests to guarantee high code quality and maintainability. The
chosen testing platform is [JUnit](https://junit.org/junit5/). Implemented test can be run from Gradle.

## Folder Structure Conventions

    .
    ├── .github                 # GitLab default configuration
    ├── src                     # Source files
    ├── ...
    └── build.gradle.kts

## Source files

Source files are stored in `src` folder with the following structure:

    .
    ├── ...
    ├── src                    
    │   ├── main
    │   │   └── java            # Java sources
    │   └── test                # Unit tests
    │       └── java            
    └── ...

## Contributing

Pull requests are welcome :blush: :fire:

For big contributions, new features or anything that is not a bug, please open first an issue.

## IntelliJ

* [VCS issue tracker for Git](https://www.jetbrains.com/help/idea/handling-issues.html)
  * RegEx: ```#([0-9]+)```
  * Replacement: ```https://github.com/danygold/fx-moshi/issues/$1```

## License

Code released under [Apache License 2.0](https://github.com/danygold/fx-moshi/blob/master/LICENSE)

    Copyright 2023 danygold

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
