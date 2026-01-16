/*
 * Chain of Responsibility Design Pattern
 * - This section explains the "Chain of Responsibility" design pattern, which allows a request to be passed along a
 *   chain of handlers until one of them handles the request.
 *
 * Overview
 * - The Chain of Responsibility pattern is a behavioral design pattern.
 * - It decouples the sender of a request from its receivers.
 * - Each handler decides either to process the request or to pass it to the next handler in the chain.
 * - The client does not need to know which handler will process the request.
 *
 * Key Elements
 * - Handler: defines an interface for handling requests and maintaining a reference to the next handler.
 * - ConcreteHandler: implements the handling logic and decides whether to process or forward the request.
 * - Client: initiates the request and sends it to the first handler in the chain.
 * - Request:
 *
 * Key Characteristics
 * - Promotes loose coupling between request senders and receivers.
 * - Allows dynamic composition of processing chains.
 * - Each handler focuses on a single responsibility.
 * - Multiple handlers may process the same request, or none at all.
 *
 * Usage
 * - Use Chain of Responsibility when multiple objects can handle a request and the handler is not known in advance.
 * - Apply when you want to process requests in a specific order.
 * - Useful for validation pipelines, event processing, logging systems, and middleware-style architectures.
 * - Helps avoid large conditional blocks (if / else or switch statements).
 */

/*
 * Handler
 * - Defines an interface for handling requests and maintaining a reference to the next handler.
 */
public abstract class TextHandler {
    protected TextHandler next;

    public abstract String handle(String text);

    public void setNext(TextHandler next) {
        this.next = next;
    }
}

/*
 * ConcreteHandler
 * - Implements the handling logic and decides whether to process or forward the request.
 */
public class TrimTextHandler extends TextHandler {
    @Override
    public String handle(String text) {
        IO.println("Trimming...");
        text = text.trim();
        return next == null ? text : next.handle(text);
    }
}
public class NormalizeTextHandler extends TextHandler {
    @Override
    public String handle(String text) {
        IO.println("Normalizing...");
        text = text.replaceAll("\s+", " ");
        return next == null ? text : next.handle(text);
    }
}
public class UpperCaseTextHandler extends TextHandler {
    @Override
    public String handle(String text) {
        IO.println("Upper Casing...");
        text = text.toUpperCase();
        return next == null ? text : next.handle(text);
    }
}

/*
 * Client
 * - Initiates the request and sends it to the first handler in the chain.
 */
public class TextProcessor {
    private TextHandler handler;

    public TextProcessor() {
        TrimTextHandler trimTextHandler = new TrimTextHandler();
        NormalizeTextHandler normalizeTextHandler = new NormalizeTextHandler();
        UpperCaseTextHandler upperCaseTextHandler = new UpperCaseTextHandler();

        trimTextHandler.setNext(normalizeTextHandler);
        normalizeTextHandler.setNext(upperCaseTextHandler);

        this.handler = trimTextHandler;
    }

    public String process(String text) {
        return this.handler.handle(text);
    }
}

/*
 * Example
 * - The example below shows the usage of the Chain of Responsibility design pattern.
 */
void main() {
    TextProcessor textProcessor = new TextProcessor();
    String result = textProcessor.process("   Hello  World   ");
    IO.println("Result: " + result);
    /*
     * Output:
     * Trimming...
     * Normalizing...
     * Upper Casing...
     * Result: HELLO WORLD
     */
}