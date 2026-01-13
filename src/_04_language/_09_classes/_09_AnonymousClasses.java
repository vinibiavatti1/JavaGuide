/*
 * Anonymous Classes
 * - This section explains anonymous classes in Java, which are unnamed classes defined inline at the point of use.
 *
 * Overview
 * - Anonymous classes are a type of nested class introduced in Java 1.1.
 * - They are typically used for:
 *   - Implementing interfaces for callbacks, listeners, or event handlers.
 *   - Extending a class with a minor or custom behavior without creating a separate named class.
 * - Anonymous classes are less reusable but very convenient for small tasks that do not require a full class
 *   declaration.
 * - They can access members of their enclosing class and effectively final local variables from the enclosing scope.
 * - The JVM generates a class file for each anonymous class, named with "$" followed by a number (e.g.,
 *   "Outer$1.class").
 *
 * Key Characteristics
 * - Anonymous classes do not have a name and cannot declare constructors.
 * - They are always inner classes in the sense that they capture a reference to their enclosing context if needed.
 * - They can override methods of a superclass or implement interface methods.
 * - Reflection metadata:
 *   - "getEnclosingClass()" returns the outer class that contains the anonymous class.
 *   - "getEnclosingMethod()" or "getEnclosingConstructor()" returns the method or constructor in which the anonymous
 *     class is defined.
 *   - "getDeclaringClass()" often returns "null" because anonymous classes are not explicitly declared with a name.
 *
 * Usage
 * - Use anonymous classes when you need a short, one-off implementation of an interface or subclass.
 * - Ideal for event listeners, callbacks, or temporary objects that do not require a separate named class.
 * - Avoid using anonymous classes for complex logic or reusable functionality; in such cases, use named inner or
 *   top-level classes.
 * - Can be replaced with lambda expressions for functional interfaces in Java 8 and later, simplifying syntax further.
 */
void main() {
    /*
     * Define Anonymous Class From Interface
     * - Creates an unnamed class implementing Runnable inline.
     * - Provides a one-off implementation of run() without a separate class.
     * - Output: Hello from anonymous class!
     */
    Runnable task = new Runnable() {
        @Override
        public void run() {
            IO.println("Hello from anonymous class!");
        }
    };
    task.run();

    /*
     * Define Anonymous Class From Class
     * - Creates an unnamed class that extends ArrayList inline.
     * - Overrides the add() method to customize behavior without creating a separate subclass.
     * - Output: Hello from anonymous class!
     */
    ArrayList<String> anonymousList = new ArrayList<String>() {
        @Override
        public boolean add(String s) {
            IO.println("Hello from anonymous class!");
            return false;
        }
    };
    anonymousList.add("Test");
}