/*
 * Decorator Design Pattern
 * - This section explains the "Decorator" design pattern, which allows behavior to be added to individual objects
 *   dynamically without affecting the behavior of other objects of the same class.
 *
 * Overview
 * - The Decorator pattern is a structural design pattern.
 * - It provides a flexible alternative to subclassing for extending functionality.
 * - Behavior can be added or removed at runtime by wrapping objects.
 * - Commonly used to add responsibilities to objects in a transparent and composable way.
 *
 * Key Elements
 * - Component: defines the common interface for objects that can have responsibilities added.
 * - ConcreteComponent: defines the base object to which additional behavior can be attached.
 * - Decorator: maintains a reference to a Component and implements the same interface.
 * - ConcreteDecorator: adds responsibilities to the component by extending the Decorator.
 *
 * Key Characteristics
 * - Favors composition over inheritance.
 * - Allows dynamic addition of behavior without modifying existing code.
 * - Supports combining multiple decorators to compose complex behavior.
 * - Keeps classes focused on a single responsibility.
 *
 * Usage
 * - Use Decorator when you need to add behavior to objects dynamically.
 * - Apply when subclassing would result in an excessive number of classes.
 * - Ideal for extending functionality in a flexible and reusable way.
 * - Common examples include I/O streams, UI components, and middleware pipelines.
 */

/*
 * Component
 * - Defines the common interface for objects that can have responsibilities added.
 */
public interface Logger {
    void log(String message);
}

/*
 * ConcreteComponent
 * - Defines the base object to which additional behavior can be attached.
 */
public class SimpleLogger implements Logger {
    @Override
    public void log(String message) {
        IO.println(message);
    }
}

/*
 * Decorator
 * - Maintains a reference to a Component and implements the same interface.
 */
public abstract class BaseLoggerDecorator implements Logger {
    protected Logger logger;

    public BaseLoggerDecorator(Logger logger) {
        this.logger = logger;
    }
}

/*
 * Component
 * - Adds responsibilities to the component by extending the Decorator.
 */
public class DateTimeLoggerDecorator extends BaseLoggerDecorator {
    public DateTimeLoggerDecorator(Logger logger) {
        super(logger);
    }

    @Override
    public void log(String message) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        logger.log(date + " " + message);
    }
}

/*
 * Example
 * - The example below shows the usage of the Decorator design pattern.
 */
void main() {
    Logger logger = new SimpleLogger();
    DateTimeLoggerDecorator dateTimeLoggerDecorator = new DateTimeLoggerDecorator(logger);
    dateTimeLoggerDecorator.log("Hello World!"); // Output: 2026-01-15 19:14:46 Hello World!
}