/*
Manual Build
- This document explains how to manually build and run Java projects using only the JDK tools, without relying on build
  automation systems or IDEs.

Overview
- Manual builds are suitable for:
  - Small projects with few dependencies
  - Learning and understanding the Java compilation and execution process
  - Situations where full control over compilation and runtime is needed
- In a manual build, developers handle compilation, dependency management, and execution themselves.

Steps in Manual Build

1. Source Code Compilation
- Java source files (".java") are compiled into bytecode (".class") using the "javac" command.
- Basic usage:
  - "javac -d out src/com/example/MyProgram.java"
- Common options:
  - "-d <directory>": output directory for compiled classes
  - "-cp <classpath>": locations of external dependencies
  - "--module-path <path>": for modular projects

2. Managing Dependencies
- Dependencies must be handled manually:
  - Place required JAR files in a folder, commonly named "/lib"
  - Include the JARs in the classpath during compilation and execution:
    - Compilation: "javac -cp "lib/*;src" -d out src/com/example/MyProgram.java"
    - Execution: "java -cp "out;lib/*" com.example.MyProgram"
- Pros:
  - Full control over which versions of libraries are used
- Cons:
  - Tedious for projects with multiple dependencies
  - Error-prone if classpath is not configured correctly

3. Execution
- Run compiled Java programs using the "java" command:
  - "java -cp out com.example.MyProgram"
- Options:
  - "-cp <classpath>": include compiled classes and required libraries
  - "-Xms" and "-Xmx": configure JVM memory
  - "-jar <file.jar>": if manually packaged as a JAR

4. Output Management
- Compiled classes are stored in an output folder such as "/bin" or "/out"
- Any resources (configuration files, images, templates) must also be copied manually into the output folder
- If packaging into a JAR:
  - Use the "jar" command to bundle ".class" files and resources:
    - "jar cvf myapp.jar -C out/ ."

Advantages of Manual Build
- Minimal setup, requires only the JDK
- Full control over compilation, dependencies, and runtime
- Helps developers learn the Java compilation and execution pipeline

Limitations
- Manual dependency management is error-prone for larger projects
- Repetitive commands can be tedious
- Not suitable for enterprise or multi-module projects with complex build requirements

Summary
- Manual Build relies solely on JDK tools ("javac" and "java") and manual management of dependencies and outputs.
- Best for small projects, learning, or scenarios requiring full control.
- For larger or more complex projects, IDE builds or build tools like Maven and Gradle are recommended.
*/
void main() {}