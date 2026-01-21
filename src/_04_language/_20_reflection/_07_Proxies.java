/*
 * Proxies
 * - This section explains Java Proxies, a reflection-based mechanism that allows you to create dynamic implementations
 *   of interfaces at runtime, enabling flexible delegation and interception of method calls.
 *
 * Overview
 * - Java Proxies are part of the java.lang.reflect package.
 * - They allow creation of objects that implement one or more interfaces without writing the implementation explicitly.
 * - Method calls on the proxy object are forwarded to a user-defined invocation handler, which can control behavior
 *   dynamically.
 * - Introduced in Java 1.3 and widely used for AOP, logging, mocking, and dynamic delegation patterns.
 *
 * Key Characteristics
 * - Proxies work only for interfaces; they cannot directly subclass concrete classes.
 * - The proxy class is generated at runtime and implements the specified interfaces.
 * - InvocationHandler is a functional interface with a single method:
 *   "invoke(Object proxy, Method method, Object[] args)".
 * - Method calls can be intercepted, modified, delegated, or even blocked.
 * - Supports multiple interfaces and can be cast to any of the implemented interface types.
 *
 * Usage
 * - Use proxies to create dynamic implementations without manually coding classes.
 * - Ideal for cross-cutting concerns like logging, security, transaction management, or mocking objects in tests.
 * - Combine with reflection to inspect or delegate method calls dynamically.
 *
 * Example
 * - This example demonstrates how to create a proxy for an interface, define dynamic behavior via an invocation
 *   handler, and intercept method calls at runtime.
 */
import java.lang.reflect.Proxy;

public interface Greeting {
    void sayHello(String name);
    void sayGoodbye(String name);
}

public static class GreetingHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        String methodName = method.getName();
        if (methodName.equals("sayHello")) {
            System.out.println("Hello, " + args[0] + "!");
        } else if (methodName.equals("sayGoodbye")) {
            System.out.println("Goodbye, " + args[0] + "!");
        }
        return null;
    }
}

void main() {
    Greeting greetingProxy = (Greeting) Proxy.newProxyInstance(
            Greeting.class.getClassLoader(),
            new Class[] { Greeting.class },
            new GreetingHandler()
    );
    greetingProxy.sayHello("Alice"); // Output: Hello, Alice!
    greetingProxy.sayGoodbye("Bob"); // Output: Goodbye, Bob!
}