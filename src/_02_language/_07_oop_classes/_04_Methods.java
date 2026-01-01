/*
Class Methods
This section explains methods in Java and how they define the behavior of classes and objects.

Overview
- Methods are functions inside a class that perform tasks or operate on fields.
- They can be instance methods (work on objects) or static methods (belong to the class).
- Methods may return a value or be void, and can accept parameters.

Method Types
- Property Methods (Getters and Setters): Provide controlled access to private fields and define a JavaBean property.
- Behavioral Methods: Implement actions, computations, or operations beyond simple field access.

Usage
- Use getters and setters to maintain encapsulation.
- Use behavioral methods to define what objects can do.
- Well-designed methods improve readability, maintainability, and reusability.

Example:
- This example declares a public class named "Person" and illustrates the definition of methods.
*/
@SuppressWarnings("all")
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
        IO.println(this.name + " said Hello");
    }
}

/*
Usage Example
In this example, we are using the methods to access and mutate the instance fields.
We are also calling a behavioral method.
*/
@SuppressWarnings("all")
void main() {
    Person p1 = new Person();
    Person p2 = new Person();
    p1.setName("John");
    p2.setName("Jane");
    IO.println(p1.getName()); // John
    IO.println(p2.getName()); // Jane
    p1.sayHello(); // John said Hello
    p2.sayHello(); // Jane said Hello
}