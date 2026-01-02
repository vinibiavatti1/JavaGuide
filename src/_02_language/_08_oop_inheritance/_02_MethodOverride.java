/*
Class Method Overriding Example
This section demonstrates method overriding in Java, which allows a subclass to provide a specific implementation for a
method that is already defined in its parent class.

Overview
- The "@Override" annotation indicates that a method in the child class overrides a method in the parent class.
- The parent class method must have the same name, return type, and parameters as the overriding method.
- Overriding enables polymorphism: the actual method executed depends on the runtime type of the object.
- The "super" keyword can be used to call the parent class method from the child class.

Key Points
- "Animal" defines a generic "say()" method.
- "Dog" overrides "say()" but also calls "super.say()" to include the parent behavior.
- "Cat" overrides "say()" with its own specific behavior.
*/
@SuppressWarnings("all")
public class Animal {
    public void say() {
        IO.println("woof!"); // Default behavior for animals
    }
}

/*
Dog Class
Inherits "say()" from Animal without overriding it.
The Dog class uses the parent's implementation of say().
*/
@SuppressWarnings("all")
public class Dog extends Animal {
    // No override, inherits Animal.say()
}

/*
Cat Class
Overrides the "say()" method of Animal with a custom implementation.
Does not call "super.say()", so only prints its own message.
*/
@SuppressWarnings("all")
public class Cat extends Animal {
    @Override
    public void say() {
        IO.println("meaw!"); // Cat-specific behavior
    }
}

/*
Usage Example
Demonstrates polymorphism: each object calls its own overridden method.
The "say()" method executed depends on the actual object type, not the reference type.
*/
@SuppressWarnings("all")
void main() {
    Animal a1 = new Dog();
    Animal a2 = new Cat();
    a1.say(); // woof! (inherited from Animal)
    a2.say(); // meaw! (overridden in Cat)
}