/*
Gradle Overview
This document explains what Gradle is, how it works, and provides an example of a basic build.gradle configuration.

What is Gradle
- Gradle is a flexible build automation tool for Java and JVM projects, supporting Java, Kotlin, Android, and more.
- It simplifies building, testing, and packaging applications while managing dependencies automatically.
- Gradle uses a programmable build script written in Groovy or Kotlin DSL, allowing greater flexibility than XML-based
  tools.
- Dependencies and plugins are automatically downloaded from repositories and managed via the build script.

Key Concepts
- Build Script: The "build.gradle" (Groovy) or "build.gradle.kts" (Kotlin) file defines project dependencies, plugins,
  and build instructions.
- Standard Directory Layout:
  - "src/main/java": Java source code
  - "src/main/resources": application resources
  - "src/test/java": test source code
  - "src/test/resources": test resources
- Tasks:
  - "build": compile source code, run tests, and package the application
  - "test": run unit tests
  - "clean": delete build/ folder
  - "assemble": create JAR or WAR
  - "buildDependents" and other custom tasks defined in the build script

Example build.gradle
A minimal Gradle build script for a Java project:
plugins {
    id "java"
}
group = "com.example"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    // Example dependency
    implementation "org.springframework.boot:spring-boot-starter-web:3.2.0"
    testImplementation "org.junit.jupiter:junit-jupiter-api:5.10.0"
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:5.10.0"
}
tasks.test {
    useJUnitPlatform()
}

Commands
- "gradle build": compile source code, run tests, and package the application
- "gradle test": run unit tests
- "gradle clean": deletes the build/ folder
- "gradle assemble": generates JAR or WAR without running tests

Project Structure Example
MyProject          | Project
|- src             |
   |- main         |
      |- java      | Default Gradle Source Root
      |- resources | Default Gradle Resource Root
   |- test         |
      |- java      | Default Gradle Test Source Root
      |- resources | Default Gradle Test Resource Root
|- build           | Output Gradle Directory
|- build.gradle    | Gradle Build Script

Summary
- Gradle automates builds and manages dependencies for Java and JVM projects.
- Uses a programmable build script ("build.gradle" or "build.gradle.kts") to define dependencies, plugins, and tasks.
- Supports standard project layout and lifecycle tasks, as well as custom tasks.
- Popular for modern applications, multi-module projects, and incremental builds due to flexibility and speed.
*/
@SuppressWarnings("all")
void main() {}