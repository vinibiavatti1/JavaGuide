/*
Sealed Classes
This section explains sealed classes in Java and their purpose.

Overview
- Sealed classes restrict which other classes or interfaces can extend or implement them.
- Declared using the "sealed" keyword.
- Subclasses must be explicitly permitted using the "permits" clause.
- Subclasses can be declared as "final" (cannot be extended), "sealed" (can further restrict subclasses), or
  "non-sealed" (can be extended freely).

Key Characteristics
- Helps enforce a controlled class hierarchy.
- Provides more predictable polymorphism and security.
- Useful when you want to define a limited set of allowed subclasses.

Usage
- Use sealed classes when you need to tightly control the set of subclasses for a base class.
- Often used in modeling domains where only a known set of types should exist.
*/
@SuppressWarnings("all")
public sealed class Animal permits Dog, Cat {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

/*
Dog Class
A final subclass of Animal. No class can extend this further.
*/
@SuppressWarnings("all")
public final class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

/*
Cat Class
A non-sealed subclass of Animal. Can be extended by other classes.
*/
@SuppressWarnings("all")
public non-sealed class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

/*
Usage Example
Demonstrates instantiation of subclasses of a sealed class.
*/
void main() {
    Animal a1 = new Dog("Rex");
    Animal a2 = new Cat("Tom");
    IO.println(a1.getName()); // Rex
    IO.println(a2.getName()); // Tom
}