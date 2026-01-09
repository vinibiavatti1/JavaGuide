/*
Naming Conventions
- This file documents the standard naming conventions used in the project for classes, methods, variables, packages,
  constants, exceptions, and other identifiers.
*/
void main() {
    /*
    Project
    - Must use a clear and descriptive name
    - Use lowercase letters
    - Separate words with hyphens (e.g., my-project)
    - Avoid underscores, spaces, or special symbols
    - Start with a meaningful word related to the project purpose
    */
    /// my-project

    /*
    Packages
    - Must follow the company domain in reverse (e.g., com.example)
    - Use all lowercase letters
    - Separate words with dots (.)
    - Avoid special symbols and spaces
    - Keep names meaningful and concise
    */
    /// com.example.myproject
    /// com.example.myproject.model
    /// com.example.myproject.controller

    /*
    Classes
    - Must use a clear and descriptive name
    - Use CamelCase
    - Start with a capital letter
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Acronyms should follow CamelCase (e.g., HttpRequest, XmlParser)
    */
    class HttpClient {}

    /*
    Interfaces
    - Must use a clear and descriptive name
    - Use CamelCase (start with a capital letter)
    - Acronyms should follow CamelCase (e.g., HttpClient)
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Prefer nouns or adjectives that represent a capability or role (e.g., Printable, Serializable, PaymentProcessor)
    */
    interface Printable {}
    interface PaymentProcessor {}

    /*
    Enums
    - Must use a clear and descriptive name
    - Use CamelCase for enum type names (start with a capital letter)
    - Acronyms should follow CamelCase (e.g., HttpStatus)
    - Avoid special symbols and spaces
    - Keep names concise and meaningful
    */
    enum ActionType {}

    /*
    Enum Keys
    - Must use a clear and descriptive name
    - Use ALL_UPPERCASE letters
    - Separate words with underscores (_)
    - Acronyms should follow uppercase (e.g., MAX_HTTP_REQUEST)
    - Avoid special symbols and spaces
    - Keep names concise and meaningful
    */
    enum HttpStatus {
        BAD_REQUEST
    }

    /*
    Generics
    - Must use a single uppercase letter for type parameters (e.g., T, E, K, V)
    - Use meaningful names for complex cases (e.g., TItem, TResult)
    - Avoid numbers, underscores, and special symbols in type parameters
    - Keep names concise and descriptive
    - Follow standard conventions for collections (E = element, K = key, V = value, T = type)
    */
    class Collection<E> {}

    /*
    Annotations
    - Must use a clear and descriptive name
    - Use CamelCase (start with a capital letter)
    - Acronyms should follow CamelCase (e.g., HttpRequest)
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Follow standard Java conventions for annotation placement and usage
    NOTE: The @interface was not used in the example because local annotations cannot be declared
    */
    interface Annotation {}

    /*
    Variables
    - Must use a clear and descriptive name
    - Use camelCase (start with lowercase, capitalize subsequent words)
    - Acronyms should follow CamelCase (e.g., httpRequest)
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Use proper type naming conventions (int, String, etc.)
    */
    int listSize = 10;

    /*
    Final Variables (Constants)
    - Must use a clear and descriptive name
    - Use ALL_UPPERCASE letters
    - Separate words with underscores (_)
    - Acronyms should follow uppercase (e.g., MAX_HTTP_REQUEST)
    - Avoid special symbols and spaces
    - Keep names concise and meaningful
    */
    final int MAX_TIMEOUT = 100;

    /*
    Methods
    - Must use a clear and descriptive name
    - Use camelCase (start with lowercase, capitalize subsequent words)
    - Acronyms should follow CamelCase (e.g., parseHttpRequest)
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Prefer verbs for method names to indicate action (e.g., calculateTotal, sendRequest)
    */
    class DataAccess {
        public void validateData() {}
    }

    /*
    Getters & Setters
    - Method names must start with get or set followed by the property name
    - For boolean properties, getters should start with is (e.g., isActive)
    - Use camelCase for property names (e.g., getUserName, setUserName)
    - Acronyms should follow CamelCase (e.g., getHttpRequest, setHttpRequest)
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Getters should return the property type, setters should accept the property type as a parameter
    */
    class Person {
        public void getName() {}  // Getter
        public void isActive() {} // Getter for booleans
        public void setName() {}  // Setter
    }

    /*
    Test Classes
    - Must use a clear and descriptive name indicating the class under test (e.g., UserServiceTest)
    - Use CamelCase (start with a capital letter)
    - Acronyms should follow CamelCase (e.g., HttpClientTest)
    - End class names with "Test" to indicate test classes
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Organize test classes in corresponding packages to the class under test
    */
    class UserServiceTest {}

    /*
    Test Methods
    - Must use a clear and descriptive name indicating the behavior being tested
    - Use camelCase (start with lowercase, capitalize subsequent words)
    - Acronyms should follow CamelCase (e.g., testHttpRequest)
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Prefer a naming style that indicates expected outcome (shouldReturnTrueWhenValid, shouldThrowExceptionWhenInvalid)
    - Group related test scenarios logically within the class
    */
    class CalculatorTest {
        public void shouldAddTwoNumbersCorrectly() {}
        public void testDivisionByZeroThrowsException() {}
    }

    /*
    Checked Exceptions
    - Must use a clear and descriptive name
    - Use CamelCase (start with a capital letter)
    - Acronyms should follow CamelCase (e.g., HttpRequestException)
    - End class names with "Exception"
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Extend from java.lang.Exception
    - Use checked exceptions for recoverable conditions that the caller should handle
    */
    class NotSupportedException extends Exception {}

    /*
    Unchecked Exceptions
    - Must use a clear and descriptive name
    - Use CamelCase (start with a capital letter)
    - Acronyms should follow CamelCase (e.g., HttpParseException)
    - End class names with "Exception"
    - Avoid underscores, special symbols, and spaces
    - Keep names concise and meaningful
    - Extend from java.lang.RuntimeException
    - Use unchecked exceptions for programming errors or unexpected conditions that the caller cannot reasonably recover
    */
    class ParseException extends RuntimeException {}

    /*
    Exception Alias
    - Use a short and clear variable name for caught exceptions
    - Use "e" as the standard alias
    - Avoid using ambiguous or unrelated names (e.g., err, exceptionObj)
    - Keep it consistent across the project
    */
    try {
    } catch (Exception e) {
    }

    /*
    Reserved Words
    - Cannot use Java reserved keywords as identifiers (e.g., class, int, for, if)
    - Add a prefix or suffix for other identifiers (e.g., int -> intValue)
    - Use "clazz" for example, when the "class" keyword cannot be used.
    - Keep names meaningful and readable
    - Maintain consistency across the project
    */
    Class clazz;
}