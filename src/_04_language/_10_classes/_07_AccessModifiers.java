/*
 * Access Modifiers
 * - This section explains how access modifiers control the visibility of class members (fields, methods, and
 *   constructors) in Java.
 * - Fields should generally be private and accessed through getters and setters to maintain encapsulation.
 *
 * Overview of Modifiers
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
 */

/*
 * Class Access Modifiers
 * - Demonstrates how classes themselves can have access modifiers.
 * - public: Class is accessible from any other class in any package.
 * - package-private (default): Class is accessible only within the same package.
 */
public class PublicClass {}       // Public class, accessible everywhere
class PackagePrivateClass {}      // Package-private class, accessible only within the package

/*
 * Field Access Modifiers
 * - Demonstrates different access levels for fields in a class.
 * - Best practice: Keep fields private and provide access through getters and setters.
 */
public class Fields {
    public String publicField;       // Accessible from anywhere
    protected String protectedField; // Accessible within the same package or by subclasses
    private String privateField;     // Accessible only within this class
    String packagePrivateField;      // Accessible only within the same package (default)
}

/*
 * Method Access Modifiers
 * - Demonstrates different access levels for methods in a class.
 * - Methods follow the same rules as fields.
 */
public class Methods {
    public void publicMethod() {}       // Accessible from anywhere
    protected void protectedMethod() {} // Accessible within the same package or by subclasses
    private void privateMethod() {}     // Accessible only within this class
    void packagePrivateMethod() {}      // Accessible only within the same package (default)
}

/*
 * Usage Example
 * - Demonstrates how access modifiers affect visibility in practice.
 */
void main() {
    Fields fields = new Fields();

    // Accessible according to modifiers
    fields.publicField = "Public";          // Accessible anywhere
    fields.protectedField = "Protected";    // Accessible in same package
    fields.packagePrivateField = "Package"; // Accessible in same package

    // Not accessible outside class
    // fields.privateField = "Private"; // Compilation error
}
