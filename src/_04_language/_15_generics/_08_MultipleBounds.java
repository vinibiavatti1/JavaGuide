/*
 * Multiple Bounds (&)
 * - This section explains how to use multiple bounds in Java generics, allowing a type parameter to be restricted to a
 *   class and one or more interfaces at the same time.
 *
 * Overview
 * - Multiple bounds use the "&" operator with the "extends" keyword.
 * - A generic type can be constrained to satisfy multiple contracts.
 * - At most one class is allowed; interfaces can be combined freely.
 *
 * Key Characteristics
 * - Syntax: <T extends Class & Interface1 & Interface2 & ...>
 * - The class (if present) must appear first.
 * - Interfaces must come after the class.
 * - Enables safe access to methods from all bounded types.
 *
 * Usage
 * - Use multiple bounds when a generic type must provide behavior from multiple sources.
 * - Common in utilities, comparisons, sorting, or validation logic.
 * - Improves compile-time safety and expressiveness of APIs.
 * - Use when you need to restrict even more the type argument to satisfy more abstractions.
 *
 * Example:
 * - The example defines two interfaces and one class.
 * - A generic class uses multiple bounds to restrict its type.
 * - The generic class can safely call methods from the class and both interfaces.
 * - User object is allowed to be set in Container because it satisfies all generic bounds:
 *   - Extends Entity
 *   - Implements Identifiable
 *   - Implements Printable
 */
public interface Identifiable {
    String getId();
}

public interface Printable {
    void print();
}

public class Entity {
    public void save() {
        IO.println("Entity saved");
    }
}

public class Container<T extends Entity & Identifiable & Printable> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public void process() {
        value.save();              // from Entity
        IO.println(value.getId()); // from Identifiable
        value.print();             // from Printable
    }
}

public class User extends Entity implements Identifiable, Printable {
    private final String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void print() {
        IO.println("User ID: " + id);
    }
}

void main() {
    Container<User> container = new Container<>();
    container.set(new User("U-123")); // Allowed: User satisfies all generic bounds
    container.process();
}