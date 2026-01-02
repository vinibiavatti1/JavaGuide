/*
Method Extension
This section explains how to extend the behavior of an inherited method in Java by overriding it and calling the
superclass implementation using "super".

Overview
- Method overriding allows a subclass to provide its own implementation of a method defined in its superclass.
- By calling super.method(), the subclass can preserve the original behavior while adding new functionality.
- This pattern is often used to augment or extend inherited behavior.

Key Characteristics
- The overridden method in the subclass has the same signature as the superclass method.
- The @Override annotation is recommended to ensure correctness.
- Calling super.method() allows combining inherited behavior with new behavior.
- This technique supports code reuse and maintainability.

Usage
- Use this approach when you want to enhance rather than completely replace
  the behavior of a superclass method.
- Common in frameworks, lifecycle hooks, and template patterns.
- Ensures that important superclass logic is not bypassed accidentally.

Example:
- The example shows a subclass overriding a method and calling super to extend it.
- The main method demonstrates that both the superclass and subclass behaviors are executed.
*/
public class Animal {
    public void speak() {
        IO.println("The animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override
    public void speak() {
        super.speak();               // preserve superclass behavior
        IO.println("The dog barks"); // add additional behavior
    }
}

public void main() {
    Dog d = new Dog();
    d.speak(); // The animal makes a sound | The dog barks
}