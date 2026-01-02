/*
Class Example
This example demonstrates a comprehensive Java class including:
- Static fields and constants
- Instance fields
- Constructor
- Static and instance initializer blocks
- Behavioral methods
- Getters and setters

It illustrates how different class elements are declared, initialized, and used in practice.
*/
@SuppressWarnings("all")
public class MyClass {
    /*
    Static Fields
    - Static fields are variables declared inside a class with the "static" keyword.
    - They belong to the class itself, not to any individual object, and are shared by all instances.
    - When combined with "final", they define constants whose value cannot change after initialization.
    */
    public static final int CONST = 1;

    /*
    Instance Fields
    - Fields are variables declared inside a class to store object state.
    - Each object has its own copy of instance fields.
    - NOTE: Access to fields should be controlled via getters/setters to enforce encapsulation.
    */
    private int field;

    /*
    Constructor
    - Special method used to create new instances of the class.
    - Has the same name as the class and no return type.
    - Accepts parameters to initialize instance fields.
    - If no constructor is defined, a default no-argument constructor is provided by Java.
    */
    public MyClass(int field) {
        this.field = field;
        IO.println("Constructor called");
    }

    /*
    Static Initializer
    - Runs once when the class is loaded.
    - Commonly used to initialize static fields or perform class-level setup.
    */
    static {
        IO.println("Static initializer executed");
    }

    /*
    Instance Initializer
    - Runs every time a new object is created, before the constructor.
    - Can be used to initialize instance fields or perform object-level setup.
    */
    {
        IO.println("Instance initializer executed");
    }

    /*
    Behavioral Method
    - Methods that define the actions or operations of the object.
    */
    public void doAction() {
        IO.println("Action performed");
    }

    /*
    Getters and Setters
    - Provide controlled access to private fields.
    */
    public int getField() {
        return field;
    }
    public void setField(int field) {
        this.field = field;
    }
}

/*
Main Example
Demonstrates usage of static fields, instance fields, constructor, initializer blocks, and behavioral methods.
*/
@SuppressWarnings("all")
void main() {
    // Access static fields directly via class
    IO.println("CONST: " + MyClass.CONST);

    // Create two instances of MyClass
    MyClass obj1 = new MyClass(10);
    MyClass obj2 = new MyClass(20);

    // Access and modify instance fields
    obj2.setField(200);

    // Call behavioral methods
    obj1.doAction(); // Action performed
    obj2.doAction(); // Action performed

    // Access instance field via getter
    IO.println("obj1.field via getter: " + obj1.getField());
}