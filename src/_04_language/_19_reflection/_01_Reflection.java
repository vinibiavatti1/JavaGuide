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
import java.beans.JavaBean;
import java.lang.annotation.Annotation;

@JavaBean
public static class Person<T> implements Serializable {
    // Static Fields
    private static final long serialVersionUID = 1L;

    // Fields
    private String name = "Unknown";
    private int age;

    // Constructors
    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Methods
    public void greet() {
        IO.println(String.format("Hello, my name is %s, and I am %d years old", name, age));
    }

    // Static Methods
    public static void staticGreet() {
        IO.println("Hello from Person class!");
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Inner Classes
    class Inner {}
    static class StaticInner {}
}

void main() throws Exception {
    //==================================================================================================================
    // Class Object
    //==================================================================================================================

    /*
    Get Class via Class Literal
    - The ".class" literal provides a direct reference to the Class object associated with a given type.
    - This approach is resolved at compile time and does not require an instance of the class.
    - Commonly used in reflection, type-safe APIs, and framework configuration.
    - Output: class _01_Reflection$Person
    */
    Class<Person> clazz = Person.class;
    IO.println(clazz);

    /*
    Get Class from Object Instance
    - The "getClass()" method is inherited from java.lang.Object and returns the runtime Class of the instance.
    - This approach requires an existing object and is resolved dynamically at runtime.
    - Useful when the concrete type of the object is not known at compile time.
    - Because "getClass()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required.
    - Output: class _01_Reflection$Person
    */
    Person instance = new Person("John", 35);
    clazz = (Class<Person>) instance.getClass();
    IO.println(clazz);

    /*
    Get Class by Fully Qualified Name
    - The "Class.forName()" method loads (or retrieves) a class using its fully qualified name.
    - This approach is resolved at runtime and is commonly used in frameworks, dependency injection, and plugin systems.
    - It allows dynamic loading of classes without compile-time dependencies.
    - Because "Class.forName()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required.
    - Throws ClassNotFoundException if the specified class name cannot be found by the ClassLoader.
    - Output: class _01_Reflection$Person
    */
    clazz = (Class<Person>) Class.forName("_01_Reflection$Person");
    IO.println(clazz);

    /*
    Get Class of a Standard Java Type by Fully Qualified Name
    - The "Class.forName()" method loads (or retrieves) a class using its fully qualified name.
    - This approach is resolved at runtime and allows dynamic loading of classes without compile-time dependencies.
    - Because "Class.forName()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required
      when assigning to a variable with a specific type.
    - Throws ClassNotFoundException if the specified class name cannot be found by the ClassLoader.
    - Useful for obtaining Class objects of standard Java types or any class known only by name at runtime.
    - Output: class java.lang.Integer
    */
    Class<Integer> integerClass = (Class<Integer>) Class.forName("java.lang.Integer");
    IO.println(integerClass);

    //==================================================================================================================
    // Class Introspection
    //==================================================================================================================

    /*
    Get Name
    -
    - Output: _02_Operations$Person / Person
    */
    IO.println(Person.class.getName() + " / " + Person.class.getSimpleName());

    /*
    Get Super Class
    -
    - Output: class java.lang.Object
    */
    IO.println(Person.class.getSuperclass());

    /*
    Get Interfaces
    -
    - Output: interface java.io.Serializable
    */
    for (Class inter : Person.class.getInterfaces()) {
        IO.println(inter);
    }

    /*
    Get Fields
    - (add note about this)
    - (add note about getFields vs getDeclaredFields)
    - (add note about getDeclaredField by name)
    - Output: serialVersionUID | name | age | this$0
    */
    for (Field field : Person.class.getDeclaredFields()) {
        IO.println(field.getName());
    }

    /*
    Get Methods
    - (add note about getMethods vs getDeclaredMethods)
    - (add note about getDeclaredMethod by name and params (because overload))
    - Output: greet | getName | setName | getAge | setAge | staticGreet
    */
    for (Method method : Person.class.getDeclaredMethods()) {
        IO.println(method.getName());
    }

    /*
    Get Constructors
    - (add note about getConstructors vs getDeclaredConstructors)
    - (add note about getConstructor by params)
    - Output: Person | Person
    */
    for (Constructor constructor : Person.class.getDeclaredConstructors()) {
        IO.println(constructor.getName());
    }

    /*
    Get Annotations
    - (add note about getAnnotations vs getDeclaredAnnotations)
    - (add note about getDeclaredAnnotation by type)
    - Output: interface java.beans.JavaBean
    */
    for (Annotation annotation : Person.class.getDeclaredAnnotations()) {
        IO.println(annotation.annotationType());
    }

    /*
    Get Type Parameters
    -
    - Output: T
    */
    for (TypeVariable type : Person.class.getTypeParameters()) {
        IO.println(type);
    }

    /*
    Get Nested Classes
    -
    - Output: Person$StaticInner | Person$Inner
    */
    for (Class<?> inner : Person.class.getDeclaredClasses()) {
        IO.println(inner);
    }

    //==================================================================================================================
    // Field Data
    //==================================================================================================================

    /*
    Get Static Field Data
    -
    - (add note about setAccessible)
    - (add note about null in get)
    - Output: 1
    */
    Field field = Person.class.getDeclaredField("serialVersionUID");
    field.setAccessible(true);
    long version = (long) field.get(null);
    IO.println(version);

    /*
    Get Field Data
    -
    - (add note about setAccessible)
    - Output: John
    */
    Person person = new Person("John", 35);
    field = Person.class.getDeclaredField("name");
    field.setAccessible(true);
    String name = (String) field.get(person);
    IO.println(name);

    //==================================================================================================================
    // Method Invocation
    //==================================================================================================================

    /*
    Invoke Static Methods
    -
    - Output: Hello from Person class!
    */
    Method method = Person.class.getDeclaredMethod("staticGreet");
    method.invoke(null);

    /*
    Invoke Methods
    -
    - Output: Hello, my name is John, and I am 35 years old
    */
    person = new Person("John", 35);
    method = Person.class.getDeclaredMethod("greet");
    method.invoke(person);

    /*
    Invoke Methods with Parameters
    -
    - Output: Anna
    */
    person = new Person("John", 35);
    method = Person.class.getDeclaredMethod("setName", String.class);
    method.invoke(person, "Anna");
    IO.println(person.getName());

    /*
    Invoke Methods with Return
    -
    - Output: John
    */
    person = new Person("John", 35);
    method = Person.class.getDeclaredMethod("getName");
    name = (String) method.invoke(person);
    IO.println(name);

    //==================================================================================================================
    // Invoke Constructors
    //==================================================================================================================

    /*
    Invoke Constructor (Create New Instance)
    - (add note about type param)
    - Output: Unknown
    */
    Constructor constructor = Person.class.getDeclaredConstructor();
    person = (Person) constructor.newInstance();
    IO.println(person.getName());

    /*
    Invoke Constructor With Arguments (Create New Instance)
    - (add note about type param)
    - Output: John
    */
    constructor = Person.class.getDeclaredConstructor(String.class, int.class);
    person = (Person) constructor.newInstance("John", 35);
    IO.println(person.getName());
}