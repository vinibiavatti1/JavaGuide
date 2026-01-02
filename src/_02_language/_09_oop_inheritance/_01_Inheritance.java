/*
Inheritance
This section explains inheritance in Java and how it allows classes to reuse and extend behavior from other classes.

Overview
- Inheritance allows a class to acquire fields and methods from another class.
- It represents an "is-a" relationship between classes.
- Implemented in Java using the "extends" keyword.
- Promotes code reuse and hierarchical design.

Key Characteristics
- A subclass (child class) extends a superclass (parent class).
- The subclass inherits accessible fields and methods.
- Java supports single inheritance for classes.
- Constructors are not inherited, but can be invoked using "super".
- Methods can be overridden to provide specialized behavior.
- protected members are inherited and accessible only by package and subclasses.

Usage
- Use inheritance to share common behavior across related classes.
- Model hierarchical relationships (e.g., Animal -> Dog).
- Override methods to customize or extend behavior.
- Avoid deep inheritance hierarchies; prefer composition when appropriate.

Example:
- The example shows a subclass extending a superclass using the "extends" keyword.
- The main method demonstrates polymorphic behavior through inheritance.
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