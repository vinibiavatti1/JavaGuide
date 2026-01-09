/*
Functional Programming
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

Features
- Functional Interfaces: interfaces with a single abstract method that serve as target types for lambda expressions
  and method references.
- Lambda Expressions: allow defining anonymous functions inline, enabling functional-style programming.
- Method References: a concise syntax to refer to existing methods or constructors without explicitly invoking them.
- Optional: a container object used to represent the presence or absence of a value, helping to avoid null-related
  errors and encouraging functional-style operations.
- Stream API: a high-level abstraction for processing sequences of elements in a functional and declarative way,
  supporting operations such as filtering, mapping, reducing, grouping, and parallel processing.

Usage
- Use Functional Programming for data processing, transformations, and pipelines.
- Improves readability and reduces boilerplate when working with collections.
- Avoid side effects inside stream operations to keep code predictable and safe.
*/
void main() {
    /*
    Functional Programming Example
    - Demonstrates a functional pipeline using the Stream API.
    - Uses Predicate, Function, method references, constructor references and function chaining.
    - Output: [User[name=ANNA], User[name=ALICE], User[name=AMANDA]]
    */
    record User(String name) {}
    List<User> result = Stream.of("Amanda", "Anna", "John")
            .filter(name -> name.startsWith("A"))            // Filter names with "A":   ["Amanda", "Anna"]
            .map(String::toUpperCase)                        // Map to uppercase:        ["AMANDA", "ANNA"]
            .sorted(Comparator.comparingInt(String::length)) // Sort by length:          ["ANNA", "AMANDA"]
            .map(User::new)                                  // Map to User constructor: [User, User]
            .toList();                                       // (Terminal Operation) Execute stream and return new list.
    IO.println(result);                                      // Output: [User[name=ANNA], User[name=AMANDA]]
}
