/*
 * Maven
 * - This document explains what Maven is, how it works, and provides a detailed overview of its concepts, lifecycle,
 *   and project structure.
 *
 * Overview
 * - Maven is a build automation and dependency management tool for Java projects.
 * - It simplifies compilation, testing, packaging, and deployment of applications.
 * - Maven follows a convention-over-configuration philosophy:
 *   - Provides a standard directory layout
 *   - Defines a structured build lifecycle
 *   - Manages dependencies and plugins automatically from central repositories
 * - By standardizing builds, Maven ensures consistent project setup across teams and environments.
 *
 * Key Concepts
 *
 * 1. Project Object Model (POM)
 * - The core of Maven is the pom.xml file:
 *   - Defines project metadata (groupId, artifactId, version)
 *   - Declares dependencies and repositories
 *   - Configures build plugins, profiles, and packaging instructions
 * - Example minimal POM:
 *   <project xmlns="...">
 *       <modelVersion>4.0.0</modelVersion>
 *       <groupId>com.example</groupId>
 *       <artifactId>myapp</artifactId>
 *       <version>1.0-SNAPSHOT</version>
 *       <dependencies>
 *           <dependency>
 *               <groupId>org.springframework.boot</groupId>
 *               <artifactId>spring-boot-starter-web</artifactId>
 *               <version>3.2.0</version>
 *           </dependency>
 *       </dependencies>
 *   </project>
 *
 * 2. Standard Directory Layout
 * - Maven enforces a conventional project structure for consistency:
 *   - "src/main/java" -> production source code
 *   - "src/main/resources" -> production resources (configuration files, templates, images)
 *   - "src/test/java" -> test source code
 *   - "src/test/resources" -> test resources
 *   - "target/" -> output directory for compiled classes, packaged JARs/WARs, and generated reports
 *   - "pom.xml" -> project descriptor (POM)
 * - Benefits:
 *   - IDEs, build tools, and CI/CD pipelines automatically recognize these folders
 *   - Reduces configuration and setup time
 *
 * 3. Maven Lifecycle
 * - Maven provides a predefined build lifecycle with standard phases:
 *   - "validate" -> checks if project is correct and all necessary information is available
 *   - "compile" -> compiles source code into ".class" files
 *   - "test" -> runs unit tests (usually with JUnit)
 *   - "package" -> creates JAR, WAR, or other specified package
 *   - "verify" -> runs integration tests and checks
 *   - "install" -> installs the artifact to the local Maven repository (~/.m2/repository)
 *   - "deploy" -> deploys the artifact to a remote repository for sharing with other developers or projects
 * - Common commands:
 *   - "mvn compile" -> compile source code
 *   - "mvn test" -> run tests
 *   - "mvn package" -> create package (JAR/WAR)
 *   - "mvn clean" -> delete "target/" directory
 *   - "mvn install" -> install artifact locally
 *   - "mvn deploy" -> deploy to remote repository
 *
 * 4. Dependency Management
 * - Dependencies are defined in "pom.xml" under the "<dependencies>" section.
 * - Maven automatically downloads required libraries and their transitive dependencies from central repositories.
 * - Repositories can be central (Maven Central), company-specific, or local.
 * - Benefits:
 *   - Eliminates manual JAR handling
 *   - Avoids version conflicts using dependency mediation
 *   - Ensures reproducible builds across machines and teams
 *
 * 5. Plugins and Build Customization
 * - Maven build behavior is extended through plugins.
 * - Common plugins:
 *   - "maven-compiler-plugin" -> configures Java compiler version
 *   - "maven-surefire-plugin" -> runs unit tests
 *   - "maven-jar-plugin" -> creates JAR files
 *   - "maven-war-plugin" -> creates WAR files for web applications
 * - Plugins are declared in the "<build>" section of the POM
 * - Custom build goals can be defined and executed via Maven commands
 *
 * Project Structure Example
 * - my-maven-project
 *   |- src
 *   |  |- main
 *   |  |  |- java                       // Default Maven Source Root
 *   |  |  |  |- com/example
 *   |  |  |     |- MyClassA.java
 *   |  |  |- resources                  // Default Maven Resource Root
 *   |  |- test
 *   |     |- java                       // Default Maven Test Source Root
 *   |     |  |- com/example
 *   |     |     |- MyClassATest.java
 *   |     |- resources                  // Default Maven Test Resource Root
 *   |- target                           // Output directory for compiled classes and artifacts
 *   |- pom.xml                          // Project Object Model (POM)
 *
 * Advantages of Maven
 * - Automates compilation, testing, packaging, and deployment
 * - Standardizes project structure and build process
 * - Handles dependencies and transitive dependencies automatically
 * - Widely adopted in enterprise and modern Java projects
 * - Integrates seamlessly with IDEs, CI/CD pipelines, and repositories
 *
 * Limitations
 * - XML configuration can be verbose
 * - Less flexible than Gradle for highly customized builds
 * - Requires understanding of Maven lifecycle and conventions
 *
 * Summary
 * - Maven is a declarative, convention-based build and dependency management tool for Java projects.
 * - Uses "pom.xml" to define project metadata, dependencies, plugins, and build instructions.
 * - Enforces standard directory layout and lifecycle, providing reproducible and maintainable builds.
 * - Ideal for enterprise applications, large projects, and teams seeking consistent builds and dependency management.
 */
void main() {}