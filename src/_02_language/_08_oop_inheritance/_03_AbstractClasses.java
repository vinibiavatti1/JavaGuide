/*
Abstract Classes
This section explains abstract classes in Java and their purpose.

Overview
- An abstract class is a class that cannot be instantiated directly.
- It is used to define a common template for subclasses.
- Abstract classes can contain abstract methods (without implementation) and concrete methods (with implementation).
- Subclasses must implement all abstract methods unless they are also abstract.

Key Characteristics
- Declared using the `abstract` keyword.
- Can have fields, constructors, and methods (both abstract and concrete).
- Abstract methods define a contract that subclasses must fulfill.
- Can be used to enforce a common behavior across different subclasses while allowing specific implementations.

Usage
- Use abstract classes when you want to provide a common base with shared code, but leave some methods to be implemented
  by subclasses.
- Helps in code reuse and enforcing a consistent API across related classes.
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

/*
Dog Class
A concrete subclass of Animal that implements the abstract method `say()`.
*/
@SuppressWarnings("all")
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void say() {
        IO.println("woof!");
    }
}

/*
Cat Class
Another concrete subclass of Animal implementing `say()`.
*/
@SuppressWarnings("all")
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void say() {
        IO.println("meaw!");
    }
}

/*
Usage Example
Demonstrates that abstract classes cannot be instantiated directly, and concrete subclasses must implement the abstract
methods.
*/
@SuppressWarnings("all")
void main() {
    // Animal a = new Animal("Test"); // Not allowed: cannot instantiate abstract class
    Animal a1 = new Dog("Rex");
    Animal a2 = new Cat("Tom");
    IO.println(a1.getName()); // Rex
    a1.say();                 // woof!
    IO.println(a2.getName()); // Tom
    a2.say();                 // meaw!
}