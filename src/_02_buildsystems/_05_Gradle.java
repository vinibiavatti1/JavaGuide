/*
Gradle
- This document explains what Gradle is, how it works, and provides a detailed overview of its concepts, tasks, and
  project structure.

Overview
- Gradle is a flexible and modern build automation tool for Java and other JVM languages (Kotlin, Scala, Android, etc.).
- Simplifies compilation, testing, packaging, and dependency management.
- Unlike XML-based tools (like Maven), Gradle uses programmable build scripts in Groovy (build.gradle) or Kotlin DSL
  (build.gradle.kts), providing more flexibility and control.
- Dependencies and plugins are automatically resolved from repositories such as Maven Central, JCenter, or custom
  repositories.

Key Concepts

1. Build Script
- The build script defines the project’s dependencies, plugins, and build instructions.
- Common files:
  - build.gradle -> Groovy DSL
  - build.gradle.kts -> Kotlin DSL
- Typical sections:
  - plugins {} -> apply plugins like java, application, war
  - group / version -> define project coordinates
  - repositories {} -> define where to fetch dependencies
  - dependencies {} -> declare libraries for implementation, testing, or runtime
  - tasks {} -> define or configure custom tasks

2. Standard Directory Layout
- Gradle encourages the same layout as Maven for consistency:
  - src/main/java -> production source code
  - src/main/resources -> production resources (configuration files, templates, images)
  - src/test/java -> test source code
  - src/test/resources -> test resources
- Output directory:
  - build/ -> contains compiled classes, packaged artifacts (JAR/WAR), reports, and temporary files

3. Tasks
- Gradle is task-based; each build operation is a task that can be executed individually or as part of a lifecycle.
- Common built-in tasks:
  - build -> compile code, run tests, and package the application
  - test -> execute unit tests
  - clean -> delete the build/ directory
  - assemble -> generate JAR/WAR without running tests
- Developers can define custom tasks to extend or modify the build process:
  - Example: generate documentation, copy files, or run scripts

4. Dependency Management
- Dependencies are declared in the dependencies {} section of the build script.
- Example:
  implementation "org.springframework.boot:spring-boot-starter-web:3.2.0"
  testImplementation "org.junit.jupiter:junit-jupiter-api:5.10.0"
  testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.10.0"
- Gradle automatically resolves transitive dependencies and caches artifacts locally for faster builds.

Example build.gradle (Minimal)
plugins {
    id "java"
}
group = "com.example"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    implementation "org.springframework.boot:spring-boot-starter-web:3.2.0"
    testImplementation "org.junit.jupiter:junit-jupiter-api:5.10.0"
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.10.0"
}
tasks.test {
    useJUnitPlatform()
}

Commands
- "gradle build" -> compile, test, and package
- "gradle test" -> run unit tests only
- "gradle clean" -> delete build/ folder
- "gradle assemble" -> package artifacts without running tests
- Gradle supports incremental builds: only changed files are recompiled, improving speed

Project Structure Example
my-gradle-project
|- src
|  |- main
|  |  |- java                  // Default Gradle Source Root
|  |  |  |- com/example
|  |  |     |- MyClassA.java
|  |  |- resources             // Default Gradle Resource Root
|  |- test
|     |- java                  // Default Gradle Test Source Root
|     |  |- com/example
|     |     |- MyClassATest.java
|     |- resources             // Default Gradle Test Resource Root
|- build                       // Output directory for compiled classes and artifacts
|- build.gradle                // Gradle Build Script (Groovy DSL)
|- build.gradle.kts            // Optional Kotlin DSL script

Advantages of Gradle
- Flexible and programmable build process
- Supports standard and custom tasks
- Efficient incremental builds for faster compilation
- Handles dependencies and multi-module projects efficiently
- Integrates well with IDEs, CI/CD pipelines, and repositories
- Preferred for modern Java, Kotlin, Android, and multi-module applications

Limitations
- Slightly steeper learning curve for beginners due to scripting flexibility
- Build scripts can become complex for very large projects

Summary
- Gradle is a modern, flexible, and powerful build automation tool for JVM projects.
- Uses build scripts (build.gradle or build.gradle.kts) to declare dependencies, plugins, and tasks.
- Supports standard project layout, incremental builds, multi-module projects, and custom tasks.
- Ideal for modern applications, multi-module projects, and teams needing flexible and fast builds.
*/
void main() {}