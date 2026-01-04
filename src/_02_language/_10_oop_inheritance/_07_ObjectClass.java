/*
Object Class
- This section explains that all Java classes implicitly extend Object and provides a brief description of its main
  methods.

Overview
- Every class in Java automatically extends java.lang.Object unless it explicitly extends another class.
- Object provides basic methods that all classes inherit.
- These methods include equals, hashCode, toString, getClass, notify, notifyAll, and wait.

Usage
- Use these methods to compare objects, get their hash code, convert to string, get runtime type, and manage thread
  synchronization.
*/
public class MyClass {} // Implicit "extends Object".

void main() throws Exception {
    /*
    Class Instance
    - Creating an instance of MyClass.
    - Every object has Object methods available.
    */
    MyClass x = new MyClass();

    /*
    Equals
    - Compares this object with another for equality.
    - Returns true if the objects are logically equal.
    - Output: false
    */
    IO.println(x.equals(new MyClass()));

    /*
    Hash Code
    - Returns an integer representing the object's memory-based hash code.
    - Used in hash-based collections like HashMap and HashSet.
    - Output: 713338599
    */
    IO.println(x.hashCode());

    /*
    To String
    - Returns a string representation of the object.
    - Default format: ClassName@HashCodeInHex
    - Output: _07_Object$MyClass@2a84aee7
    */
    IO.println(x.toString());

    /*
    Get Class
    - Returns the runtime class of this object.
    - Can be used for reflection and type inspection.
    - Output: _07_Object$MyClass
    */
    Class<?> clazz = x.getClass();
    IO.println(clazz.getName());

    /*
    Notify
    - Wakes up a single thread waiting on this object's monitor.
    - Must be inside synchronized block to avoid IllegalMonitorStateException
    - Used in multithreading for coordination.
    */
    synchronized(x) {
        x.notify();
    }

    /*
    Notify All
    - Wakes up all threads waiting on this object's monitor.
    - Must be inside synchronized block to avoid IllegalMonitorStateException
    - Useful for broadcasting changes in multithreaded code.
    */
    synchronized(x) {
        x.notifyAll();
    }

    /*
    Wait
    - Causes the current thread to wait until notified or interrupted.
    - Must be inside synchronized block to avoid IllegalMonitorStateException
    - Used for thread coordination.
    */
    synchronized(x) {
        x.wait(1L);
    }
}