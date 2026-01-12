/*
Array Reflection
- This section explains how to manipulate arrays in Java dynamically at runtime using the "java.lang.reflect.Array"
  class.

Overview
- The "Array" class is part of the java.lang.reflect package.
- It provides static methods to create, access, and modify arrays via reflection.
- Enables operations on arrays without knowing their type at compile time, including primitive and object arrays.

Key Characteristics
- Supports creating new arrays with Array.newInstance(componentType, length).
- Allows reading and writing array elements using Array.get and Array.set.
- Can determine the array length with Array.getLength.
- Works with any array type, including primitives, objects, and multidimensional arrays.
- getComponentType() on the array's Class object returns the element type; returns null for non-arrays.

Usage
- Use Array reflection when the array type is not known at compile time or must be manipulated generically.
- Useful for dynamic frameworks, serialization, generic utilities, and inspecting or modifying private array fields.
- Supports combining with Field reflection to access private arrays declared in classes.
- Provides a consistent way to handle arrays, including primitives, in reflective operations.
*/
void main() {
    /*
    Declare Array
    - The "Array.newInstance()" method creates a new array of the specified type and length at runtime using reflection.
    - The returned object must be cast to the appropriate array type.
    - Supports both primitive and object arrays.
    - Output: [0, 0, 0]
    */
    int[] intArray = (int[]) Array.newInstance(int.class, 3);
    IO.println(Arrays.toString(intArray));

    /*
    Component Type
    - The "getComponentType()" method of a Class object returns the type of elements stored in an array.
    - For non-array classes, this method returns null.
    - Useful for dynamically inspecting array element types at runtime.
    - Output: int
    */
    intArray = (int[]) Array.newInstance(int.class, 3);
    IO.println(intArray.getClass().getComponentType());

    /*
    Get Array Length
    - The "Array.getLength()" method returns the number of elements in the given array.
    - Works for any array type, including primitives and objects.
    - Useful when the array type is not known at compile time, and you need to determine its size dynamically.
    - Output: 3
    */
    intArray = (int[]) Array.newInstance(int.class, 3);
    IO.println(Array.getLength(intArray));

    /*
    Set Array Element
    - The "Array.set()" method assigns a value to the specified index of an array.
    - For primitive arrays, specialized methods like Array.setInt, Array.setDouble, etc., can be used to avoid boxing.
    - Works for any array type, including objects and primitives, when using the appropriate set method.
    - Output: [A, B, C]
    */
    String[] strArray = (String[]) Array.newInstance(String.class, 3);
    Array.set(strArray, 0, "A");
    Array.set(strArray, 1, "B");
    Array.set(strArray, 2, "C");
    IO.println(Arrays.toString(strArray));

    /*
    Get Array Element
    - The "Array.get()" method retrieves the value at the specified index of an array.
    - For primitive arrays, specialized methods like Array.getInt, Array.getDouble, etc., can be used to avoid unboxing.
    - Works for any array type, including objects and primitives, when using the appropriate get method.
    - Output: A
    */
    strArray = (String[]) Array.newInstance(String.class, 3);
    Array.set(strArray, 0, "A");
    IO.println(Array.get(strArray, 0));

    /*
    Check Array
    - The "isArray()" method on a Class object returns true if the class represents an array type.
    - Works for both primitive arrays (e.g., int[]) and object arrays (e.g., String[]).
    - Returns false for regular classes and interfaces.
    - Useful for generic code that must handle arrays differently from other objects.
    - Output: true
    */
    IO.println(int[].class.isArray());
}