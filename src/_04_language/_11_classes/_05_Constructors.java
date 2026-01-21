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
 */

/*
 * Class Declaration With Constructor
 * - Constructors have the same name as the class and do not declare a return type.
 * - The example below demonstrates a class with two constructors: No-Argument Constructor and two Parameterized
 *   Constructors.
 */
public class Person {
    public String name;
    public int age;

    // No-Argument Constructor
    public Person() {}

    // Parameterized Constructor
    public Person(String name) {
        this.name = name;
    }

    // Overloaded Parameterized Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

/*
 * Usage Example
 * - Demonstrates creating instances of "Person" using different constructors.
 * - Allows setting fields at instantiation depending on which constructor is used.
 */
void main() {
    Person person1 = new Person();           // No-argument constructor
    Person person2 = new Person("John");     // Parameterized constructor
    Person person3 = new Person("Anna", 32); // Overloaded parameterized constructor

    IO.println(person2.name); // Output: John
    IO.println(person3.name); // Output: Anna
    IO.println(person3.age);  // Output: 32
}