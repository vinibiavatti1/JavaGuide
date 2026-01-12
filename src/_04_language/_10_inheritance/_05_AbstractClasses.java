/*
Abstract Classes
- This section explains abstract classes in Java and how they provide a base for other classes without allowing direct
  instantiation.

Overview
- An abstract class cannot be instantiated directly; it serves as a blueprint for subclasses.
- Declared using the "abstract" keyword.
- Can contain:
  - Abstract methods (without implementation) that must be implemented by subclasses.
  - Concrete methods (with implementation) that provide common behavior.
- Supports code reuse while enforcing a contract for subclasses.

Key Characteristics
- Abstract methods define behavior that subclasses are required to implement.
- Concrete methods provide shared functionality to all subclasses.
- Constructors are allowed and can be called by subclass constructors.
- Fields, methods, and access modifiers can be defined as in regular classes.
- Enables polymorphism: variables can refer to abstract types, allowing flexible and extensible code design.

Usage
- Use abstract classes to define a common base for related classes.
- Enforce a contract through abstract methods while sharing code in concrete methods.
- Ideal when you want partial implementation but still require subclass customization.
- Supports polymorphism and promotes maintainable, extensible object-oriented design.

Example:
- The example demonstrates an abstract class "Animal" with an abstract method "say".
- Subclasses "Dog" and "Cat" provide their own implementations of "say".
*/
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method: must be implemented by concrete subclasses
    public abstract void say();

    // Concrete method: shared behavior for all subclasses
    public String getName() {
        return name;
    }
}

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void say() {
        IO.println("woof!");
    }
}

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void say() {
        IO.println("meow!");
    }
}

@SuppressWarnings("all")
void main() {
    Animal a1 = new Dog("Rex");
    Animal a2 = new Cat("Tom");
    // Animal a = new Animal("Test"); - Not allowed: cannot instantiate abstract class

    IO.println(a1.getName()); // Rex
    IO.println(a2.getName()); // Tom
    a1.say(); // woof!
    a2.say(); // meaw!
}