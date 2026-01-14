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
 * Usage
 * - Use inheritance to share common behavior across related classes.
 * - Model hierarchical relationships (e.g., Animal -> Dog -> Labrador).
 * - Override methods to extend or customize behavior in subclasses.
 * - Avoid deep or complex inheritance hierarchies; prefer composition or interfaces when appropriate.
 * - Maintain clear separation of concerns and ensure subclasses represent true "is-a" relationships.
 *
 * Example:
 * - The example shows a subclass extending a superclass using the "extends" keyword.
 * - The main method demonstrates polymorphic behavior through inheritance.
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

void main() {
    Animal a1 = new Dog("Rex");
    Animal a2 = new Cat("Tom");
    IO.println(a1.getName()); // Rex
    IO.println(a2.getName()); // Tom
}