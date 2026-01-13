/*
 * File Streams (Java NIO.2)
 * - This section explains file-based input and output in Java, focusing exclusively on reading and writing data from
 *   the filesystem using the modern java.nio.file.Files API.
 *
 * Overview
 * - File Streams represent streams whose source or destination is a file on the filesystem.
 * - Since Java 7 (NIO.2), file I/O is centered around Path and the Files utility class.
 * - General stream concepts (byte vs character streams, buffering, decorators) are covered separately in
 *   DataStreams.java.
 * - The Files API provides factory methods that encapsulate stream creation and improve clarity and safety when
 *   working with files.
 *
 * Key Characteristics
 * - Byte File Streams: Used for binary files such as images, executables, and serialized data.
 * - Text File Streams: Used for character-based files such as logs, configuration files, and JSON.
 * - Path-based access: Files operate on Path instead of File, offering better portability and expressiveness.
 * - Explicit open options: File behavior is controlled via StandardOpenOption flags.
 *
 * Usage
 * - For Binary Files:
 *   - Use Files.newInputStream(path) or Files.newOutputStream(path).
 * - For Text Files:
 *   - Use Files.newBufferedReader(path) or Files.newBufferedWriter(path).
 * - For Simple Reads:
 *   - Use Files.readAllLines(path) for small files or Files.lines(path) for streaming large files.
 *
 * Open Options
 * - StandardOpenOption flags define how a file is opened or created.
 * - Common flags include:
 *   - CREATE             // Creates a new file if it does not exist.
 *   - CREATE_NEW         // Creates a new file and fails if it already exists.
 *   - APPEND             // Writes data at the end of the file.
 *   - TRUNCATE_EXISTING  // Truncates the file if it already exists.
 *   - DELETE_ON_CLOSE    // Deletes the file when the stream is closed.
 *   - READ               // Opens the file for reading.
 *   - WRITE              // Opens the file for writing.
 *
 * Legacy
 * - Prior to Java 7, file I/O required explicit chaining of multiple stream decorators:
 *   - Example: new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
 * - This approach is now considered legacy for filesystem access.
 * - The recommended practice is to rely on the Files utility class, which encapsulates stream creation, buffering, and
 *   encoding concerns in a clearer and more modern API.
 *
 * Notes
 * - Always use try-with-resources to ensure file streams are closed properly.
 * - Avoid FileInputStream, FileOutputStream, FileReader, and FileWriter for new code.
 * - Prefer Files-based APIs to explicitly control encoding and file open behavior.
 *
 * Example
 * - The example demonstrates file I/O using Files factory methods, highlighting modern, safe, and readable
 *   access patterns for both binary and text files.
 */
void main() throws IOException {
    /*
     * Reading External Bytes File
     * - The "Files.newInputStream" method creates an InputStream for reading binary data from a file.
     * - If the file does not exist, an IOException is thrown.
     * - Path.of is used to create a platform-independent path to the resource.
     * - The entire file is read into memory using readAllBytes().
     * - Output: 72 | 101 | 108 | 108 | 111 | 32 | 87 | 111 | 114 | 108 | 100
     */
    try (InputStream in = Files.newInputStream(Path.of("resources/file.dat"))) {
        byte[] content = in.readAllBytes();
        for (byte b : content) IO.println(b);
    }

    /*
     * Writing External Bytes File
     * - The "Files.newOutputStream" method creates an OutputStream for writing binary data to a file.
     * - If the file already exists, its content is truncated before writing.
     * - If the file does not exist, it is created automatically.
     * - To control open behavior, the flags in StandardOpenOption can be used.
     * - The byte array represents the ASCII/UTF-8 encoding of the string "Hello World".
     */
    try (OutputStream out = Files.newOutputStream(Path.of("resources/file.dat"))) {
        byte[] data = "Hello World".getBytes();
        out.write(data);
    }

    /*
     * Reading External Text File
     * - The "Files.newBufferedReader" method creates a BufferedReader for reading text files.
     * - If the file does not exist, an IOException is thrown.
     * - Path.of is used to create a platform-independent path to the resource.
     * - The entire text is read into a String in memory using readAllAsString().
     * - Output: Hello World
     */
    try (BufferedReader in = Files.newBufferedReader(Path.of("resources/file.txt"))) {
        String content = in.readAllAsString();
        IO.println(content);
    }

    /*
     * Writing External Text File
     * - The "Files.newBufferedWriter" method creates a BufferedWriter for writing text files.
     * - If the file already exists, its content is truncated before writing; if it does not exist, it is created.
     * - To control open behavior, the flags in StandardOpenOption can be used.
     * - Path.of is used to create a platform-independent path to the resource.
     * - The text is written to the file using the write() method.
     * - Output in "resources/file.txt": Hello World
     */
    try (BufferedWriter out = Files.newBufferedWriter(Path.of("resources/file.txt"))) {
        String content = "Hello World";
        out.write(content);
    }
}