/*
Arrays
An array represents a fixed-size, ordered collection of elements of the same type, used to store multiple values under a
single variable name.
In Java, arrays are objects, and variables of array type hold references to these objects, not the elements themselves.
Key characteristics:
- Arrays have a fixed length defined at creation and cannot be resized.
- Elements are accessed and modified using zero-based indices.
- Arrays can hold primitive types or references to objects.
- The length of an array can be obtained using the 'length' property.
- Multidimensional arrays are arrays of arrays, allowing nested structures.
*/
void main() {
    /*
    Declaration
    Declares an array variable and allocates memory to hold a fixed number of elements.
    The size of the array is specified inside the square brackets, which determines its length.
    Once declared, the array can store elements of the specified type, accessible by index.
    */
    int[] x1 = new int[3];

    /*
    Initialization
    Declares and initializes an array in a single step with specific values.
    The length of the array is inferred from the number of elements provided.
    */
    int[] x2 = new int[] {1, 2, 3};

    /*
    Element Assignment
    Assigns or updates values for individual elements in the array using their index.
    Each element can be accessed and modified by specifying its position, starting from 0.
    */
    x1[0] = 2;
    x1[1] = 4;
    x1[2] = 6;

    /*
    Indexing
    Array elements are accessed using their index, starting from 0.
    Attempting to access an index outside the valid range will throw an ArrayIndexOutOfBoundsException.
    */
    IO.println(x1[0]); // 2
    IO.println(x1[1]); // 4
    IO.println(x1[2]); // 6

    /*
    Length
    The length property of an array indicates the number of elements it can hold.
    It is accessed using "arrayName.length" and is useful for iteration and bounds checking.
    Output: 3
    */
    int[] x3 = new int[] {1, 2, 3};
    IO.println(x3.length);

    /*
    Iterating (for)
    We can iterate over arrays using a standard for loop, accessing each element by its index.
    This approach gives full control over the index, which can be useful for formatting or performing operations that
    depend on the position of elements.
    Output: 0:A | 1:B | 2:C
    */
    char[] arr = new char[] {'A', 'B', 'C'};
    for (int i = 0; i < arr.length; i++) {
        IO.println(i + ":" + arr[i]);
    }

    /*
    Iterating (for each)
    We can iterate over arrays using a for-each loop, which automatically accesses each element in sequence without
    requiring an index.
    This approach is simpler and more readable when the index is not needed.
    Output: A | B | C
    */
    arr = new char[] {'A', 'B', 'C'};
    for (char c : arr) {
        IO.println(c);
    }
}