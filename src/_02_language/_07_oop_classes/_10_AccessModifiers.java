/*
Access Modifiers
This section explains how access modifiers control the visibility of class members in Java.
Fields should usually be private and accessed via getters/setters.

Overview
- public: The field is accessible from any class, regardless of the package.
- protected: The field is accessible within the same package and by subclasses.
- private: The field is accessible only within the declaring class.
- package-private (default): The field is accessible only within the same package.

Key Characteristics
- Modifiers define encapsulation and influence class design and maintainability.
- Choosing the right modifier helps protect internal state and prevents unintended access.

Example:
- This example declares a public class with fields using different access modifiers.
- Shows how access to fields is restricted based on the modifier.
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