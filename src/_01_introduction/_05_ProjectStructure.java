/*
Project Structure
This document explains the common structure of a Java project, including source roots, resource paths, and other
important directories. A well-defined project structure allows IDEs and build tools to know how to compile and package
the application correctly.

- Source Roots
  - A source root is a directory that contains "Java source code".
  - Files under source roots are compiled into ".class" files by the compiler.
  - Example: "src/main/java" is a standard source root for production code.
- Resource Paths
  - Resource paths contain "non-code files" used by the application, such as configuration files, images, and templates.
  - Files under resource paths are "copied as-is" to the output directory and are available in the classpath at runtime.
  - Example: "src/main/resources" is a common resource path.
- Test Source Roots
  - Directories containing test code are usually separated from main code.
  - Example: "src/test/java" for Java test classes, "src/test/resources" for test resources.
  - Allows IDEs and build tools to "compile and run tests separately" from production code.
- Test Resource Paths
  - Similar to main resource paths, but specifically for test resources.
  - Files here are available in the classpath "when running tests", but are not included in the production classpath.
  - Example: "src/test/resources" for configuration files, sample data, or templates used only during testing.
- Output Directories
  - Compiled `.class` files are placed in output directories such as `bin` or `out`.
  - Resource files are also copied here, preserving their structure relative to the source root.

Project Structure Example
MyProject          | Project
|- src             |
   |- main         |
      |- java      | Source Root
      |- resources | Resource Root
   |- test         |
      |- java      | Test Source Root
      |- resources | Test Resource Root
|- out             | Output Directory ("bin", "target", etc.)

Other Directories
- /WebContent or src/main/webapp: Used in "web projects" for web resources such as Servlets, JSPs, HTML, etc.
- /generated: Contains code automatically produced by "annotation processors".
- /target: Standard output folder used by "Maven and Gradle".
- /docs: Folder for project documentation, README files, or generated Javadoc.
- /scripts: Contains scripts for "build, deployment, or automation" tasks.
*/
void main() {}