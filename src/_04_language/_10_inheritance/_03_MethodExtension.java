/*
Method Extension
- This section explains how to extend the behavior of an inherited method in Java by overriding it and calling the 
  superclass implementation using "super".

Overview
- Method overriding allows a subclass to provide its own implementation of a method defined in its superclass.
- By calling "super.method()", the subclass can preserve the original behavior while adding additional functionality.
- This pattern is commonly used to augment or extend inherited behavior without duplicating code.

Key Characteristics
- The overriding method in the subclass must have the same signature as the superclass method.
- Using the "@Override" annotation is recommended to ensure correctness and readability.
- Calling "super.method()" combines the inherited behavior with new behavior defined in the subclass.
- Supports code reuse, maintainability, and adherence to the original superclass contract.

Usage
- Use this approach when you want to enhance rather than completely replace the behavior of a superclass method.
- Commonly applied in frameworks, lifecycle hooks, template methods, or any scenario where base logic must be preserved.
- Ensures that critical superclass logic is executed while allowing extensions in subclasses.

Example:
- The example shows a subclass overriding a method and calling "super" to extend it.
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
        super.speak(); // preserve superclass behavior
        IO.println("The dog barks"); // add additional behavior
    }
}

void main() {
    Dog d = new Dog();
    d.speak(); // The animal makes a sound | The dog barks
}