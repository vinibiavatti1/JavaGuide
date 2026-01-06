/*
Objects
- This section explains the "Objects" utility class in Java, which provides static methods to operate on objects,
  handle null references safely, and simplify common object-related tasks.

Overview
- The "Objects" class is part of the java.util package.
- It contains static utility methods for null checks, equality comparison, hash code generation, string conversion, and
  more.
- Introduced in Java 7 to simplify common programming patterns and reduce boilerplate code.

Key Characteristics
- All methods are static; there is no need to instantiate the Objects class.
- Provides methods for null-safe operations, such as Objects.equals(), Objects.hashCode(), and Objects.toString().
- Includes validation methods like requireNonNull() and index range checks (checkIndex, checkFromToIndex,
  checkFromIndexSize).
- Supports deep equality checks with Objects.deepEquals() and combined hash codes with Objects.hash().

Usage
- Use Objects to simplify and standardize operations on objects.
- Ensure null-safety and reduce boilerplate code in comparisons and validations.
- Apply when writing robust, defensive, and maintainable code.
- Useful in combination with collections, streams, and object-oriented designs.

Example
- The example below demonstrates modern validation techniques using Objects utility in a method.
- Validates null references, checks index ranges, and provides default values.
- Throws exceptions immediately if validations fail (fail-fast approach).
*/
public static String processItem(List<String> items, Integer index) {
    Objects.requireNonNull(items, "The items list cannot be null"); // Validate that the list itself is not null
    int safeIndex = Objects.requireNonNullElse(index, 0);           // Provide a default index if null
    int validIndex = Objects.checkIndex(safeIndex, items.size());   // Check that the index is within bounds
    String item = items.get(validIndex);                            // Retrieve the element safely
    return Objects.toString(item, "default item");                  // Return a string safely, even if item is null
}

