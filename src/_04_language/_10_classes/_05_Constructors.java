/*
 * Class Constructors
 * - This section explains constructors in Java and their role in creating and initializing objects.
 *
 * Overview
 * - Constructors are special methods used to create new instances of a class.
 * - They have the same name as the class and do not declare a return type.
 * - Constructors can accept parameters to initialize object fields or set up other aspects of object state.
 * - If no constructor is explicitly defined, Java automatically provides a default no-argument constructor.
 *
 * Constructor Types
 * - No-Argument Constructor:
 *   - Initializes an object with default values.
 *   - Provided by Java if no constructor is defined.
 * - Parameterized Constructor:
 *   - Accepts arguments to initialize object fields during creation.
 *   - Allows enforcing required fields or applying validation at instantiation.
 * - Copy Constructor (optional pattern in Java):
 *   - Creates a new object as a copy of an existing object.
 *   - Useful for duplicating objects with the same state.
 *
 * Usage
 * - Use constructors to ensure objects are properly initialized upon creation.
 * - Parameterized constructors provide flexibility and control over initial state.
 * - Constructor overloading allows multiple ways to instantiate objects depending on available data.
 * - Well-designed constructors improve code safety, readability, and consistency of object state.
 *
 * Example
 * - This example declares a public class named "Person" and illustrates the definition of a constructor.
 * - In the main method, we will use the constructor to initialize the class fields.
 */
public class Person {
    public String name;

    // No-Argument Constructor
    public Person() {}

    // Parameterized Constructor
    public Person(String name) {
        this.name = name;
    }
}

void main() {
    Person person = new Person("John");
    IO.println(person.name); // John
}