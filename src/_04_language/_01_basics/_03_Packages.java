/*
 * Packages
 * - This section explains the Java package declaration, which defines the namespace of a class or interface
 *   and determines how it is organized and accessed within a Java application.
 *
 * Overview
 * - The package declaration is specified using the `package` keyword at the very top of a source file.
 * - It groups related classes and interfaces into a logical namespace.
 * - Packages are part of Java since its earliest versions and are fundamental to project organization and modularity.
 *
 * Key Characteristics
 * - Must be the first non-comment statement in a Java source file.
 * - Defines the fully qualified name of all types declared in the file.
 * - Prevents name conflicts by isolating classes with the same name in different packages.
 * - Controls visibility and access, especially when used with access modifiers like protected and default.
 * - Closely maps to the directory structure of the compiled classes.
 *
 * Usage
 * - Use package declarations to organize large codebases into clear, cohesive modules.
 * - Apply standard naming conventions (usually reverse domain names) to avoid collisions.
 * - Essential for access control, code readability, and maintainability.
 * - Required when building libraries, frameworks, or any non-trivial Java application.
 *
 * Note
 * - In Java 25+, explicit package and import declarations can be omitted for classes from commonly used packages, as
 *   they are implicitly available.
 */
package _04_language._01_basics; // <- Package Declaration

public class _03_Packages {}