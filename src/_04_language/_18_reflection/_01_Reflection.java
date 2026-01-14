/*
 * Reflection
 * - This section explains the concept of reflection in Java, which allows programs to inspect, analyze, and manipulate
 *   classes, methods, fields, and constructors at runtime.
 *
 * Etymology
 * - The name "reflection" was chosen because it conceptually mirrors the idea of "looking at yourself":
 * - Just as a mirror reflects an object visually, reflection in Java allows a program to examine its own structure and
 *   behavior at runtime.
 * - This introspection metaphor emphasizes the ability to observe and act upon the internal details of objects while
 *   the program is executing.
 *
 * Overview
 * - Reflection is supported through the java.lang.reflect package, and every class in Java has an associated
 *   java.lang.Class object that stores its metadata.
 * - Through Class objects, reflection provides access to: fields (Field), methods (Method), constructors (Constructor),
 *   modifiers, annotations, superclass information, etc.
 * - Reflection enables dynamic behavior such as:
 *   - Instantiating objects without knowing their type at compile time
 *   - Invoking methods and accessing fields dynamically
 *   - Loading classes by name at runtime using "Class.forName()"
 * - Reflection is widely used in frameworks, dependency injection, serialization libraries, testing frameworks, and
 *   plugin architectures where runtime type information is crucial.
 * - Introduced in early Java versions (1.1) and has evolved to support annotations and more detailed metadata access.
 *
 * Key Characteristics
 * - Reflection operates primarily through instances of "java.lang.Class" and related types (Field, Method,
 *   Constructor).
 * - It allows inspection of classes regardless of visibility, although private access requires enabling accessibility.
 * - Methods like "getClass()", "Class.forName()", "getDeclaredMethods()", and "getDeclaredFields()" provide runtime
 *   introspection capabilities.
 * - Supports dynamic invocation of methods and constructors via "Method.invoke()" and "Constructor.newInstance()".
 * - Allows querying annotations, modifiers, interfaces, superclasses, and nested classes.
 * - Reflection can bypass compile-time type checking in a controlled way, often requiring explicit casts.
 *
 * Usage
 * - Use reflection when you need to inspect or manipulate classes dynamically, for example in:
 *   - Frameworks that need to instantiate objects without knowing concrete types at compile time
 *   - Serialization and deserialization of objects
 *   - Unit testing and mocking private methods or fields
 *   - Dynamic proxy creation and plugin systems
 * - Be mindful that reflection can introduce performance overhead and reduce type safety.
 *
 * Example
 * - A class "Person" was defined to be used as the target class for the reflection operations below.
 * - The examples provide a foundation for performing runtime inspection and dynamic behavior using reflection.
 */
import java.beans.JavaBean;
import java.lang.annotation.Annotation;

@JavaBean
public static class Person<T> implements Serializable {
    // Fields
    private static String defaultName = "Unknown";
    private String name = "John";

    // Constructors
    public Person() {}

    // Methods
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Inner Classes
    class Inner {}
    static class StaticInner {}
}

