/*
Matrices (Multi-Dimensional Arrays)
- This section explains matrices in Java, which are multidimensional arrays used to organize elements in rows and
  columns.

Overview
- A matrix is a two-dimensional array, but Java supports arrays with N dimensions.
- Each element of a multidimensional array is itself an array.
- Used to model grids, tables, or other structured data.

Key Characteristics
- Each dimension has a fixed length defined at creation; resizing is not allowed.
- Elements accessed and modified using multiple zero-based indices (e.g., matrix[i][j]).
- Can hold primitives or object references.
- The length of each dimension is obtained via the "length" property of the array or sub-array.
- Arrays can be rectangular (uniform row lengths) or jagged (rows with varying lengths).

Usage
- Use multidimensional arrays to represent grids, matrices, or structured tabular data.
- Iterate using nested loops or enhanced for-each statements.
- Choose rectangular arrays for uniform structures and jagged arrays for irregular datasets.
- Combine with standard array operations for efficient data manipulation.
*/
void main() {
    /*
    Declaration
    - Arrays in Java can have multiple dimensions, allowing the storage of data in rows, columns, or higher-dimensional
      structures.
    - The number of dimensions is determined by the number of bracket pairs (e.g., int[][] for 2D).
    */
    int[][] y1 = new int[2][2]; // 2x2 Matrix

    /*
    Initialization
    - Declares and initializes a multidimensional array in a single step with specific values.
    - The length of the array is inferred from the number of elements provided.
    */
    int[][] y2 = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; // 3x3 Matrix

    /*
    Element Assignment
    - Assigns or updates values for individual elements using multiple indices, one for each dimension.
    - Each element can be accessed and modified by specifying its position in all dimensions, starting from 0.
    */
    y2[0][0] = 2;
    y2[0][1] = 4;
    y2[1][0] = 6;
    y2[1][1] = 8;

    /*
    Indexing
    - Elements are accessed using multiple indices corresponding to each dimension.
    - Attempting to access an index outside the valid range in any dimension will throw an
      ArrayIndexOutOfBoundsException.
    */
    IO.println(y2[0][0]); // 2
    IO.println(y2[0][1]); // 4
    IO.println(y2[1][0]); // 6
    IO.println(y2[1][1]); // 8

    /*
    Length
    - In multidimensional arrays, each dimension has its own length.
    */
    int[][] y3 = new int[][] {{1, 2}, {4, 5}, {7, 8}};
    IO.println(y3.length);    // 3 (number of rows)
    IO.println(y3[0].length); // 2 (number of columns in the first row)

    /*
    Iterating (for)
    - We can iterate over matrices using a standard for loop, accessing each element by its index.
    - We need N fors for N dimensions.
    - Output: 0,0:A | 0,1:B | 0,2:C | 1,0:D | 1,1:E | 1,2:F
    */
    char[][] arr = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            IO.println(i + "," + j + ":" + arr[i][j]);
        }
    }

    /*
    Iterating (for each)
    - We can iterate over arrays using a for-each loop, which automatically accesses each element in sequence without
      requiring an index.
    - This approach is simpler and more readable when the index is not needed.
    - Output: A | B | C | D | E | F
    */
    arr = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    for (char[] row : arr) {
        for (char c : row) {
            IO.println(c);
        }
    }
}