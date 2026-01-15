/*
 * Inheritance
 * - This section explains inheritance in Java and how it allows classes to reuse and extend behavior from other
 *   classes.
 *
 * Overview
 * - Inheritance enables a class (subclass) to acquire fields and methods from another class (superclass).
 * - Represents an "is-a" relationship between classes (e.g., Dog is an Animal).
 * - Implemented using the "extends" keyword in Java.
 * - Promotes code reuse, reduces duplication, and supports hierarchical class design.
 *
 * Key Characteristics
 * - A subclass inherits accessible fields and methods from its superclass.
 * - Java supports single inheritance for classes (one superclass per class).
 * - Constructors are not inherited, but a subclass can invoke superclass constructors using "super".
 * - Methods can be overridden to provide specialized or customized behavior.
 * - "protected" members are inherited and accessible to subclasses and classes in the same package.
 * - Supports polymorphism: a subclass instance can be treated as an instance of its superclass.
 *
 * The "super" Keyword
 * - Refers to the immediate superclass of the current class.
 * - Used to access superclass methods, fields, or constructors.
 * - Helps reuse or extend functionality from the parent class.
 * - Syntax:
 *   - Constructor:  super(arg1, arg2, ...)
 *   - Field access: super.field
 *   - Method call:  super.method()
 *
 * Usage
 * - Use inheritance to share common behavior across related classes.
 * - Model hierarchical relationships (e.g., Animal -> Dog -> Labrador).
 * - Override methods to extend or customize behavior in subclasses.
 * - Avoid deep or complex inheritance hierarchies; prefer composition or interfaces when appropriate.
 * - Maintain clear separation of concerns and ensure subclasses represent true "is-a" relationships.
 */

/*
 * Superclass Declaration
 * - Demonstrates the declaration of a class that serves as a superclass for other classes.
 * - Provides shared state and behavior (fields and methods) that can be inherited by subclasses.
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/*
 * Subclass Declaration
 * - Demonstrates two subclasses that extend the Animal superclass.
 * - Subclasses inherit fields and methods from the superclass.
 * - Use of "super" in constructors allows passing parameters to the superclass constructor.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

/*
 * Usage Example
 * - Demonstrates polymorphism: variables of type Animal can refer to instances of any subclass.
 * - Subclasses inherit the getName() method from Animal.
 */
void main() {
    Animal dog = new Dog("Rex");
    Animal cat = new Cat("Tom");

    IO.println(dog.getName()); // Output: Rex
    IO.println(cat.getName()); // Output: Tom
}