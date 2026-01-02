/*
Maven Overview
This document explains what Maven is, how it works, and provides an example of a basic pom.xml configuration.

What is Maven
- Maven is a build automation and dependency management tool for Java projects.
- It simplifies building, testing, and packaging Java applications.
- Maven follows a "convention-over-configuration" approach, providing standard directory layouts and lifecycle
  management.
- Dependencies and plugins are automatically downloaded from central repositories and managed via the project
  descriptor.

Key Concepts
- Project Object Model (POM): The XML file ("pom.xml") that defines the project structure, dependencies, plugins, and
  build instructions.
- Standard Directory Layout:
  - "src/main/java": Java source code
  - "src/main/resources": application resources
  - "src/test/java": test source code
  - "src/test/resources": test resources
- Lifecycle:
  - "compile": compile source code
  - "test": run unit tests
  - "package": create JAR or WAR
  - "install": install artifact to local repository
  - "deploy": deploy artifact to remote repository

Example pom.xml
A minimal pom.xml for a Java project:
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>myapp</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <!-- Example dependency -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>3.2.0</version>
        </dependency>
    </dependencies>
</project>

Commands
- "mvn compile": compiles the source code
- "mvn test": runs unit tests
- "mvn package": creates a JAR or WAR file
- "mvn clean": deletes target/ folder
- "mvn install": installs the artifact to the local repository
- "mvn deploy": deploys the artifact to a remote repository

Project Structure Example
MyProject          | Project
|- src             |
   |- main         |
      |- java      | Default Maven Source Root
      |- resources | Default Maven Resource Root
   |- test         |
      |- java      | Default Maven Test Source Root
      |- resources | Default Maven Test Resource Root
|- target          | Output Maven Directory
|- pom.xml         | Project Object Model

Summary
- Maven automates builds and manages dependencies for Java projects.
- Uses "pom.xml" to define project structure, dependencies, and build plugins.
- Enforces standard project layout and lifecycle.
- Widely used in enterprise applications and modern Java projects.
*/
void main() {}