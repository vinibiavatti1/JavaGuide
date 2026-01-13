/*
 * Type Casting
 * - This section explains type casting in Java, which is the process of converting a value from one data type to
 *   another using the cast operator: (targetType) value.
 *
 * Overview
 * - Type casting allows explicit conversion between compatible data types.
 * - Commonly used when assigning a value of a wider type to a narrower type or when working with polymorphism.
 * - Java supports both primitive type casting and reference type casting.
 *
 * Key Characteristics
 * - Primitive casting converts between numeric types (e.g., double to int, long to int).
 * - Can be implicit (widening) or explicit (narrowing).
 * - Explicit casting is required when there is a risk of data loss.
 * - Reference casting is used to convert between related object types (up casting and down casting).
 * - Invalid casts may cause runtime exceptions (ClassCastException for reference types).
 *
 * Usage
 * - Use explicit casting when converting from a wider primitive type to a narrower one.
 * - Apply reference casting when working with inheritance hierarchies and polymorphic behavior.
 * - Ensure type compatibility before casting to avoid runtime errors.
 * - Commonly used in arithmetic operations, API integrations, and legacy code interoperability.
 */
void main() {
    /*
     * Primitive Up Casting
     * - This example demonstrates an implicit widening conversion between primitive types.
     * - The integer literal "1" is automatically promoted from "int" to "double".
     * - No explicit cast is required because the target type can represent all possible "int" values.
     * - The resulting value preserves its numeric meaning, adding a decimal component.
     * - Output: 1.0
     */
    double decimal = 1; // int -> double (implicit up casting)
    IO.println(decimal);

    /*
     * Primitive Down Casting (Narrowing Conversion)
     * - This example demonstrates an explicit narrowing conversion between primitive types.
     * - The "double" value "3.14" is converted to "int", which requires an explicit cast.
     * - During the conversion, the fractional part is discarded (no rounding occurs).
     * - Down casting can lead to loss of precision and should be used with care.
     * - Output: 3
     */
    int integer = (int) 3.14; // double -> int (explicit down casting)
    IO.println(integer);

    /*
     * Object Up Casting (Reference Widening)
     * - This example demonstrates upcasting between reference types in Java.
     * - An "Integer" instance is assigned to a "Number" reference.
     * - Upcasting is implicit and always safe because "Integer" is a subclass of "Number".
     * - The explicit cast is unnecessary and shown here only for illustration purposes.
     * - No information is lost during the conversion.
     * - Output: 5
     */
    Number number = Integer.valueOf(5); // Integer -> Number (implicit upcasting)
    IO.println(number);

    /*
     * Object Down Casting (Reference Narrowing)
     * - This example demonstrates down casting between reference types in Java.
     * - An "Object" reference actually points to a "String" instance at runtime.
     * - An explicit cast is required to convert from a generic type to a more specific one.
     * - The cast is safe here because the runtime type of the object is "String".
     * - If the object were not a "String", a "ClassCastException" would be thrown.
     * - Output: Hello World
     */
    Object object = "Hello World";
    String str = (String) object; // Object -> String (explicit down casting)
    IO.println(str);
}