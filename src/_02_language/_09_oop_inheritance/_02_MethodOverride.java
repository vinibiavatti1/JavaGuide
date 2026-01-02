/*
Method Overriding
This section explains method overriding in Java and how subclasses can provide their own implementation of inherited
methods.

Overview
- Method overriding occurs when a subclass provides a specific implementation of a method already defined in its
  superclass.
- The method in the subclass must have the same signature (name and parameters).
- Overriding enables runtime polymorphism.

Key Characteristics
- The overridden method is chosen at runtime based on the object's actual type.
- The method in the superclass must not be private.
- The @Override annotation is recommended to ensure correctness.
- Overriding allows subclasses to specialize or change inherited behavior.

Usage
- Use overriding to customize behavior in subclasses.
- Implement different behaviors for the same method across related classes.
- Support polymorphic design where code depends on abstractions.
- Improve extensibility without modifying existing code.

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
    public void say() {
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