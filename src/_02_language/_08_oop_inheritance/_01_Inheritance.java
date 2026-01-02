/*
Class Inheritance
This section demonstrates inheritance in Java, which allows a class to acquire the properties and behaviors (fields and
methods) of another class.

Overview
- The keyword "extends" is used to declare that a class derives from a parent (super) class.
- The child class inherits all accessible fields and methods from the parent class.
- Constructors are not inherited, so child classes must call a parent constructor using "super(...)".
- Inheritance enables polymorphism, allowing a parent reference to hold child objects.
- Access to inherited members depends on their access modifiers (private, protected, public).

Final Classes
- Final classes are classes that cannot be subclassed, used to prevent inheritance and ensure that their implementation
  remains unchanged "public final class MyClass {...}".

Key Points
- "Animal" is the parent (super) class.
- "Dog" and "Cat" are child (sub) classes that extend "Animal".
- Child classes can add new methods or override inherited ones to provide specific behavior.
*/
@SuppressWarnings("all")
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
Dog Class
This class extends the "Animal" class, inheriting its fields and methods.
It calls the parent constructor using "super(name)" to initialize the inherited state.
*/
@SuppressWarnings("all")
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

/*
Cat Class
This class also extends the "Animal" class, inheriting its fields and methods.
It calls the parent constructor using "super(name)" to initialize the inherited state.
*/
@SuppressWarnings("all")
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

/*
Usage Example
Demonstrates polymorphism: parent references ("Animal") holding child objects ("Dog" and "Cat").
We can call inherited methods (getName()) on both objects, regardless of their actual subclass.
*/
void main() {
    Animal a1 = new Dog("Rex");
    Animal a2 = new Cat("Tom");
    IO.println(a1.getName()); // Rex
    IO.println(a2.getName()); // Tom
}