/*
Matrices (Multi-Dimensional Arrays)
A matrix in Java is a two-dimensional array, which is an ordered collection of elements organized in rows and columns.
In general, Java supports arrays with N dimensions, where each element of a multidimensional array is itself an array.

Key characteristics:
- Each dimension has a fixed length defined at creation and cannot be resized.
- Elements are accessed and modified using multiple zero-based indices (e.g., matrix[i][j]).
- Arrays can hold primitive types or references to objects.
- The length of each dimension can be obtained using the 'length' property on the array or sub-array.
- Multi-dimensional arrays can be rectangular (all rows the same length) or jagged (rows of different lengths).
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaration
    Arrays in Java can have multiple dimensions, allowing the storage of data in rows, columns, or higher-dimensional
    structures.
    The number of dimensions is determined by the number of bracket pairs (e.g., int[][] for 2D).
    */
    int[][] y1 = new int[2][2]; // 2x2 Matrix

    /*
    Initialization
    Declares and initializes a multi-dimensional array in a single step with specific values.
    The length of the array is inferred from the number of elements provided.
    */
    int[][] y2 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 3x3 Matrix

    /*
    Element Assignment
    Assigns or updates values for individual elements using multiple indices, one for each dimension.
    Each element can be accessed and modified by specifying its position in all dimensions, starting from 0.
    */
    y2[0][0] = 2;
    y2[0][1] = 4;
    y2[1][0] = 6;
    y2[1][1] = 8;

    /*
    Indexing
    Elements are accessed using multiple indices corresponding to each dimension.
    Attempting to access an index outside the valid range in any dimension will throw an ArrayIndexOutOfBoundsException.
    */
    IO.println(y2[0][0]); // 2
    IO.println(y2[0][1]); // 4
    IO.println(y2[1][0]); // 6
    IO.println(y2[1][1]); // 8

    /*
    Length
    In multi-dimensional arrays, each dimension has its own length.
    */
    int[][] y3 = new int[][] {{1, 2}, {4, 5}, {7, 8}};
    IO.println(y3.length);    // 3 (number of rows)
    IO.println(y3[0].length); // 2 (number of columns in the first row)

    /*
    Iterating (for)
    We can iterate over matrices using a standard for loop, accessing each element by its index.
    We need N fors for N dimensions.
    Output: 0,0:A | 0,1:B | 0,2:C | 1,0:D | 1,1:E | 1,2:F
    */
    char[][] arr = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            IO.println(i + "," + j + ":" + arr[i][j]);
        }
    }

    /*
    Iterating (for each)
    We can iterate over arrays using a for-each loop, which automatically accesses each element in sequence without
    requiring an index.
    This approach is simpler and more readable when the index is not needed.
    Output: A | B | C | D | E | F
    */
    arr = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    for (char[] row : arr) {
        for (char c : row) {
            IO.println(c);
        }
    }
}