/*
Objects Class
- The example belows shows the most used operations from the Objects class.
*/
void main() {
    //==================================================================================================================
    // Null Checks
    //==================================================================================================================

    /*
    Check Null Reference
    - The "Objects.isNull" method checks whether a reference points to null.
    - Returns true if the reference is null; otherwise, returns false.
    - Useful for readability and method references (e.g., stream filters).
    - Output: false
    */
    String arg = "Hello World";
    IO.println(Objects.isNull(arg));

    /*
    Check Not Null Reference
    - The "Objects.nonNull" method checks whether a reference is not null.
    - Returns true if the reference is not null; otherwise, returns false.
    - Commonly used in predicates, especially with streams and filters.
    - Output: true
    */
    arg = "Hello World";
    IO.println(Objects.nonNull(arg));

    //==================================================================================================================
    // Null Validations
    //==================================================================================================================

    /*
    Validate Non-Null or Throw Exception
    - The "Objects.requireNonNull" method validates that a reference is not null.
    - If the reference is null, a NullPointerException is thrown immediately.
    - Useful for enforcing contracts and fail-fast validation.
    - Output: Hello World
    */
    arg = "Hello World";
    IO.println(Objects.requireNonNull(arg));

    /*
    Validate Non-Null or Use Default
    - The "Objects.requireNonNullElse" method returns the given value if it is not null.
    - If the value is null, the provided default value is returned instead.
    - Prevents NullPointerException while ensuring a non-null result.
    - Output: default
    */
    arg = null;
    IO.println(Objects.requireNonNullElse(arg, "default"));

    /*
    Validate Non-Null or Lazily Compute Default
    - The "Objects.requireNonNullElseGet" method returns the given value if it is not null.
    - If the value is null, the default value is produced lazily via a Supplier.
    - Ideal when the default value creation is expensive or conditional.
    - Output: default
    */
    arg = null;
    IO.println(Objects.requireNonNullElseGet(arg, () -> "default"));

    //==================================================================================================================
    // Index Validations
    //==================================================================================================================

    /*
    Check Index Within Range
    - The "Objects.checkIndex" method validates that an index is within bounds.
    - Ensures the index is greater than or equal to zero and less than the specified length.
    - Throws IndexOutOfBoundsException if the index is invalid.
    - Returns the validated index when successful.
    - Output: 3
    */
    int index = 3;
    int length = 5;
    IO.println(Objects.checkIndex(index, length));

    /*
    Check Index Slice Within Range
    - The "Objects.checkFromToIndex" method validates a range defined by fromIndex (inclusive) and toIndex (exclusive).
    - Ensures 0 <= fromIndex <= toIndex <= length.
    - Throws IndexOutOfBoundsException if the range is invalid.
    - Returns the validated fromIndex when successful.
    - Output: 0
    */
    int fromIndex = 0;
    int to = 5;
    length = 5;
    IO.println(Objects.checkFromToIndex(fromIndex, to, length));

    /*
    Check Index and Size Within Range
    - The "Objects.checkFromIndexSize" method validates a slice defined by a start index and a size.
    - Ensures 0 <= fromIndex <= fromIndex + size <= length.
    - Throws IndexOutOfBoundsException if the computed range is invalid.
    - Returns the validated fromIndex when successful.
    - Output: 2
    */
    fromIndex = 2;
    int size = 2;
    length = 5;
    IO.println(Objects.checkFromIndexSize(fromIndex, size, length));

    //==================================================================================================================
    // String Representation
    //==================================================================================================================

    /*
    Convert Object to String
    - The "Objects.toString" method returns the string representation of an object.
    - If the object is null, the string "null" is returned instead of throwing an exception.
    - Useful for safe logging and debugging.
    - Output: Hello World
    */
    arg = "Hello World";
    IO.println(Objects.toString(arg));

    /*
    Convert Object to Identity String
    - The "Objects.toIdentityString" method returns a string that uniquely identifies the object.
    - Format: ClassName@HexHashCode, where HexHashCode is the object's identity hash code in hexadecimal.
    - Useful for debugging when you need to distinguish between object instances, even if their content is equal.
    - Output: java.lang.String@2a84aee7
    */
    arg = "Hello World";
    IO.println(Objects.toIdentityString(arg));

    //==================================================================================================================
    // Comparison
    //==================================================================================================================

    /*
    Compare Two Objects
    - The "Objects.compare" method compares two objects using the provided Comparator.
    - Returns a negative integer, zero, or a positive integer if the first argument is less than, equal to, or greater
      than the second.
    - Useful for custom sorting or ordering without modifying the objects themselves.
    - Output: 0 (equal)
    */
    String a = "A", b = "A";
    IO.println(Objects.compare(a, b, Comparator.naturalOrder()));

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
    Check Object Equality
    - The "Objects.equals" method checks whether two objects are equal, handling nulls safely.
    - Returns true if both objects are null or if a.equals(b) returns true; otherwise, returns false.
    - Useful to avoid NullPointerException when comparing objects.
    - Output: true
    */
    a = "A";
    b = "A";
    IO.println(Objects.equals(a, b));

    /*
    Deep Equality Check
    - The "Objects.deepEquals" method performs a deep comparison between two objects.
    - Compares nested arrays and collections recursively, returning true if all corresponding elements are equal.
    - Returns true if both objects are null.
    - Output: true
    */
    List<List<String>> x = List.of(List.of("A", "B"), List.of("C", "D"));
    List<List<String>> y = List.of(List.of("A", "B"), List.of("C", "D"));
    IO.println(Objects.deepEquals(x, y));

    //==================================================================================================================
    // Hashcode
    //==================================================================================================================

    /*
    Get Object Hash Code
    - The "Objects.hashCode" method returns the hash code of an object.
    - If the object is null, returns 0 instead of throwing a NullPointerException.
    - Useful for consistent hashing in collections or maps when nulls may appear.
    - Output: 1794106052
    */
    arg = "Hello World";
    IO.println(Objects.hashCode(arg));

    /*
    Compute Hash Code for Multiple Objects
    - The "Objects.hash" method generates a single hash code from multiple objects.
    - Handles null values safely and combines individual hash codes into one.
    - Useful for implementing hashCode methods for classes with multiple fields.
    - Output: 63821895
    */
    a = "A";
    b = "B";
    IO.println(Objects.hash(a, b));
}
