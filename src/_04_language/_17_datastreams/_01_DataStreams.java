/*
 * Data Streams (Java I/O)
 * - This section explains Java's core stream abstractions independent of the data source, focusing on how byte and
 *   character streams work when connected to generic input/output devices such as the console, sockets, or pipes.
 *
 * Overview
 * - Java streams represent a sequential flow of data between a producer and a consumer.
 * - Data Streams are source-agnostic: they can be connected to files, network sockets, memory buffers, or standard I/O.
 * - Streams are divided into two fundamental categories:
 *   - Byte Streams (8-bit): InputStream / OutputStream
 *   - Text Streams (16-bit): Reader / Writer
 * - The I/O system follows the Decorator pattern, allowing buffering, encoding, and other behaviors to be layered
 *   transparently over raw streams.
 *
 * Key Characteristics
 * - Input streams consume data; output streams produce data.
 * - Byte streams operate on raw bytes and are encoding-agnostic.
 * - Text streams operate on characters and require an explicit or implicit character encoding.
 * - Buffered streams improve performance by reducing the number of low-level I/O operations.
 * - Closing an outer stream automatically closes the wrapped inner stream.
 *
 * Notes on Blocking Behavior
 * - Java's classic I/O streams (java.io) are synchronous and blocking by design.
 * - Read operations such as read(), read(byte[]), and readLine() block the calling thread until data becomes available,
 *   the end of the stream is reached, or an error occurs.
 * - This blocking behavior simplifies the programming model but requires careful handling in interactive or concurrent
 *   applications.
 * - Non-blocking and asynchronous I/O require alternative APIs such as java.nio (channels and selectors) or
 *   higher-level frameworks built on top of them.
 *
 * I/O Streams Graph
 * - InputStream
 *   - BufferedInputStream   // Standard Byte Input Stream
 *   - InputStreamReader     // Bridge: Bytes -> Text
 *     - BufferedReader      // Standard Text Input Stream
 * - OutputStream
 *   - BufferedOutputStream  // Standard Byte Output Stream
 *   - OutputStreamWriter    // Bridge: Bytes -> Text
 *     - BufferedWriter      // Standard Text Output Stream
 *
 * File Streams
 * - When working specifically with files, the traditional manual chaining of stream decorators (FileInputStream,
 *   FileOutputStream, BufferedInputStream, InputStreamReader, etc.) is now considered legacy in practice.
 * - Since Java 7 (NIO.2), the recommended approach is to use the java.nio.file.Files utility class, which provides
 *   factory methods that encapsulate stream creation and improve safety and readability.
 *
 * Notes
 * - This file demonstrates stream behavior using standard input/output (System.in / System.out).
 * - File-specific concerns (paths, open options, filesystem semantics) are intentionally excluded and covered
 *   separately in FileStreams.java.
 */
void main() throws IOException {
    //==================================================================================================================
    // Byte Streams
    //==================================================================================================================

    /*
     * Byte Input Stream
     * - System.in is a predefined InputStream connected to the standard input (console).
     * - InputStream reads raw bytes (8-bit) without any interpretation or encoding.
     * - BufferedInputStream wraps the original stream to add in-memory buffering, improving read performance.
     * - Common read operations include read(), read(byte[]), and readAllBytes().
     */
    InputStream inputStream = System.in;
    try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
        // Read Operations
    }

    /*
     * Byte Output Stream
     * - System.out is a predefined OutputStream connected to the standard output (console).
     * - OutputStream writes raw bytes directly to the output destination.
     * - BufferedOutputStream accumulates bytes in memory before writing them, reducing system calls.
     * - flush() forces buffered bytes to be written immediately.
     */
    OutputStream outputStream = System.out;
    try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
        // Write Operations
    }

    //==================================================================================================================
    // Text Streams
    //==================================================================================================================

    /*
     * Text Input Stream
     * - Text streams operate on characters (char) rather than raw bytes.
     * - InputStreamReader acts as an adapter that converts bytes from an InputStream into characters using a character
     *   encoding (UTF-8 by default, unless specified).
     * - BufferedReader adds character buffering and provides convenience methods such as readLine().
     */
    inputStream = System.in;
    try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
         BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
        // Read Operations
    }

    /*
     * Text Output Stream
     * - OutputStreamWriter converts characters into bytes using a character encoding.
     * - OutputStreamReader acts as an adapter that converts bytes to an OutputStream into characters using a character
     *   encoding (UTF-8 by default, unless specified).
     * - BufferedWriter accumulates characters in memory before encoding and writing them.
     * - flush() ensures all buffered characters are encoded and sent to the output destination.
     */
    outputStream = System.out;
    try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
         BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)) {
        // Write Operations
    }
}