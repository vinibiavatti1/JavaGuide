/*
Annotation Runtime Processing
- This document focuses exclusively on processing Java annotations at runtime using reflection, enabling dynamic access
  to metadata attached to classes, methods, constructors, and fields.

Overview
- Runtime annotation processing allows programs to inspect and react to annotations while the application is running.
- Annotations must be marked with @Retention(RetentionPolicy.RUNTIME) to be accessible at runtime.
- Reflection is the primary mechanism for runtime processing: classes, methods, constructors, and fields can be
  inspected to retrieve annotations and their values.

Key Characteristics
- Only annotations retained at runtime can be processed via reflection.
- Runtime processing enables dynamic behavior based on metadata, such as:
  - Configuring objects or properties
  - Controlling method execution
  - Validation or conditional logic
- The workflow typically involves:
  1. Obtaining a Class, Method, Constructor, or Field object.
  2. Retrieving annotations with getAnnotation(Class<T>) or getDeclaredAnnotations().
  3. Accessing annotation elements to guide program behavior.

Usage
- Use runtime annotation processing when dynamic behavior or metadata-driven logic is required.
- Ideal for frameworks, dependency injection, validation, logging, or dynamic configuration systems.
- Ensure annotations intended for runtime processing have @Retention(RetentionPolicy.RUNTIME).
*/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface Metadata {
    String value();
}

public static class Person {
    @Metadata("Anna")
    public String name;

    @Metadata("Mary")
    public Person(String name) { this.name = name; }

    @Metadata("Hello!")
    public void say(String message) { IO.println(message); }
}

void main() throws Exception {
    /*
    Processing Annotated Field
    - Demonstrates how to read and process an annotation applied to a field using reflection.
    - Retrieves the Field metadata from the class and accesses its associated annotation.
    - Uses the annotation value to dynamically modify the field at runtime.
    - Output: Anna
    */
    Person person = new Person("John");
    Field field = Person.class.getDeclaredField("name");
    Metadata annotation = (Metadata) field.getAnnotation(Metadata.class);
    field.set(person, annotation.value());
    IO.println(person.name);

    /*
    Processing Annotated Constructor
    - Demonstrates how to read and process an annotation applied to a constructor using reflection.
    - Retrieves the Constructor metadata and accesses its associated annotation.
    - Uses the annotation value to control object instantiation dynamically at runtime.
    - Output: Mary
    */
    Constructor constructor = Person.class.getDeclaredConstructor(String.class);
    annotation = (Metadata) constructor.getAnnotation(Metadata.class);
    person = (Person) constructor.newInstance(annotation.value());
    IO.println(person.name);

    /*
    Processing Annotated Method
    - Demonstrates how to read and process an annotation applied to a method using reflection.
    - Retrieves the Method metadata and accesses its associated annotation.
    - Uses the annotation value as an argument when invoking the method dynamically.
    - Output: Hello!
    */
    person = new Person("John");
    Method method = Person.class.getDeclaredMethod("say", String.class);
    annotation = (Metadata) method.getAnnotation(Metadata.class);
    method.invoke(person, annotation.value());
}