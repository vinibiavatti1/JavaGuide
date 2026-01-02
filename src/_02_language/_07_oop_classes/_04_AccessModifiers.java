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
*/
@SuppressWarnings("all")
public class Person {
    public String publicField;       // Accessible from anywhere
    protected String protectedField; // Accessible in the same package or subclasses
    String packagePrivateField;      // Accessible only within the same package (default)
    private String privateField;     // Accessible only within this class
}

/*
Usage Example
This example shows how access to fields is restricted based on the modifier.
*/
@SuppressWarnings("all")
void main() {
    Person p = new Person();
    p.publicField = "Public";                 // Accessible
    p.protectedField = "Protected";           // Accessible within package
    p.packagePrivateField = "PackagePrivate"; // Accessible within package
    // p.privateField = "Private";            // Not accessible here, would cause a compilation error
}