/*
 * Bridge Design Pattern
 * - This section explains the "Bridge" design pattern, which decouples an abstraction from its implementation so that
 *   the two can vary independently.
 *
 * Overview
 * - The Bridge pattern is a structural design pattern.
 * - It separates high-level abstraction logic from low-level implementation details.
 * - It is especially useful when both abstractions and implementations are expected to change independently.
 * - Commonly used to avoid large inheritance hierarchies.
 *
 * Key Elements
 * - Abstraction: defines the high-level interface and maintains a reference to an Implementor.
 * - RefinedAbstraction: extends the Abstraction and adds specialized behavior.
 * - Implementor: defines the interface for implementation classes.
 * - ConcreteImplementor: provides a concrete implementation of the Implementor interface.
 *
 * Key Characteristics
 * - Favors composition over inheritance.
 * - Allows independent evolution of abstractions and implementations.
 * - Reduces class explosion caused by combinatorial inheritance.
 * - Improves flexibility and extensibility of both abstraction and implementation hierarchies.
 *
 * Usage
 * - Use Bridge when you want to separate abstraction from implementation.
 * - Apply when changes in implementation should not affect client code.
 * - Ideal for cross-platform systems, device drivers, UI frameworks, or rendering engines.
 * - Prefer Bridge to inheritance when multiple dimensions of variation exist.
 */

/*
 * Abstraction
 * - Defines the high-level interface and maintains a reference to an Implementor.
 */
public class SimpleLogger {
    protected Writer writer;

    public SimpleLogger(Writer writer) {
        this.writer = writer;
    }

    public void logMessage(String message) {
        writer.write(message);
    }
}

/*
 * RefinedAbstraction
 * - Extends the Abstraction and adds specialized behavior.
 */
public class Logger extends SimpleLogger {
    public Logger(Writer writer) {
        super(writer);
    }

    public void logError(String message) {
        writer.write("ERROR: " + message);
    }
}

//======================================================================================================================
// Conceptually, the Bridge would be present here!
//======================================================================================================================

/*
 * Implementor
 * - Defines the interface for implementation classes.
 */
public interface Writer {
    void write(String message);
}

/*
 * ConcreteImplementor
 * - Provides a concrete implementation of the Implementor interface.
 */
public class ConsoleWriter implements Writer {
    @Override
    public void write(String message) {
        IO.println(message);
    }
}

/*
 * Example
 * - The example below shows the usage of the Bridge design pattern.
 */
void main() {
    Writer consoleWriter = new ConsoleWriter();
    Logger logger = new Logger(consoleWriter);

    logger.logMessage("Hello World!");    // Output: Hello World!
    logger.logError("Validation failed"); // Output: ERROR: Validation failed
}