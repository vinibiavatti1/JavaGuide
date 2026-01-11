/*
Methods
- This section explains methods in Java and their role in defining the behavior of classes and objects.

Overview
- Methods are functions defined inside a class that perform tasks or operate on fields.
- Instance methods operate on individual objects and can access instance fields directly.
- Static methods belong to the class itself, not to any particular instance, and can only access static fields or call
  other static methods directly.
- Methods may return a value or be void, and can accept parameters to perform computations or actions.

Method Types
- Property Methods (Getters and Setters):
  - Provide controlled access to private fields.
  - Define JavaBean-style properties, enabling encapsulation while exposing necessary data.
- Behavioral Methods:
  - Implement actions, computations, or operations beyond simple field access.
  - Can manipulate object state or perform class-wide tasks if static.
- Static Methods:
  - Belong to the class rather than instances.
  - Useful for utility functions, factory methods, or operations that do not depend on object state.
  - Cannot directly access instance fields or methods.

Usage
- Use getters and setters to maintain encapsulation and safely expose object state.
- Use behavioral methods to define object actions, logic, or workflows.
- Use static methods for class-level operations or utility functions that do not require an instance.
- Well-designed methods improve readability, maintainability, and reusability.

Example:
- This example declares a public class named "Person" and illustrates the definition of methods.
- In main method, we are using the property methods to change the class state, and behavioral methods to perform
  actions.
*/
public class Person {
    private String name;

    // Property Method (Getter)
    public String getName() {
        return name;
    }

    // Property Method (Setter)
    public void setName(String name) {
        this.name = name;
    }

    // Behavioral Method
    public void sayHello() {
        IO.println(this.name + " said Hello!");
    }

    // Static Method
    public static void greet() {
        IO.println("Hello from Person class!");
    }
}

void main() {
    // Instance methods are called from the objects.
    Person p1 = new Person();
    Person p2 = new Person();
    p1.setName("John");
    p2.setName("Jane");
    p1.sayHello(); // John said Hello!
    p2.sayHello(); // Jane said Hello!

    // Static fields are called from the class.
    Person.greet(); // Hello from Person class!
}