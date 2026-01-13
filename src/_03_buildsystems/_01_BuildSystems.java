/*
 * Build Systems
 * - This document explains common build systems and approaches used to compile, manage dependencies, and package Java
 *   applications. It covers Manual Builds, IDE-managed builds, Maven, and Gradle.
 *
 * Overview
 * - A build system automates or standardizes the process of:
 *   - Compiling source code
 *   - Managing dependencies (libraries and modules)
 *   - Running tests
 *   - Packaging applications (JAR, WAR, etc.)
 * - The choice of build system depends on project size, complexity, and team workflow.
 *
 * Manual Build
 * - Manual builds are suitable for small or simple projects and rely only on the JDK and command-line tools.
 * - Process:
 *   - Compile Java files with "javac"
 *   - Run the application with "java"
 *   - Manage dependencies manually by placing JAR files in a folder (e.g., "/lib") and updating the classpath
 *   - Place compiled ".class" files in an output folder like "/bin" or "/out"
 * - Pros:
 *   - Simple and direct, minimal setup
 *   - Full control over compilation and runtime
 * - Cons:
 *   - Tedious for projects with multiple dependencies
 *   - Error-prone as project complexity grows
 *
 * IDE Build
 * - IDE builds are managed directly by integrated development environments such as IntelliJ IDEA, Eclipse, or NetBeans.
 * - The IDE handles compilation, execution, and sometimes dependency management automatically.
 * - Process:
 *   - Configure source roots and resource paths in the IDE
 *   - IDE compiles code automatically on save or on demand
 *   - Run and debug applications within the IDE without manually invoking commands
 * - Pros:
 *   - Fast setup, convenient for development and testing
 *   - Provides advanced features like auto-completion, refactoring, and debugging
 * - Cons:
 *   - Less transparent than command-line builds
 *   - Build behavior may differ from Maven/Gradle if not aligned with project standards
 *
 * Maven
 * - Maven is a declarative build and dependency management tool widely used in enterprise Java projects.
 * - Features:
 *   - Uses a "pom.xml" to define project dependencies, plugins, packaging, and directories
 *   - Standard directory structure:
 *     - "src/main/java" -> production code
 *     - "src/main/resources" -> production resources
 *     - "src/test/java" -> test code
 *     - "src/test/resources" -> test resources
 *   - Handles transitive dependencies automatically
 *   - Provides consistent commands: "mvn compile", "mvn test", "mvn package"
 * - Pros:
 *   - Standardized structure and conventions
 *   - Enterprise-friendly and widely adopted
 *   - Simplifies dependency management
 * - Cons:
 *   - XML can be verbose
 *   - Less flexible for custom build logic
 *
 * Gradle
 * - Gradle is a modern, flexible build automation tool supporting Java and other JVM languages.
 * - Features:
 *   - Uses Groovy or Kotlin DSL ("build.gradle" or "build.gradle.kts")
 *   - Combines Maven-style conventions with scripting flexibility
 *   - Supports multi-module projects efficiently
 *   - Efficient incremental builds
 * - Common tasks:
 *   - "gradle build" -> compile, test, package
 *   - "gradle test" -> run tests
 *   - "gradle clean" -> clean output directories
 * - Pros:
 *   - Highly flexible and configurable
 *   - Faster incremental builds
 *   - Ideal for complex or multi-module projects
 * - Cons:
 *   - Slightly steeper learning curve
 *   - Build scripts require understanding of DSL and tasks
 *
 * Summary
 * - Manual Build: Command-line compilation with full control, suitable for small projects.
 * - IDE Build: Automated by the IDE, convenient for development and debugging.
 * - Maven: Declarative, convention-based, enterprise-friendly, simplifies dependency management.
 * - Gradle: Flexible, fast, and modern; excellent for complex, multi-module, or highly customized builds.
 * - All approaches rely on the JDK for compilation and runtime, but differ in automation, dependency handling, and
 *   scalability.
 */
void main() {}