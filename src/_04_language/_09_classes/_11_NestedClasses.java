/*
Nested Classes
- This section explains nested classes in Java, which are classes defined within another class. Nested classes allow
  logically grouping classes that are only used in one place, improving encapsulation and readability of the code.

Overview
- Nested classes are part of standard Java and include four types:
  - Static Nested Classes: behave like top-level classes but scoped within the outer class; do not have a reference to
    the outer instance.
  - Inner Classes: non-static, associated with an instance of the outer class; can access outer class members directly.
  - Local Classes: defined within a method or block; visible only within that scope.
  - Anonymous Classes: unnamed classes defined inline; often used for callbacks, listeners, or simple one-off
    implementations.
- Nested classes are less commonly used in everyday programming, but are useful for small helper classes and situations
  requiring encapsulation within a containing class.
- Introduced in Java 1.1 and remain part of the language for structuring code logically.

Key Characteristics
- Nested classes can access private members of their enclosing class (inner, local, anonymous).
- Static nested classes do not hold an implicit reference to the outer class instance.
- Local and anonymous classes can capture effectively final variables from the enclosing scope.
- The JVM provides metadata for nested classes via reflection:
  - "getDeclaringClass()" shows the class that declared the nested class.
  - "getEnclosingClass()" and related methods show the runtime enclosing context for inner, local, and anonymous
    classes.
- Nested classes are compiled into separate class files with "$" in their names (e.g., "Outer$Inner.class").

Usage
- Use nested classes when a class is tightly coupled to its outer class and not needed elsewhere.
- Ideal for organizing helper classes, encapsulating implementation details, or creating concise callbacks.
- Use static nested classes for utility classes that do not require a reference to the outer instance.
- Inner, local, and anonymous classes are useful for maintaining encapsulation while providing access to the outer class
  context.
- Avoid overusing nested classes for large or widely reused classes, as it can reduce readability and increase coupling.
*/
public class Outer {
    class Inner {}
    static class StaticInner {}
}

void main() {
    /*
    Create Instance of Outer Class
    - Instantiates the top-level outer class normally using its constructor.
    - No special syntax is required since it is a standard class.
    - Useful as a reference point for creating inner class instances that depend on an outer instance.
    */
    Outer outer = new Outer();

    /*
    Create Instance of Inner Class
    - Instantiates a non-static inner class, which requires a reference to an existing instance of the enclosing outer
      class.
    - Syntax: outerInstance.new InnerClass()
    - Inner classes hold an implicit reference to the outer instance and can access its private members.
    - Useful for logically grouping classes that need access to the outer class context.
    */
    Outer.Inner inner = outer.new Inner();

    /*
    Create Instance of Static Nested Class
    - Instantiates a static nested class, which does not require a reference to an outer class instance.
    - Syntax: OuterClass.StaticNestedClass()
    - Static nested classes behave like top-level classes but are scoped inside the outer class.
    - Useful for utility classes, constants, or helpers related to the outer class without requiring its instance.
    */
    Outer.StaticInner staticInner = new Outer.StaticInner();
}