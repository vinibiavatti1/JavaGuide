/*
 * Generics
 * - This section explains Java generics, a language feature that allows classes, methods, and fields to operate on
 *   objects of various types while providing compile-time type safety.
 *
 * Overview
 * - Generics provide a way to define type parameters (e.g., <T>, <E>, <K, V>) that are specified when the class or
 *   method is instantiated or called.
 * - They improve code reusability, readability, and safety by removing the need for casting.
 * - Generics can be applied to:
 *   - Classes: public class Box<T> { ... }
 *   - Methods: public <T> T identity(T value) { ... }
 *   - Fields: private List<T> elements;
 *   - Constructors: public <T> Container(T value) { ... }
 * - Wildcards and bounds allow for flexible and constrained type usage:
 *   - Upper Bound: <? extends Number>
 *   - Lower Bound: <? super Integer>
 *
 * Key Characteristics
 * - Type parameters are placeholders for concrete types provided when creating instances or invoking methods.
 * - Generic types can be bounded to restrict allowed types (upper or lower bounds).
 * - Multiple type parameters are allowed: <T1, T2, ...>
 * - Generic methods can be independent of the class's type parameters.
 * - Generics enable compile-time type checking, reducing runtime errors due to type mismatches.
 * - Generic types are erased at runtime (type erasure), so some operations are restricted.
 *
 * Type Erasure
 * - In Java, generics are implemented using a mechanism called type erasure.
 * - At compile time, the compiler enforces type safety and replaces generic type parameters with their upper bound
 *   (usually Object if no bound is specified).
 * - This means that generic type information is not retained at runtime; the JVM sees only raw types.
 * - Type erasure ensures backward compatibility with legacy code written before generics.
 * - Limitations imposed by type erasure:
 *   - Cannot use "instanceof" with parameterized types: "if (obj instanceof List<String>)" is illegal.
 *   - Cannot create arrays of parameterized types: "new T[10]" is illegal.
 *   - Cannot declare static fields or methods with the generic type parameter.
 *   - Generic type casts are inserted automatically by the compiler to preserve type safety.
 *
 * Notes
 * - "List<Number>" is not the same as "List<Integer>"; generics do not support subtype polymorphism.
 * - To accept multiple related types, use wildcards:
 *   - Upper bound: "List<? extends Number>" allows any subclass of Number (Integer, Double, etc.)
 *   - Lower bound: "List<? super Integer>" allows Integer or any of its supertypes (Number, Object).
 * - Use wildcards to achieve flexibility while preserving type safety.
 */
void main() {}