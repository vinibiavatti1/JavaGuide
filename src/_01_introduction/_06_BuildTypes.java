/*
Build Types
This document explains the common build types and tools used to compile, manage dependencies, and package Java
applications.

Java (Manual Build)
Java Manual Build is a straightforward build process typically managed by the IDE, ideal for small projects with
manually handled dependencies.
- Using only the JDK and javac/java commands.
- Compilation is done manually by running "javac" on source files and "java" to execute.
- Dependencies are managed manually by placing JARs in a folder (commonly "/lib") and adding them to the classpath.
- Output is placed in a folder like "/bin" or "/out".
- Suitable for simple or small projects without complex dependencies.

Maven
Maven is a build automation and dependency management tool for Java projects, commonly used in standard enterprise
applications.
- A build automation and dependency management tool.
- Uses a "pom.xml" file to define:
  - Project dependencies
  - Build plugins
  - Packaging instructions (JAR, WAR)
  - Source and resource directories
- Standard project layout ("src/main/java", "src/main/resources", "src/test/java", etc.).
- Builds, tests, and packages the project using "mvn" commands:
  - "mvn compile"
  - "mvn test"
  - "mvn package"
- Handles transitive dependencies automatically.
- Common in enterprise and modern Java projects.

Gradle
Flexible and modern build automation tool for Java and JVM projects, popular in multi-module or complex modern
applications.
- A flexible build automation tool using Groovy or Kotlin DSL ("build.gradle" or "build.gradle.kts").
- Combines features of Maven (dependency management, conventions) with scripting flexibility.
- Example tasks:
  - "gradle build" // compile, test, and package
  - "gradle test"  // run tests
  - "gradle clean" // clean output directories
- Supports multi-module projects efficiently.
- Can work with Java, Kotlin, Android, and other JVM languages.
- Increasingly popular for new projects due to flexible configuration and faster incremental builds.
*/
@SuppressWarnings("all")
void main() {}