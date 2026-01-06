/*
Abstract Classes
- This section explains abstract classes in Java and how they provide a base for other classes without allowing direct
  instantiation.

Overview
- An abstract class cannot be instantiated directly.
- Declared using the "abstract" keyword.
- Can contain abstract methods (without implementation) and concrete methods.
- Supports code reuse while enforcing a contract for subclasses.

Key Characteristics
- Abstract methods must be implemented by concrete subclasses.
- Concrete methods can provide common behavior to all subclasses.
- Constructors are allowed and can be called by subclass constructors.
- Can define fields, methods, and access modifiers as in regular classes.

Usage
- Use abstract classes to define a common base for related classes.
- Enforce a contract through abstract methods while sharing code in concrete methods.
- Ideal when you want partial implementation but still require subclass customization.
- Supports polymorphism by allowing variables to refer to abstract types.

Example:
- The example demonstrates an abstract class "Animal" with an abstract method "say".
- Subclasses "Dog" and "Cat" provide their own implementations of "say".
*/
@SuppressWarnings("all")
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
    // Animal a = new Animal("Test"); // Not allowed: cannot instantiate abstract class
    IO.println(a1.getName());         // Rex
    IO.println(a2.getName());         // Tom
    a1.say();                         // woof!
    a2.say();                         // meaw!
}