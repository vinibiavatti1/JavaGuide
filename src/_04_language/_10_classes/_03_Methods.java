/*
 * Methods
 * - This section explains methods in Java and their role in defining the behavior of classes and objects.
 *
 * Overview
 * - Methods are functions defined inside a class that perform tasks or operate on fields.
 * - Instance methods operate on individual objects and can access instance fields directly.
 * - Static methods belong to the class itself, not to any particular instance, and can only access static fields or
 *   call other static methods directly.
 * - Methods may return a value or be void, and can accept parameters to perform computations or actions.
 *
 * Method Types
 * - Property Methods (Getters and Setters):
 *   - Provide controlled access to private fields.
 *   - Define JavaBean-style properties, enabling encapsulation while exposing necessary data.
 * - Behavioral Methods:
 *   - Implement actions, computations, or operations beyond simple field access.
 *   - Can manipulate object state or perform class-wide tasks if static.
 * - Static Methods:
 *   - Belong to the class rather than instances.
 *   - Useful for utility functions, factory methods, or operations that do not depend on object state.
 *   - Cannot directly access instance fields or methods.
 *
 * The "this" Keyword
 * - Refers to the current instance of the class.
 * - Used to access instance fields, call instance methods, or pass the current object as a parameter.
 * - Helps disambiguate between instance variables and parameters with the same name.
 * - Syntax:
 *   - Field Access: this.field
 *   - Method Class: this.method()
 *
 * Usage
 * - Use getters and setters to maintain encapsulation and safely expose object state.
 * - Use behavioral methods to define object actions, logic, or workflows.
 * - Use static methods for class-level operations or utility functions that do not require an instance.
 * - Well-designed methods improve readability, maintainability, and reusability.
 */

/*
 * Class Declaration With Methods
 * - This example demonstrates a class "Person" with different types of methods: Property Methods, Behavioral Methods,
 *   and Static Methods.
 * - The "this" keyword is being used to between instance variables and parameters: "this.name = name".
 */
public class Person {
    private String name;

    // Property Method (Getter for field "name")
    public String getName() {
        return name;
    }

    // Property Method (Setter for field "name")
    public void setName(String name) {
        this.name = name;
    }

    // Behavioral Method
    public void sayHello() {
        IO.println(name + " said Hello!");
    }

    // Static Method
    public static void greet() {
        IO.println("Hello from Person class!");
    }
}

/*
 * Usage Example
 * - Demonstrates creating an instance of "Person" and using its methods.
 * - Shows the difference between instance methods (property and behavioral) and static methods.
 */
void main() {
    // Creating a Person instance
    Person person = new Person();

    // Calling property methods to access and modify the private field
    person.setName("John");
    IO.println(person.getName()); // Output: John

    // Calling behavioral methods to perform actions
    person.sayHello(); // Output: John said Hello!

    // Static methods are called on the class itself, without creating an instance
    Person.greet(); // Output: Hello from Person class!
}