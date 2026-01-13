/*
High-Level Text Streams (Java I/O)
- This section demonstrates high-level text-oriented utilities built on top of Java's character streams, focusing on
  ease of use rather than fine-grained control.

Overview
- High-level text streams provide convenient APIs for reading formatted input and writing formatted output.
- These utilities internally rely on Reader/Writer and byte streams, but abstract away buffering and encoding details.
- They are designed for simple input/output scenarios such as console interaction, debugging, and small utilities.
- General stream mechanics and low-level text streams are covered in DataStreams.java.

Key Characteristics
- Higher abstraction level compared to BufferedReader and BufferedWriter.
- Built-in support for parsing and formatting text.
- Less control over performance and buffering behavior.
- Suitable for interactive or low-throughput scenarios.

Notes on Blocking Behavior
- Read examples using Scanner are commented out to prevent blocking the executing thread.
- Scanner read operations (nextLine, nextInt, nextDouble) are blocking by design and wait for user input.
- This mirrors the behavior of lower-level text streams but is more visible in interactive examples.

Usage
- Use Scanner for simple, formatted text input from the console or other text sources.
- Use PrintWriter for formatted text output, logging, and human-readable output.
- Prefer lower-level streams (BufferedReader / BufferedWriter) for performance-critical or protocol-oriented code.
*/
void main() {
    /*
    Scanner
    - Scanner is a high-level text input utility for parsing tokens and primitive types.
    - It operates on character streams and uses delimiters (whitespace by default).
    - Suitable for simple console input and prototyping.
    - Not recommended for high-performance or large-scale input processing.
    */
    try (Scanner scanner = new Scanner(System.in)) {
        // String line = scanner.nextLine();
        // int x = scanner.nextInt();
        // double y = scanner.nextDouble();
    }

    /*
    PrintWriter
    - PrintWriter is a high-level text output utility for writing formatted text.
    - It provides print, println, and printf methods for convenience.
    - With autoFlush enabled, output is flushed automatically on println, printf, or format calls.
    - Designed for human-readable output rather than binary or protocol-level communication.
    - Output: Hello World | Count: 1, Price: 3,14
    */
    try (PrintWriter printWriter = new PrintWriter(System.out, true)) {
        printWriter.print("Hello ");
        printWriter.println("World");
        printWriter.printf("Count: %d, Price: %.2f %n", 1, 3.14);
    }
}