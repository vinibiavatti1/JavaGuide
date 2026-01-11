/*

*/
import java.beans.JavaBean;
import java.lang.annotation.Annotation;

@JavaBean(description = "Hello World")
public class Person<T> implements Serializable {
    // Static Fields
    private static final long serialVersionUID = 1L;

    // Fields
    private String name;
    private int age;

    // Constructors
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Methods
    @Deprecated
    public void greet() {
        IO.println(String.format("Hello, my name is %s, and I am %d years old", name, age));
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Inner Classes
    class Inner {}
    static class StaticInner {}

    // Anonymous Class
    private Runnable anonymous = new Runnable() {
        @Override
        public void run() {
            IO.println("Hello World");
        }
    };
}

void main() throws ClassNotFoundException {
    //==================================================================================================================
    // Getting Class Instance
    //==================================================================================================================

    /*
    Get Class via Class Literal
    - The ".class" literal provides a direct reference to the Class object associated with a given type.
    - This approach is resolved at compile time and does not require an instance of the class.
    - Commonly used in reflection, type-safe APIs, and framework configuration.
    - Output: class _02_Operations$Person
    */
    Class<Person> clazz = Person.class;
    IO.println(clazz);

    /*
    Get Class from Object Instance
    - The "getClass()" method is inherited from java.lang.Object and returns the runtime Class of the instance.
    - This approach requires an existing object and is resolved dynamically at runtime.
    - Useful when the concrete type of the object is not known at compile time.
    - Because "getClass()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required.
    - Output: class _02_Operations$Person
    */
    Person person = new Person("John", 35);
    clazz = (Class<Person>) person.getClass();
    IO.println(clazz);

    /*
    Get Class by Fully Qualified Name
    - The "Class.forName()" method loads (or retrieves) a class using its fully qualified name.
    - This approach is resolved at runtime and is commonly used in frameworks, dependency injection, and plugin systems.
    - It allows dynamic loading of classes without compile-time dependencies.
    - Because "Class.forName()" returns a Class<?> (unknown type), an explicit cast to Class<Integer> is required.
    - Throws ClassNotFoundException if the specified class name cannot be found by the ClassLoader.
    - Output: class _02_Operations$Person
    */
    clazz = (Class<Person>) Class.forName("_02_Operations$Person");
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
    // Class Operations
    //==================================================================================================================

    /*
    Get Name
    -
    - Output: _02_Operations$Person / Person
    */
    clazz = Person.class;
    IO.println(clazz.getName() + " / " + clazz.getSimpleName());

    /*
    Get Super Class
    -
    - Output: class java.lang.Object
    */
    IO.println(clazz.getSuperclass());

    /*
    Get Interfaces
    -
    - Output: interface java.io.Serializable
    */
    for (Class inter : clazz.getInterfaces()) {
        IO.println(inter);
    }

    /*
    Get Fields
    - (add note about this)
    - (add note about getFields vs getDeclaredFields)
    - Output: name | age | this$0
    */
    for (Field field : clazz.getDeclaredFields()) {
        IO.println(field.getName());
    }

    /*
    Get Methods
    - (add note about getMethods vs getDeclaredMethods)
    - Output: greet | getName | setName | getAge | setAge
    */
    for (Method method : clazz.getDeclaredMethods()) {
        IO.println(method.getName());
    }

    /*
    Get Constructors
    - (add note about getConstructors vs getDeclaredConstructors)
    - Output: _02_Operations$Person
    */
    for (Constructor constructor : clazz.getDeclaredConstructors()) {
        IO.println(constructor.getName());
    }

    /*
    Get Annotations
    - (add note about getAnnotations vs getDeclaredAnnotations)
    - Output: interface java.beans.JavaBean
    */
    for (Annotation annotation : clazz.getDeclaredAnnotations()) {
        IO.println(annotation.annotationType());
    }

    /*
    Get Type Parameters
    -
    - Output: T
    */
    for (TypeVariable type : clazz.getTypeParameters()) {
        IO.println(type);
    }


}