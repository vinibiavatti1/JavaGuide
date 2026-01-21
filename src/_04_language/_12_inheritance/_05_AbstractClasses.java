/*
 * Abstract Classes
 * - This section explains abstract classes in Java and how they provide a base for other classes without allowing
 *   direct instantiation.
 *
 * Overview
 * - An abstract class cannot be instantiated directly; it serves as a blueprint for subclasses.
 * - Declared using the "abstract" keyword.
 * - Can contain:
 *   - Abstract methods (without implementation) that must be implemented by subclasses.
 *   - Concrete methods (with implementation) that provide common behavior.
 * - Supports code reuse while enforcing a contract for subclasses.
 *
 * Key Characteristics
 * - Abstract methods define behavior that subclasses are required to implement.
 * - Concrete methods provide shared functionality to all subclasses.
 * - Constructors are allowed and can be called by subclass constructors.
 * - Fields, methods, and access modifiers can be defined as in regular classes.
 * - Enables polymorphism: variables can refer to abstract types, allowing flexible and extensible code design.
 * - An abstract class may implement one or more interfaces, but it is not required to provide implementations for the
 *   interface methods; this responsibility is delegated to its concrete subclasses.
 *
 * Usage
 * - Use abstract classes to define a common base for related classes.
 * - Enforce a contract through abstract methods while sharing code in concrete methods.
 * - Ideal when you want partial implementation but still require subclass customization.
 * - Supports polymorphism and promotes maintainable, extensible object-oriented design.
 */

/*
 * Abstract Class Declaration
 * - Demonstrates an abstract class "Animal" that cannot be instantiated directly.
 * - Abstract methods must be implemented by concrete subclasses.
 */
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method: must be implemented by concrete subclasses
    public abstract void speak();

    // Concrete method: shared behavior for all subclasses
    public String getName() {
        return name;
    }
}

/*
 * Subclass Declarations
 * - Concrete subclasses of Animal must implement all abstract methods.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void speak() {
        IO.println("woof!");
    }
}
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        IO.println("meow!");
    }
}

/*
 * Usage Example
 * - The example below calls both concrete and abstract methods on subclass instances.
 * - Shows that abstract classes cannot be instantiated directly.
 */
void main() {
    // Creating subclass instances
    Animal dog = new Dog("Rex");
    Animal cat = new Cat("Tom");

    // Creating abstract class instance (not allowed)
    // Animal a = new Animal("Test"); - Compile-time error

    // Calling property method
    IO.println(dog.getName()); // Output: Rex
    IO.println(cat.getName()); // Output: Tom

    // Calling abstract method
    dog.speak(); // Output: woof!
    cat.speak(); // Output: meow!
}