void main() throws Exception {
    //==================================================================================================================
    // Class Instance
    //==================================================================================================================

    /*
     * Get Class via Class Literal
     * - The ".class" literal provides a direct reference to the Class object associated with a given type.
     * - This approach is resolved at compile time and does not require an instance of the class.
     * - Commonly used in reflection, type-safe APIs, and framework configuration.
     * - Output: class _01_Reflection$Person
     */
    Class<Person> clazz = Person.class;
    IO.println(clazz);

    /*
     * Get Class from Object Instance
     * - The "getClass()" method is inherited from java.lang.Object and returns the runtime Class of the instance.
     * - This approach requires an existing object and is resolved dynamically at runtime.
     * - Useful when the concrete type of the object is not known at compile time.
     * - Because "getClass()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required.
     * - Output: class _01_Reflection$Person
     */
    Person instance = new Person();
    clazz = (Class<Person>) instance.getClass();
    IO.println(clazz);

    /*
     * Get Class by Fully Qualified Name
     * - The "Class.forName()" method loads (or retrieves) a class using its fully qualified name.
     * - This approach is resolved at runtime and is commonly used in frameworks, dependency injection, and plugin
     *   systems.
     * - It allows dynamic loading of classes without compile-time dependencies.
     * - Because "Class.forName()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required.
     * - Throws ClassNotFoundException if the specified class name cannot be found by the ClassLoader.
     * - Output: class _01_Reflection$Person
     */
    clazz = (Class<Person>) Class.forName("_01_Reflection$Person");
    IO.println(clazz);

    /*
     * Get Class of a Standard Java Type by Fully Qualified Name
     * - The "Class.forName()" method loads (or retrieves) a class using its fully qualified name.
     * - This approach is resolved at runtime and allows dynamic loading of classes without compile-time dependencies.
     * - Because "Class.forName()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required
     *   when assigning to a variable with a specific type.
     * - Throws ClassNotFoundException if the specified class name cannot be found by the ClassLoader.
     * - Useful for obtaining Class objects of standard Java types or any class known only by name at runtime.
     * - Output: class java.lang.Integer
     */
    Class<Integer> integerClass = (Class<Integer>) Class.forName("java.lang.Integer");
    IO.println(integerClass);

    //==================================================================================================================
    // Class Introspection
    //==================================================================================================================

    /*
     * Get Class Name
     * - The "getName()" method returns the fully qualified binary name of the class, including its package and
     *   enclosing classes.
     * - For nested classes, the name includes the '$' separator used by the JVM.
     * - The "getSimpleName()" method returns only the simple class name, without package or enclosing context.
     * - Output: _01_Reflection$Person / Person
     */
    IO.println(Person.class.getName() + " / " + Person.class.getSimpleName());

    /*
     * Get Modifiers
     * - The "getModifiers()" method returns an integer representing the class's modifiers, such as public, final,
     *   abstract, etc.
     * - Use the Modifier class (java.lang.reflect.Modifier) to interpret the integer, e.g.,
     *   Modifier.isPublic(modifiers).
     * - Useful for inspecting access levels and properties of classes dynamically.
     * - Output: public static
     */
    int modifiers = Person.class.getModifiers();
    IO.println(Modifier.toString(modifiers));

    /*
     * Get Super Class
     * - The "getSuperclass()" method returns the direct superclass of the current class.
     * - If the class does not explicitly extend another class, the superclass is "java.lang.Object".
     * - Returns null only for Object itself.
     * - Output: class java.lang.Object
     */
    IO.println(Person.class.getSuperclass());

    /*
     * Get Annotations
     * - The "getAnnotations()" method returns annotations present on the class and inherited from superclasses.
     * - The "getDeclaredAnnotations()" method returns only annotations directly declared on the class.
     * - The "getDeclaredAnnotation(Class<T>)" method retrieves a specific annotation by its type.
     * - Output: interface java.beans.JavaBean
     */
    for (Annotation annotation : Person.class.getDeclaredAnnotations()) {
        IO.println(annotation.annotationType());
    }

    /*
     * Get Type Parameters
     * - The "getTypeParameters()" method returns the generic type parameters declared by the class.
     * - These type parameters represent placeholders (e.g., T, E, K, V, etc.) used in generic class definitions.
     * - If the class is not generic, this method returns an empty array.
     * - Output: T
     */
    for (TypeVariable type : Person.class.getTypeParameters()) {
        IO.println(type);
    }

    /*
     * Get Interfaces
     * - The "getInterfaces()" method returns all interfaces directly implemented by the class.
     * - Interfaces implemented by superclasses are also included in the result.
     * - The returned array contains Class objects representing each interface.
     * - Output: interface java.io.Serializable
     */
    for (Class inter : Person.class.getInterfaces()) {
        IO.println(inter);
    }

    /*
     * Get Nested Classes
     * - The "getDeclaredClasses()" method returns all classes and interfaces declared directly within the current
     *   class, including static and inner classes.
     * - The "getClasses()" method returns only the public nested classes, including inherited ones.
     * - Anonymous classes are not included in this list.
     * - Output: class _01_Reflection$Person$StaticInner | class _01_Reflection$Person$Inner
     */
    for (Class<?> inner : Person.class.getDeclaredClasses()) {
        IO.println(inner);
    }

    /*
     * Get Declared Fields
     * - The "getDeclaredFields()" method returns all fields declared directly in the class, regardless of access
     *   modifier.
     *   This includes private, protected, package-private, public, static, and compiler-generated fields.
     * - The "getFields()" method returns only public fields, including those inherited from superclasses.
     * - The "getDeclaredField(String)" method retrieves a specific field by name from the declaring class.
     * - Output: defaultName | name
     */
    for (Field field : Person.class.getDeclaredFields()) {
        IO.println(field.getName());
    }

    /*
     * Get Constructors
     * - The "getDeclaredConstructors()" method returns all constructors declared directly in the class, regardless of
     *   access. This includes public, protected, package-private, and private constructors.
     * - The "getConstructors()" method returns only public constructors, including those inherited from superclasses.
     * - The "getConstructor(Class<?>...)" method retrieves a specific public constructor by its parameter types.
     * - Output: _01_Reflection$Person
     */
    for (Constructor constructor : Person.class.getDeclaredConstructors()) {
        IO.println(constructor.getName());
    }

    /*
     * Get Methods
     * - The "getDeclaredMethods()" method returns all methods declared directly in the class, regardless of access
     *   modifier. This includes private, protected, package-private, public, static methods, and compiler-generated
     *   methods.
     * - The "getMethods()" method returns only public methods, including those inherited from superclasses.
     * - The "getDeclaredMethod(String, Class<?>...)" method retrieves a specific method by name and parameter types,
     *   which is important when multiple overloaded methods exist.
     * - Output: getName | setName
     */
    for (Method method : Person.class.getDeclaredMethods()) {
        IO.println(method.getName());
    }
}