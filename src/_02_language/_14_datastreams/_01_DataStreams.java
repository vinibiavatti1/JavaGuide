/*
Data Streams (Java I/O & NIO.2)
- This section explains the hierarchy of Java's Input/Output system, focusing on the modern standard for handling byte
  and character streams using the java.nio.file.Files utility.

Overview
- Java I/O is divided into two main categories: Byte Streams (8-bit) and Character Streams (16-bit).
- Legacy classes such as FileInputStream and FileReader are now commonly accessed through factory methods provided by
  the java.nio.file.Files class, offering safer and more expressive APIs.
- The I/O system follows the Decorator pattern, where functionality such as buffering or encoding is added by wrapping
  streams.

Key Characteristics
- Byte Streams: Subclasses of InputStream/OutputStream. Used for binary data (images, PDFs).
- Character Streams: Subclasses of Reader/Writer. Used for text data (UTF-8, logs, JSON).
- Buffering: Essential for performance; reduces the number of I/O operations by using memory.
- Paths: Modern I/O uses Path (via Path.of() or Paths.get()) instead of File, providing better cross-platform support.

Usage
- For Binary Files: Use Files.newInputStream(path) or Files.newOutputStream(path).
- For Text Files: Use Files.newBufferedReader(path) or Files.newBufferedWriter(path).
- For Quick Reads: Use Files.readAllLines(path) for small files or Files.lines(path) for large files and streaming.

Legacy
- Prior to Java 7 (before NIO.2), developers were required to manually chain multiple stream constructors to enable
  buffering and ensure correct character encoding:
  - Example: new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
- Today, the recommended approach is to rely on the Files utility class, which encapsulates buffering and encoding
  concerns in a simpler, safer, and more modern way.

Notes
- Always use try-with-resources to ensure streams are closed automatically, avoiding resource leaks.
- Avoid using FileReader/FileWriter directly, as they rely on the system default encoding; prefer
  Files.newBufferedReader/Writer to explicitly define UTF-8.

Example
- The example demonstrates the modern way to instantiate buffered readers and writers without manual nesting,
  as the Files class handles the hierarchy internally.
*/
void main() throws IOException {
    /*
    Reading Bytes
    - The "Files.newInputStream" method creates an InputStream for reading binary data from a file.
    - If the file does not exist, an IOException is thrown.
    - Path.of is used to create a platform-independent path to the resource.
    - The entire file is read into memory using readAllBytes().
    - Output: [B@8efb846 (byte array)
    */
    try (InputStream in = Files.newInputStream(Path.of("resources/file.dat"))) {
        byte[] content = in.readAllBytes();
        IO.println(content);
    }

    /*
    Writing Bytes
    - The "Files.newOutputStream" method creates an OutputStream for writing binary data to a file.
    - If the file already exists, its content is truncated before writing.
    - If the file does not exist, it is created automatically.
    - The byte array represents the ASCII/UTF-8 encoding of the string "Hello World".
    */
    try (OutputStream out = Files.newOutputStream(Path.of("resources/file.dat"))) {
        byte[] data = "Hello World".getBytes();
        out.write(data);
    }

    /*
    Reading Text
    - The "Files.newBufferedReader" method creates a BufferedReader for reading text files.
    - If the file does not exist, an IOException is thrown.
    - Path.of is used to create a platform-independent path to the resource.
    - The entire text is read into a String in memory using readAllAsString().
    - Output: Hello World
    */
    try (BufferedReader in = Files.newBufferedReader(Path.of("resources/file.txt"))) {
        String content = in.readAllAsString();
        IO.println(content);
    }

    /*
    Writing Text
    - The "Files.newBufferedWriter" method creates a BufferedWriter for writing text files.
    - If the file already exists, its content is truncated before writing; if it does not exist, it is created.
    - Path.of is used to create a platform-independent path to the resource.
    - The text is written to the file using the write() method.
    - Output in "resources/file.txt": Hello World
    */
    try (BufferedWriter out = Files.newBufferedWriter(Path.of("resources/file.txt"))) {
        String content = "Hello World";
        out.write(content);
    }
}