/*
Class Constructors
This section explains constructors in Java and their role in creating and initializing objects.

Overview
- Constructors are special methods in a class used to create new instances.
- They have the same name as the class and do not have a return type.
- Constructors can accept parameters to initialize object fields or set up state.
- If no constructor is defined, Java provides a default no-argument constructor.

Constructor Types
- No-Argument Constructor: Initializes an object with default values.
- Parameterized Constructor: Accepts arguments to initialize object fields during creation.
- Copy Constructor (optional pattern in Java): Creates a new object as a copy of an existing object.

Usage
- Use constructors to ensure objects are properly initialized at creation.
- Parameterized constructors allow enforcing required fields or validation.
- Overloading constructors provides flexibility in object creation.
- Proper constructor design improves code safety, readability, and consistency of object state.

Example
- This example declares a public class named `Person` and illustrates the definition of a constructor.
*/
@SuppressWarnings("all")
public class Person {
    private String name;

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    // Property Method (Getter)
    public String getName() {
        return name;
    }
}

/*
Class Constructor Example
In this example, we are using the constructor to create new instances of the `Person` class.
The constructor initializes the object, setting up its initial state before any methods are called.
*/
@SuppressWarnings("all")
void main() {
    Person p1 = new Person("John");
    Person p2 = new Person("Jane");
    IO.println(p1.getName()); // John
    IO.println(p2.getName()); // Jane
}