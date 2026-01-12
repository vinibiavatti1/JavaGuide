/*
Optionals
- This section explains the "Optional" class in Java, which is a container object used to represent the presence
  or absence of a value, helping to avoid null-related errors and explicit null checks.

Overview
- The "Optional" class is part of the java.util package.
- It provides a functional-style approach to handle potentially absent values.
- Introduced in Java 8 to encourage safer APIs and reduce NullPointerException.
- Typically used as a return type of methods to indicate that a value might be missing.

Key Characteristics
- Provides methods to safely retrieve values (orElse, orElseGet, orElseThrow) and check presence (isPresent, isEmpty).
- Supports functional-style operations like map, flatMap, filter, and ifPresent/ifPresentOrElse.
- Can be chained in streams and functional pipelines to avoid nested null checks.
- Encourages explicit handling of optional values, making code more readable and less error-prone.

Notes
- Optional is not recommended for fields, method parameters, or elements in collections, as it can hurt performance and
  reduce readability.
- Use Optional primarily as a return type to indicate potential absence of a value, avoiding unnecessary overhead.

Usage
- Use Optional as a return type when a method might not produce a value, signaling absence explicitly.
- Combine with streams and functional operations to safely transform and process values without null checks.
- Avoid using Optional for fields, arguments, or collection elements to prevent unnecessary overhead.
- Ideal for APIs, service methods, or utility functions where the presence of a value is conditional.
*/
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declaration from a Non-Null Value
    - The "of" method creates an Optional containing a non-null value.
    - Use it when you are sure the value is not null; otherwise, it throws NullPointerException.
    - Useful for avoiding null checks and enabling functional-style operations on values that may or may not be present.
    - Output: Optional[Hello World]
    */
    Optional<String> optional = Optional.of("Hello World");
    IO.println(optional);

    /*
    Declaration from a Nullable Value
    - The "ofNullable" method creates an Optional that may hold a null value.
    - If the value is non-null, it returns an Optional containing the value; otherwise, it returns an empty Optional.
    - Useful for safe handling of potentially null values with Optional's functional-style operations.
    - Output: Optional.empty
    */
    optional = Optional.ofNullable(null);
    IO.println(optional);

    /*
    Empty Declaration
    - The "empty" method creates an Optional with no value.
    - Useful for representing the absence of a value explicitly and safely.
    - Output: Optional.empty
    */
    optional = Optional.empty();
    IO.println(optional);

    //==================================================================================================================
    // Verification
    //==================================================================================================================

    /*
    Is Empty
    - The "isEmpty" method returns true if the Optional contains no value.
    - Useful for checking the absence of a value without risking NullPointerException.
    - Output: false
    */
    optional = Optional.of("Hello World");
    IO.println(optional.isEmpty());

    /*
    Is Present
    - The "isPresent" method returns true if the Optional contains a value.
    - Useful for checking the presence of a value before performing operations on it.
    - Output: true
    */
    optional = Optional.of("Hello World");
    IO.println(optional.isPresent());

    //==================================================================================================================
    // Value Accessor
    //==================================================================================================================

    /*
    Get Value or Use Default
    - The "orElse" method returns the value if present, or a default value if the Optional is empty.
    - Useful for providing fallback values without explicit null checks.
    - Output: default
    */
    optional = Optional.empty();
    IO.println(optional.orElse("default"));

    /*
    Get Value or Lazily Compute Default
    - The "orElseGet" method returns the value if present, or computes a default value using a Supplier if empty.
    - Useful for deferring the computation of fallback values until necessary.
    - Output: default
    */
    optional = Optional.empty();
    IO.println(optional.orElseGet(() -> "default"));

    /*
    Get Value or Throw NoSuchElementException
    - The "orElseThrow" method returns the value if present, or throws NoSuchElementException if empty.
    - Note: The "get" method can also retrieve the value but is considered legacy because it throws exceptions directly
      without clear intent.
    - Useful for enforcing that a value must be present while avoiding null checks.
    - Output: No value present
    */
    optional = Optional.empty();
    try {
        optional.orElseThrow();
    } catch (NoSuchElementException e) {
        IO.println("No value present");
    }

    /*
    Get Value or Lazily Compute Exception
    - The "orElseThrow(Supplier)" method returns the value if present, or throws a custom exception provided by a
      Supplier if empty.
    - Useful for enforcing that a value must be present with a specific exception type or message.
    - Output: No value present
    */
    optional = Optional.empty();
    try {
        optional.orElseThrow(() -> new RuntimeException("No value present"));
    } catch (RuntimeException e) {
        IO.println(e.getMessage());
    }

    /*
    Get Value or Lazily Compute Other Optional
    - The "or" method returns the current Optional if it contains a value, or a Supplier-provided alternative Optional
      if empty.
    - Useful for providing fallback Optionals in a lazy and safe manner, avoiding nested Optionals.
    - Output: Hello World
    */
    optional = Optional.empty();
    optional.or(() -> Optional.of("Hello World")).ifPresent(IO::println);

    //==================================================================================================================
    // Conditional Computing
    //==================================================================================================================

    /*
    Compute Action If Value is Present
    - The "ifPresent" method executes a given action if the Optional contains a value.
    - Useful for performing operations on the value without explicit null checks.
    - Output: Hello World
    */
    optional = Optional.of("Hello World");
    optional.ifPresent(IO::println);

    /*
    Compute Action if Value is Present or Compute Alternative Action
    - The "ifPresentOrElse" method executes one action if the Optional contains a value, or another action if it is
      empty.
    - Useful for handling both presence and absence of a value without explicit null checks.
    - Output: default
    */
    optional = Optional.empty();
    optional.ifPresentOrElse(IO::println, () -> IO.println("default"));

    //==================================================================================================================
    // Functional Methods
    //==================================================================================================================

    /*
    Filter if Value is Present
    - The "filter" method returns an Optional describing the value if it matches a given predicate, otherwise an empty
      Optional.
    - Useful for conditionally processing values only when they satisfy certain criteria.
    - Output: Hello World
    */
    optional = Optional.of("Hello World");
    optional.filter(x -> x.equals("Hello World")).ifPresent(IO::println);

    /*
    Map if Value is Present
    - The "map" method applies a function to the value if present and returns an Optional of the result.
    - Useful for transforming values without explicit null checks.
    - Output: HELLO WORLD
    */
    optional = Optional.of("Hello World");
    optional.map(String::toUpperCase).ifPresent(IO::println);

    /*
    Flat Map if Value is Present
    - The "flatMap" method applies a function to the value if present, where the function itself returns an Optional.
    - Unlike "map", which would produce an Optional<Optional<String>> for the example below, "flatMap" flattens the
      result into a single Optional<String>.
    - Useful for chaining operations that already return Optionals, avoiding nested Optionals.
    - Output: HELLO WORLD
    */
    optional = Optional.of("Hello World");
    Optional<String> result = optional.flatMap(s -> Optional.of(s.toUpperCase()));
    result.ifPresent(IO::println);

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
    Equals
    - The "equals" method checks if two Optionals are equal by comparing their contained values.
    - Returns true if both Optionals are present and their values are equal, or if both are empty.
    - Useful for safely comparing Optional values without explicit null checks.
    - Output: true
    */
    Optional<String> a = Optional.of("Hello World");
    Optional<String> b = Optional.of("Hello World");
    IO.println(a.equals(b));

    /*
    Hashcode
    - The "hashCode" method returns the hash code of the value contained in the Optional, or 0 if empty.
    - Useful for using Optionals as keys in hash-based collections or for general hashing purposes.
    - Output: 1794106052
    */
    optional = Optional.of("Hello World");
    IO.println(optional.hashCode());

    /*
    To String
    - The "toString" method returns a string representation of the Optional.
    - For a present value, it returns "Optional[value]"; for empty, it returns "Optional.empty".
    - Useful for logging or debugging Optional values safely.
    - Output: Optional[Hello World]
    */
    optional = Optional.of("Hello World");
    IO.println(optional.toString());

    //==================================================================================================================
    // Stream API
    //==================================================================================================================

    /*
    Call Stream API
    - The "stream" method converts an Optional into a Stream containing zero or one element.
    - Useful for integrating Optionals into Stream pipelines and functional-style processing without null checks.
    */
    Stream<String> stream = Optional.of("Hello World").stream();
}