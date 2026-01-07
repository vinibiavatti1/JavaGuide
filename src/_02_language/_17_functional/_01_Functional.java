/*
Functional Programming in Java
- This section explains the Functional Programming paradigm and how Java supports it.

Overview
- Functional Programming (FP) is a paradigm that treats computation as the evaluation of functions.
- It emphasizes immutability, declarative style, and composition of behavior instead of step-by-step instructions.
- Java has supported Functional Programming features since Java 8, mainly through lambdas, functional interfaces,
  method references, and the Stream API.

Core Concepts
- Functions as first-class citizens: behavior can be passed as parameters and returned from methods.
- Immutability: data is not modified; instead, new values are produced.
- Declarative style: focus on what should be done, not how it is done.
- Function composition: small functions are combined to build more complex behavior.

Functional Interfaces
- A functional interface is an interface with exactly one abstract method.
- They are the foundation of lambdas and method references in Java.
- Common functional interfaces from java.util.function: Function<T, R>, Consumer<T>, Supplier<T>, Predicate<T>, etc.
- More functions explained in Stream API doc file.

Method References
- Method references are a concise way to refer to existing methods without invoking them.
- They improve readability when a lambda only calls a single method.
- Common forms:
  - ClassName::staticMethod
  - instance::instanceMethod
  - ClassName::instanceMethod
  - ClassName::new (constructor reference)
- Example: The lambda function "(s) -> s.toUpperCase()" can be replaced by the method reference "String::toUpperCase",
  since both perform the same operation by directly delegating to an existing method.

Stream API
- The Stream API enables functional-style operations on collections.
- Streams support operations such as filter, map, flatMap, sorted, and collect.
- Operations are lazy and executed only when a terminal operation is invoked.

Usage
- Use Functional Programming for data processing, transformations, and pipelines.
- Improves readability and reduces boilerplate when working with collections.
- Avoid side effects inside stream operations to keep code predictable and safe.
*/
void main() {
    /*
    Functional Stream Example
    - Demonstrates a functional pipeline using the Stream API.
    - Uses Predicate, Function, method references, constructor references and function chaining.
    - Output: [User[name=ANNA], User[name=ALICE], User[name=AMANDA]]
    */
    record User(String name) {}
    List<String> names = List.of("Amanda", "Anna", "John");  // Declare List
    List<User> result = names.stream()                       // Call Stream API
            .filter(name -> name.startsWith("A"))            // Filter names with "A":   ["Amanda", "Anna"]
            .map(String::toUpperCase)                        // Map to uppercase:        ["AMANDA", "ANNA"]
            .sorted(Comparator.comparingInt(String::length)) // Sort by length:          ["ANNA", "AMANDA"]
            .map(User::new)                                  // Map to User constructor: [User, User]
            .toList();                                       // (Terminal Operation) Execute stream and return new list.
    IO.println(result);                                      // Output: [User[name=ANNA], User[name=AMANDA]]
}
