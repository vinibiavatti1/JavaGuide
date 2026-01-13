/*
 * Matrices (Multi-Dimensional Arrays)
 * - This section explains matrices in Java, which are multidimensional arrays used to organize elements in rows and
 *   columns.
 *
 * Overview
 * - A matrix is a two-dimensional array, but Java supports arrays with N dimensions.
 * - Each element of a multidimensional array is itself an array.
 * - Used to model grids, tables, or other structured data.
 *
 * Key Characteristics
 * - Each dimension has a fixed length defined at creation; resizing is not allowed.
 * - Elements accessed and modified using multiple zero-based indices (e.g., matrix[i][j]).
 * - Can hold primitives or object references.
 * - The length of each dimension is obtained via the "length" property of the array or sub-array.
 * - Arrays can be rectangular (uniform row lengths) or jagged (rows with varying lengths).
 * - Use "Arrays.deeptoString()" to get a String representation of a matrix.
 *
 * Usage
 * - Use multidimensional arrays to represent grids, matrices, or structured tabular data.
 * - Iterate using nested loops or enhanced for-each statements.
 * - Choose rectangular arrays for uniform structures and jagged arrays for irregular datasets.
 * - Combine with standard array operations for efficient data manipulation.
 */
void main() {
    /*
     * Declaration
     * - Arrays in Java can have multiple dimensions, allowing the storage of data in rows, columns, or higher
     *   dimensional structures.
     * - The number of dimensions is determined by the number of bracket pairs (e.g., int[][] for 2D).
     */
    int[][] matrix = new int[2][2];

    /*
     * Representation
     * - In Java, multidimensional arrays cannot be printed directly like collections or single-dimensional arrays.
     * - Using "Arrays.toString" only prints the references of inner arrays, not their contents.
     * - To display the full contents of a multidimensional array, use "Arrays.deepToString(array)".
     * - Output: [[0, 0], [0, 0]]
     */
    matrix = new int[2][2];
    IO.println(Arrays.deepToString(matrix));

    /*
     * Initialization
     * - Declares and initializes a multidimensional array in a single step with specific values.
     * - The length of the array is inferred from the number of elements provided.
     * - Output: [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
     */
    matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    IO.println(Arrays.deepToString(matrix));

    /*
     * Element Assignment
     * - Assigns or updates values for individual elements using multiple indices, one for each dimension.
     * - Each element can be accessed and modified by specifying its position in all dimensions, starting from 0.
     * - Output: [[1, 2], [3, 4]]
     */
    matrix = new int[2][2];
    matrix[0][0] = 1;
    matrix[0][1] = 2;
    matrix[1][0] = 3;
    matrix[1][1] = 4;
    IO.println(Arrays.deepToString(matrix));

    /*
     * Indexing
     * - Elements are accessed using multiple indices corresponding to each dimension.
     * - Attempting to access an index outside the valid range in any dimension will throw
     *   ArrayIndexOutOfBoundsException.
     */
    matrix = new int[][] {{1, 2}, {3, 4}};
    IO.println(matrix[0][0]); // 1
    IO.println(matrix[0][1]); // 2
    IO.println(matrix[1][0]); // 3
    IO.println(matrix[1][1]); // 4

    /*
     * Length
     * - In Java, each dimension of a multidimensional array has its own length.
     * - The length of the outer array gives the number of rows.
     * - Each inner array can have a different length, representing the number of columns in that row.
     */
    matrix = new int[][] {{1, 2}, {3, 4, 5}};
    IO.println(matrix.length);    // 2 (number of rows)
    IO.println(matrix[0].length); // 2 (number of columns in the first row)
    IO.println(matrix[1].length); // 3 (number of columns in the second row)

    /*
     * Iterating (for)
     * - We can iterate over matrices using a standard for loop, accessing each element by its index.
     * - We need N fors for N dimensions.
     * - Output: 0,0:A | 0,1:B | 0,2:C | 1,0:D | 1,1:E | 1,2:F
     */
    char[][] charMatrix = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    for (int i = 0; i < charMatrix.length; i++) {
        for (int j = 0; j < charMatrix[i].length; j++) {
            IO.println(i + "," + j + ":" + charMatrix[i][j]);
        }
    }

    /*
     * Iterating (for each)
     * - We can iterate over arrays using a for-each loop, which automatically accesses each element in sequence without
     *   requiring an index.
     * - This approach is simpler and more readable when the index is not needed.
     * - Output: A | B | C | D | E | F
     */
    charMatrix = new char[][] {{'A', 'B', 'C'}, {'D', 'E', 'F'}};
    for (char[] row : charMatrix) {
        for (char ch : row) {
            IO.println(ch);
        }
    }
}