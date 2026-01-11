/*
Reflection
- This section explains the concept of reflection in Java, which allows programs to inspect, analyze, and manipulate
  classes, methods, fields, and constructors at runtime.

Etymology
- The name "reflection" was chosen because it conceptually mirrors the idea of "looking at yourself":
- Just as a mirror reflects an object visually, reflection in Java allows a program to examine its own structure and
  behavior at runtime.
- This introspection metaphor emphasizes the ability to observe and act upon the internal details of objects while the
  program is executing.

Overview
- Reflection is supported through the java.lang.reflect package, and every class in Java has an associated
  java.lang.Class object that stores its metadata.
- Through Class objects, reflection provides access to: fields (Field), methods (Method), constructors (Constructor),
  modifiers, annotations, superclass information, etc.
- Reflection enables dynamic behavior such as:
  - Instantiating objects without knowing their type at compile time
  - Invoking methods and accessing fields dynamically
  - Loading classes by name at runtime using "Class.forName()"
- Reflection is widely used in frameworks, dependency injection, serialization libraries, testing frameworks, and plugin
  architectures where runtime type information is crucial.
- Introduced in early Java versions (1.1) and has evolved to support annotations and more detailed metadata access.

Key Characteristics
- Reflection operates primarily through instances of "java.lang.Class" and related types (Field, Method, Constructor).
- It allows inspection of classes regardless of visibility, although private access requires enabling accessibility.
- Methods like "getClass()", "Class.forName()", "getDeclaredMethods()", and "getDeclaredFields()" provide runtime
  introspection capabilities.
- Supports dynamic invocation of methods and constructors via "Method.invoke()" and "Constructor.newInstance()".
- Allows querying annotations, modifiers, interfaces, superclasses, and nested classes.
- Reflection can bypass compile-time type checking in a controlled way, often requiring explicit casts.

Usage
- Use reflection when you need to inspect or manipulate classes dynamically, for example in:
  - Frameworks that need to instantiate objects without knowing concrete types at compile time
  - Serialization and deserialization of objects
  - Unit testing and mocking private methods or fields
  - Dynamic proxy creation and plugin systems
- Be mindful that reflection can introduce performance overhead and reduce type safety.

Example
- The examples below demonstrate three common ways to obtain a Class object in Java:
  1. Using a class literal ("ClassName.class")
  2. Using an existing object instance ("getClass()")
  3. Loading a class dynamically by its fully qualified name ("Class.forName()")
- Each approach illustrates how reflection can access type information at runtime, with notes on casting when necessary
  and handling exceptions such as ClassNotFoundException.
- These examples provide a foundation for performing runtime inspection and dynamic behavior using reflection.
*/
void main() {}