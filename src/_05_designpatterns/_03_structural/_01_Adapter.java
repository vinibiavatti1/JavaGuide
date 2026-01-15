/*
 * Adapter Design Pattern
 * - This section explains the "Adapter" design pattern, which allows incompatible interfaces to work together by
 *   converting the interface of a class into another interface that a client expects.
 *
 * Overview
 * - The Adapter pattern is a structural design pattern.
 * - It acts as a bridge between two incompatible interfaces.
 * - It enables reuse of existing classes without modifying their source code.
 * - Commonly used when integrating legacy systems or third-party libraries.
 *
 * Key Elements
 * - Target: defines the interface expected by the client.
 * - Adapter: implements the Target interface and translates requests to the Adaptee.
 * - Adaptee: an existing class with an incompatible interface that needs to be adapted.
 * - Client: interacts with objects through the Target interface.
 *
 * Key Characteristics
 * - Promotes reuse of existing code by adapting incompatible interfaces.
 * - Decouples client code from concrete implementations.
 * - Can be implemented using object composition (Object Adapter) or inheritance (Class Adapter).
 * - Does not require changes to the existing Adaptee code.
 *
 * Usage
 * - Use Adapter when you want to use an existing class whose interface does not match the required one.
 * - Apply when integrating legacy code or external libraries.
 * - Ideal for wrapping third-party APIs to conform to internal application interfaces.
 * - Prefer object adapters (composition) in Java, as multiple inheritance is not supported.
 */

/*
 * Target
 * - Defines the interface expected by the client.
 */
public interface Logger {
    void log(String message);
}

/*
 * Adapter
 * - Implements the Target interface and translates requests to the Adaptee.
 */
public class LegacyLoggerAdapter implements Logger {
    private LegacyLogger legacyLogger;

    public LegacyLoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void log(String message) {
        this.legacyLogger.log("LOG: " + message);
    }
}

/*
 * Adaptee
 * - An existing class with an incompatible interface that needs to be adapted.
 */
public class LegacyLogger implements Logger {
    @Override
    public void log(String message) {
        IO.println(message);
    }
}

/*
 * Client
 * - Interacts with objects through the Target interface.
 */
public class Application {
    private Logger logger;

    public Application(Logger logger) {
        this.logger = logger;
    }

    public void log(String message) {
        logger.log(message);
    }
}

/*
 * Example
 * - The example below shows the usage of the Adapter design pattern.
 */
void main() {
    LegacyLogger legacyLogger = new LegacyLogger();
    LegacyLoggerAdapter legacyLoggerAdapter = new LegacyLoggerAdapter(legacyLogger);
    Application app = new Application(legacyLoggerAdapter);
    app.log("Hello World!"); // LOG: Hello World!
}