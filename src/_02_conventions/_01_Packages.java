/*
 * Packages
 * - This document explains what Java packages are, their purpose, naming conventions, directory mapping, and best
 *   practices.
 *
 * Overview
 * - A package in Java is a namespace that organizes classes and interfaces into logical groups.
 * - Packages help:
 *   - Prevent name conflicts between classes from different modules or libraries.
 *   - Improve maintainability of large projects.
 *   - Structure code in a clear and logical hierarchy.
 * - Packages also determine the physical directory structure of source files and compiled ".class" files, and how
 *   classes are referenced in imports.
 *
 * Naming Conventions
 * 1. Reverse Domain Naming
 * - The widely recommended convention is to use a reverse domain name followed by the project, module, or feature name.
 * - Reverse domain ensures uniqueness across organizations. For example, if your organization owns "example.com", start
 *   package names with "com.example".
 * - Examples:
 *   - com.example.utils
 *   - org.apache.commons.lang
 *   - net.mycompany.app
 *
 * 2. Sub-Packages
 * - Sub-packages are used to logically separate modules, features, or layers.
 * - Examples:
 *   - com.example.myproject.model -> domain or entity classes
 *   - com.example.myproject.service -> service layer classes
 *   - com.example.myproject.controller -> controllers or entry points
 *
 * 3. All Lowercase
 * - Package names should always be lowercase to avoid issues across different operating systems.
 *
 * 4. Avoid Reserved Keywords
 * - Do not use Java reserved words in package names (e.g., "int", "class", "package").
 *
 * 5. Meaningful Names
 * - Names should reflect the purpose or functionality of the classes contained in the package.
 * - Keep hierarchies as shallow as reasonable; excessively nested packages make code harder to navigate.
 *
 * Physical Directory Mapping
 * - Each package corresponds to a directory in the filesystem:
 *   - Package: com.example.myproject.model
 *   - Directory: src/main/java/com/example/myproject/model/
 * - Compiled classes follow the same directory inside the output folder or inside a JAR:
 *   - src/main/java/com/example/myproject/model/User.class -> target/classes/com/example/myproject/model/User.class
 *
 * Using Packages in Code
 * - Declare the package at the top of each Java source file:
 *   - Example: "package com.example.myproject.model;"
 * - Import classes from other packages using the import statement:
 *   - "import com.example.myproject.service.UserService;"
 * - Fully qualified class names can be used without import, but imports improve readability.
 *
 * Example Project Structure
 * my-project
 * |- src
 *    |- main
 *    |  |- java (Source Root)
 *    |     |- com.example.myproject
 *    |     |- com.example.myproject.model
 *    |     |- com.example.myproject.service
 *    |     |- com.example.myproject.controller
 *    |- test
 *       |- java (Test Source Root)
 *          |- com.example.myproject
 *          |- com.example.myproject.model
 *          |- com.example.myproject.service
 *          |- com.example.myproject.controller
 *
 * Best Practices Summary
 * - Always use lowercase letters and reverse domain naming.
 * - Keep packages meaningful and not excessively deep.
 * - Separate production code and test code using different source roots (e.g., src/main/java vs src/test/java).
 * - Organize by modules, layers, or functionality rather than by type alone.
 * - Ensure directory structure exactly matches the package name to avoid compilation errors.
 */
void main() {}