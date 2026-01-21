/*
 * Object Class
 * - This section explains that all Java classes implicitly extend Object and provides a brief description of its main
 *   methods.
 *
 * Overview
 * - Every class in Java automatically extends "java.lang.Object" unless it explicitly extends another class.
 * - "Object" provides basic methods that all classes inherit, including:
 *   - "equals()", "hashCode()", "toString()", "getClass()", "notify()", "notifyAll()", and "wait()".
 * - These methods form the foundation for object comparison, hashing, string representation, runtime type inspection,
 *   and basic thread coordination.
 *
 * Concurrency Methods
 * - "wait()", "notify()", and "notifyAll()" are low-level methods used for thread communication.
 * - "wait()" causes the current thread to release the monitor and wait until another thread calls "notify()" or
 *   "notifyAll()" on the same object.
 * - "notify()" wakes up a single waiting thread, while "notifyAll()" wakes up all waiting threads.
 * - These methods are essential for synchronized communication between threads, but they are considered low-level and
 *   error-prone.
 * - High-level concurrency utilities from "java.util.concurrent" are generally preferred over using these methods
 *   directly.
 * - Due to their complexity, these concurrency methods will not be demonstrated in the examples.
 *
 * Usage
 * - Use "Object" methods for:
 *   - Comparing objects ("equals()")
 *   - Generating hash codes ("hashCode()")
 *   - Converting objects to string representation ("toString()")
 *   - Inspecting runtime type ("getClass()")
 *   - Basic thread synchronization ("wait()", "notify()", "notifyAll()")
 */

/*
 * Any Top-Level Class Declaration Extends Object
 * - In Java, every top-level class implicitly extends "java.lang.Object" if no other superclass is specified.
 * - The class below is equivalent to: "public class MyClass extends Object {}"
 * - As a result, all classes inherit the methods defined in Object.
 */
public class MyClass {}

/*
 * Object Methods
 * - Demonstrates some of the key methods inherited from the Object class, which are available to all Java classes.
 */
void main() throws Exception {
    /*
     * Equals
     * - Compares this object with another for equality.
     * - Returns true if the objects are logically equal.
     * - Output: false
     */
    MyClass a = new MyClass();
    MyClass b = new MyClass();
    IO.println(a.equals(b));

    /*
     * Hash Code
     * - Returns an integer representing the object's memory-based hash code.
     * - Used in hash-based collections like HashMap and HashSet.
     * - Output: 713338599
     */
    MyClass x = new MyClass();
    IO.println(x.hashCode());

    /*
     * To String
     * - Returns a string representation of the object.
     * - Default format: ClassName@HashCodeInHex
     * - Output: MyClass@2a84aee7
     */
    x = new MyClass();
    IO.println(x.toString());

    /*
     * Get Class
     * - Returns the runtime class of this object.
     * - Can be used for reflection and type inspection.
     * - Output: class MyClass
     */
    x = new MyClass();
    Class<?> clazz = x.getClass();
    IO.println(clazz);
}