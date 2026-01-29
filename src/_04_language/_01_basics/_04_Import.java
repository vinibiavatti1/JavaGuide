/*
 * Import
 * - This section explains the Java import mechanism, which allows classes and static members from other packages to be
 *   referenced without using their fully qualified names.
 *
 * Overview
 * - Imports are declared after the package declaration and before type declarations.
 * - They improve readability by avoiding repetitive fully qualified class names.
 * - Java supports regular imports (types) and static imports (static fields and methods).
 *
 * Key Characteristics
 * - Imports do not load code at runtime; they are a compile-time convenience.
 * - java.lang is implicitly imported and does not require explicit import statements.
 * - Can import a single type/member or all members using the wildcard (*).
 * - Static imports allow direct access to static members without qualifying them with the class name.
 *
 * Usage
 * - Use regular imports for classes and interfaces used frequently in a file.
 * - Use static imports sparingly, typically for constants or well-known utility methods.
 * - Avoid excessive static imports to preserve code clarity and explicitness.
 *
 * Note
 * - In Java 25+, explicit package and import declarations can be omitted for classes from commonly used packages, as
 *   they are implicitly available.
 */
package _04_language._01_basics;

/*
 * Class Import
 * - Demonstrates importing a class to access its static members via the class name.
 * - Improves readability compared to fully qualified references.
 */
import java.lang.Math;

/*
 * Static Import
 * - Demonstrates importing static members of a class.
 * - Allows direct access to constants and methods without qualifying them with the class name.
 */
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/*
 * Import All
 * - Demonstrates importing all types from a package using a wildcard (*).
 * - All classes from java.lang are available without full qualification.
 */
import java.lang.*;

/*
 * Example
 * - Demonstrates the difference between regular imports and static imports.
 * - Shows how static fields and methods can be accessed with and without the class qualifier.
 */
public class _04_Import {
    public static void main(String[] args) {
        /*
         * Static Field
         * - Demonstrates accessing a static constant with and without static import.
         * - Output: 3.141592653589793 | 3.141592653589793
         */
        IO.println(Math.PI); // Using class-qualified access
        IO.println(PI);      // Using static import

        /*
         * Static Method
         * - Demonstrates invoking a static method with and without static import.
         * - Output: 2.0 | 2.0
         */
        IO.println(Math.sqrt(4)); // Using class-qualified access
        IO.println(sqrt(4));      // Using static import
    }
}
