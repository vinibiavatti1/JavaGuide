/*
 * Annotations
 * - This section explains Java Annotations, which provide a way to attach metadata to program elements such as classes,
 *   methods, fields, and parameters, without directly affecting program logic.
 *
 * Overview
 * - Annotations are part of the Java language (java.lang.annotation).
 * - They are used to supply metadata that can be processed by the compiler, development tools, or at runtime via
 *   reflection.
 * - Common use cases include configuration, documentation, code analysis, validation, and framework integration (e.g.,
 *   Spring, JPA, JUnit).
 *
 * Key Characteristics
 * - Annotations are defined using the @interface keyword.
 * - They do not contain executable code; they only declare metadata.
 * - Annotation elements are declared like methods without parameters.
 * - Annotations can be accessed via reflection depending on their retention policy.
 *
 * Supported Data Types
 * - Annotation elements can only use a restricted set of types:
 *   - Primitive types (int, boolean, etc.)
 *   - String
 *   - Class and Class<?>
 *   - Enum types
 *   - Other annotations
 *   - Arrays of the types above
 *
 * Special Element: value
 * - The element named "value" is special in annotations.
 * - If an annotation has only one element named "value", it can be used without explicitly naming it.
 * - Example: @MyAnnotation("text") instead of @MyAnnotation(value = "text").
 *
 * Default Values
 * - Annotation elements may define default values using the "default" keyword.
 * - Defaults must be compile-time constants.
 * - For array-typed elements, defaults must be specified as arrays (e.g., {} for an empty array).
 * - If no default is provided, the element becomes mandatory when using the annotation.
 *
 * Meta Annotations
 * - Meta-annotations are annotations that apply to other annotations.
 * - The most commonly used meta-annotations include:
 *   - @Retention: Defines how long the annotation is retained (SOURCE, CLASS, or RUNTIME).
 *   - @Target: Specifies the program elements where the annotation can be applied (TYPE, METHOD, FIELD, PARAMETER, ...)
 *   - @Repeatable: Allows the same annotation to be applied multiple times to the same element.
 *   - @Inherited: Indicates that an annotation on a class is inherited by its subclasses.
 *   - @Documented: Indicates that the annotation should appear in generated Javadoc.
 *
 * Retention Policies
 * - SOURCE
 *   - The annotation is discarded by the compiler.
 *   - Available only in source code.
 *   - Commonly used for documentation or compile-time checks (e.g., @Override).
 * - CLASS (default)
 *   - The annotation is stored in the .class file but not available at runtime.
 *   - This is the default retention policy if none is specified.
 *   - Useful for bytecode-level tools.
 * - RUNTIME
 *   - The annotation is stored in the .class file and available at runtime.
 *   - Can be accessed via reflection.
 *   - Commonly used by frameworks such as Spring, JPA, and JUnit.
 *
 * Usage
 * - Use annotations to provide declarative metadata and reduce boilerplate configuration.
 * - Ideal for marking behaviors, constraints, or configuration points consumed by frameworks or tools.
 * - Commonly combined with reflection to enable flexible and extensible designs.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface MyAnnotation {
    String value() default "";   // Special Element (can be used without explicitly naming it)
    String[] notes() default {}; // Array Element ({} for an empty array)
}

void main() throws Exception {
    /*
     * Annotate Element
     * - Demonstrates how to apply an annotation to a class declaration.
     * - Class-level annotations are commonly used to attach metadata that describes behavior, configuration, or
     *   semantic meaning of the class.
     * - Such annotations can be processed at compile time or accessed at runtime via reflection, depending on their
     *   retention policy.
     */
    @MyAnnotation
    class Dog { }

    /*
     * Annotate Element With Value Only
     * - Demonstrates applying an annotation using only the special "value" element.
     * - When an annotation defines a single element named "value", its name can be omitted for a more concise syntax.
     * - Equivalent to using @MyAnnotation(value = "Hello World").
     */
    @MyAnnotation("Hello World")
    class Cat { }

    /*
     * Annotate Element With Metadata
     * - Demonstrates applying an annotation with multiple elements explicitly defined.
     * - Uses named elements to provide structured metadata to the annotation.
     * - Suitable when an annotation defines more than one element or when clarity is preferred.
     */
    @MyAnnotation(value = "Hello World", notes = {"A", "B", "C"})
    class Fish { }

    /*
     * Annotate Other Elements
     * - Demonstrates applying annotations to different program elements within a class.
     * - Annotations can be applied to fields, constructors, methods, etc.
     * - The allowed elements depend on the @Target configuration of the annotation.
     */
    class Person {
        @MyAnnotation
        private String name;

        @MyAnnotation
        public Person() {}

        @MyAnnotation
        public void greet() {}
    }
}