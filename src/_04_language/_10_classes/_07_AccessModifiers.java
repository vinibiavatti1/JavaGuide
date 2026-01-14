/*
 * Access Modifiers
 * - This section explains how access modifiers control the visibility of class members (fields, methods, and
 *   constructors) in Java.
 * - Fields should generally be private and accessed through getters and setters to maintain encapsulation.
 *
 * Overview
 * - public: Members are accessible from any class, in any package.
 * - protected: Members are accessible within the same package and by subclasses, even if they are in a different
 *   package.
 * - private: Members are accessible only within the declaring class.
 * - package-private (default, no modifier): Members are accessible only within the same package.
 *
 * Key Characteristics
 * - Access modifiers enforce encapsulation and influence class design, maintainability, and security.
 * - Choosing the appropriate modifier helps protect internal state, control access, and prevent unintended
 *   modifications.
 * - Proper use of modifiers promotes clean, maintainable, and safe object-oriented code.
 *
 * Example:
 * - This example declares a public class with fields using different access modifiers.
 * - Demonstrates how access to fields is restricted according to the modifier used.
 */
public class Person {
    // Fields
    public String publicField;          // Public: Accessible from anywhere
    protected String protectedField;    // Protected: Accessible in the same package or subclasses
    private String privateField;        // Private: Accessible only within this class
    String packagePrivateField;         // Package-Private: Accessible only within the same package (default)

    // Methods
    public void publicMethod() {}       // Public: Accessible from anywhere
    protected void protectedMethod() {} // Protected: Accessible in the same package or subclasses
    private void privateMethod() {}     // Private: Accessible only within this class
    void packagePrivateMethod() {}      // Package-Private: Accessible only within the same package (default)
}

void main() {
    Person p = new Person();
    p.publicField = "...";              // Accessible
    p.protectedField = "...";           // Accessible within package
    p.packagePrivateField = "...";      // Accessible within package
    // p.privateField = "Private";      // Not accessible here, would cause a compilation error
}