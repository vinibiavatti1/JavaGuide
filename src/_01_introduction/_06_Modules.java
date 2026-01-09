/*
Java Modules
- This document explains the Java Module System, introduced in Java 9 (Project Jigsaw), its purpose, structure, and
  usage in modern Java applications.

Overview
- The Java Module System allows developers to modularize applications into explicitly defined modules.
- Modules provide:
  - Strong encapsulation of packages
  - Explicit declaration of dependencies
  - Better maintainability, readability, and runtime performance
- By grouping packages into modules, Java provides compile-time and runtime guarantees about which packages are
  accessible and which are internal to a module.
- Modules improve:
  - Encapsulation: internal packages are hidden by default
  - Dependency management: explicit "requires" statements
  - Startup performance: JVM can resolve module dependencies more efficiently

Module Definition
- A module is defined by a "module-info.java" file located in the module root directory.
- The module descriptor declares:
  - Module name
  - Exported packages
  - Required modules (dependencies)
  - Open packages (optional, for reflection)
  - Services provided or consumed (optional)
  
Basic "module-info.java" Example:
module com.example.myapp {
    requires java.sql;                    // Module dependency
    requires transitive java.logging;     // Transitive dependency
    exports com.example.myapp.api;        // Packages exposed to other modules
    opens com.example.myapp.internal;     // Packages open for reflection (e.g., frameworks)
}

Key Module Keywords
- "module <name>": Defines the module name.
- "requires <module>": Declares a dependency on another module.
- "requires transitive <module>": Dependencies that should also be available to modules depending on this one.
- "exports <package>": Makes a package available to other modules.
- "opens <package>": Makes a package accessible for reflection (e.g., serialization, frameworks).
- "provides <service> with <implementation>": Declares service implementations provided by the module.
- "uses <service>": Declares a dependency on a service provided by another module.

Compiling and Running Modules
- Compilation with "javac":
  - "javac -d out --module-source-path src $(find src -name "*.java")"
- Running with "java":
  - "java --module-path out --module com.example.myapp/com.example.myapp.api.MyApiClass"
- The "--module-path" option replaces the traditional classpath when working with modules.

Benefits of Modules
- Strong encapsulation: prevents accidental access to internal classes.
- Explicit dependencies: modules declare what they depend on and what they export.
- Improved maintainability and readability in large projects.
- Better runtime performance due to optimized module resolution and reduced class loading.
- Facilitates modular JARs and multi-release JARs for cross-version compatibility.

Module vs Classpath
- Traditional classpath:
  - All classes are globally visible to the JVM.
  - No enforced encapsulation or dependency declaration.
- Module path:
  - Only exported packages are accessible between modules.
  - Dependencies are explicitly declared and verified at compile-time and runtime.
  - Reduces risks of conflicts and accidental package exposure.

Modern Usage
- Modules are recommended for:
  - Large applications with multiple components
  - Libraries that want to provide explicit APIs while hiding internal implementation
  - Enterprise and modular systems where maintainability, encapsulation, and dependency management are important
- For small projects or legacy code, modules are optional, and classpath can still be used.

Summary
- The Java Module System introduces strong encapsulation, explicit dependencies, and modular JARs.
- Modules are defined via "module-info.java" with "requires", "exports", and optional "opens" or "provides".
- Compilation and runtime use the "--module-source-path" and "--module-path" instead of the traditional classpath.
- Modules improve maintainability, scalability, and runtime performance in modern Java applications.
*/
void main() {}