/*
Method Override
- This section explains method overriding in Java and how subclasses can provide their own implementation of inherited
  methods.

Overview
- Method overriding occurs when a subclass defines a method with the same signature (name and parameters) as a method in
  its superclass.
- The overriding method replaces the behavior of the superclass method when called on an instance of the subclass.
- Enables runtime polymorphism, allowing the program to choose the appropriate method implementation based on the
  object's actual type.

Key Characteristics
- The overridden method is resolved at runtime according to the actual type of the object.
- The superclass method must not be private; it can be public, protected, or package-private.
- Using the "@Override" annotation is recommended to ensure the method correctly overrides a superclass method.
- Overriding allows subclasses to specialize, extend, or modify inherited behavior.
- Supports polymorphic design patterns and flexible, extensible code.

Usage
- Use overriding to customize behavior in subclasses without modifying the superclass.
- Implement different behaviors for the same method across related classes.
- Enable polymorphic designs where code works with abstract types or superclass references.
- Improve code extensibility, maintainability, and reusability.

Example:
- The example shows a subclass overriding a method from its superclass.
- The main method demonstrates that the overridden method is resolved at runtime.
*/
public class Animal {
    public void say() {
        IO.println("woof!");
    }
}

public class Dog extends Animal {
}

public class Cat extends Animal {
    @Override
    public void say() { // Override say() method from Animal with new logic
        IO.println("meow!");
    }
}

@SuppressWarnings("all")
void main() {
    Animal a1 = new Dog();
    Animal a2 = new Cat();
    a1.say(); // woof! (inherited from Animal)
    a2.say(); // meow! (overridden in Cat)
}