/*
Modular Project Structure
- This document explains the standard layout of a Java project that uses the Java Module System (introduced in Java 9).
- A modular project organizes code, resources, and tests into explicit modules, each with its own "module-info.java",
  allowing strong encapsulation, clear dependencies, and modular compilation.

Overview
- Each module has a dedicated root directory containing its source code, resources, and module descriptor.
- Modules interact with each other only through explicitly exported packages and declared dependencies.
- Build tools and IDEs recognize the module structure to compile, test, and package each module separately.
- Modular project structure improves maintainability, reduces accidental package exposure, and enables scalable
  multi-module applications.

Typical Modular Project Layout
my-modular-project/
|- module-a/
|  |- src/
|  |  |- com/example/modulea/
|  |     |- MyClassA.java
|  |- module-info.java      // Module descriptor for module-a
|- module-b/
|  |- src/
|  |  |- com/example/moduleb/
|  |     |- MyClassB.java
|  |- module-info.java      // Module descriptor for module-b
|- resources/               // Shared resources, if any
|- test/
|  |- module-a/
|  |  |- com/example/modulea/
|  |     |- MyClassATest.java
|  |- module-b/
|      |- com/example/moduleb/
|         |- MyClassBTest.java
|- build/ or out/           // Compiled classes and packaged modular JARs
|- scripts/                 // Build, deployment, or automation scripts

Key Points
- Each module has its own "module-info.java" defining:
  - Module name
  - Required modules (dependencies)
  - Exported packages
  - Open packages (optional, for reflection)
  - Provided or used services (optional)
- Source code is placed under "src/<package-path>" within each module.
- Test sources mirror the module structure under "test/<module>/...".
- Resources specific to a module can be placed under "resources/<module>/..." or inside the module source root.
- Modular JARs are typically generated in "build/" (Gradle) or "target/" (Maven), preserving the module structure.

Benefits of Modular Project Structure
- Clear separation of modules and responsibilities
- Strong encapsulation of internal packages
- Explicit declaration of dependencies and exported APIs
- Better build performance due to isolated module compilation
- Easier maintenance and scaling of large projects
- Simplified packaging of modular JARs for deployment or distribution
*/
void main() {}