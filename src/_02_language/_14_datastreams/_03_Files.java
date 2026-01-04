/*
Files Utility Class
- This section explains the "Files" class in Java, which provides a rich set of static methods for file and directory
  operations, allowing efficient and safe manipulation of resources in the filesystem.

Overview
- The "Files" class is part of the java.nio.file package.
- It provides methods for creating, reading, writing, copying, moving, and deleting files and directories.
- Supports both byte and text operations, as well as checking file attributes and permissions.
- Introduced in Java 7 as part of the NIO.2 (New I/O) API to modernize file handling.

Key Characteristics
- All methods are static; there is no need to instantiate the class.
- Supports operations on Path objects, providing platform-independent access to filesystem resources.
- Can handle both small and large files efficiently.
- Methods often throw IOException to indicate problems during file operations.

Notes
- Modern methods like readString, writeString, readAllBytes, and write handle common tasks more concisely.
- For large files or streaming data, use Files.newInputStream(path)/Files.newOutputStream(path) for binary, or
  Files.newBufferedReader(path)/Files.newBufferedWriter(path) for text.
- Supports symbolic and hard links, directory traversal, file attribute checks, and temporary files/directories.

Usage
- Use Files for performing common file I/O tasks safely and concisely.
- Examples of typical operations: creating files/directories, copying or moving resources, reading/writing bytes or text,
  checking existence and permissions.
- Provides a consistent and modern alternative to legacy java.io.File methods.

Open Options
- StandardOpenOption flags can be used to control file creation and writing behavior.
- Common flags include:
  - CREATE           : Creates a new file if it does not exist.
  - CREATE_NEW       : Creates a new file and fails if it already exists.
  - APPEND           : Opens the file for writing at the end, preserving existing content.
  - TRUNCATE_EXISTING: Opens the file and truncates it to zero length if it already exists.
  - DELETE_ON_CLOSE  : Deletes the file automatically when the stream is closed.
  - READ             : Opens the file for reading.
  - WRITE            : Opens the file for writing.
*/
void main() throws IOException {
    //==================================================================================================================
    // Create Resources
    //==================================================================================================================

    /*
    Create a File
    - The "Files.createFile" method creates a new empty file at the specified path.
    - If the file already exists, a FileAlreadyExistsException is thrown.
    - Output: resources\exampleFile.txt
    */
    Path path = Files.createFile(Path.of("resources/exampleFile.txt"));
    IO.println(path);

    /*
    Create a Directory
    - The "Files.createDirectory" method creates a new directory at the specified path.
    - Use "Files.createDirectories" to create the directory along with all nonexistent parent directories.
    - If the directory already exists, a FileAlreadyExistsException is thrown.
    - Output: resources\exampleDirectory
    */
    path = Files.createDirectory(Path.of("resources/exampleDirectory"));
    IO.println(path);

    /*
    Create a Temp File
    - The "Files.createTempFile" method creates a new temporary file in the default temporary-file directory.
    - The first argument is the prefix of the file name, and the second argument is the suffix (usually an extension).
    - The file is automatically unique, avoiding name collisions.
    - Output example: C:\Temp\example_399997135624035379.txt
    */
    path = Files.createTempFile("example_", ".txt");
    IO.println(path);

    /*
    Create a Temp Directory
    - The "Files.createTempDirectory" method creates a new temporary directory in the default temporary-file directory.
    - The argument is used as a prefix for the directory name, which is made unique automatically to avoid collisions.
    - Output example: C:\Temp\example_8548674190012946799
    */
    path = Files.createTempDirectory("example_");
    IO.println(path);

    //==================================================================================================================
    // Copy Resources
    //==================================================================================================================

    /*
    Copy Files
    - The "Files.copy" method copies a file from a source path to a target path.
    - If the target file already exists, a FileAlreadyExistsException is thrown unless you specify the REPLACE_EXISTING
      option.
    - The copied file is a separate resource; modifications to the source do not affect the target.
    - Output: resources/file_copy.dat
    */
    path = Files.copy(Path.of("resources/file.dat"), Path.of("resources/file_copy.dat"));
    IO.println(path);

    //==================================================================================================================
    // Delete Resources
    //==================================================================================================================

    /*
    Delete a Resource
    - The "Files.delete" method deletes the file or directory at the specified path.
    - If the file or directory does not exist, a NoSuchFileException is thrown.
    - For non-empty directories, use delete recursively or Files.walkFileTree.
    */
    Files.delete(Path.of("resources/exampleFile.txt"));
    Files.delete(Path.of("resources/file_copy.dat"));

    /*
    Delete a Resource (if exists)
    - The "Files.deleteIfExists" method deletes the file or directory at the specified path if it exists.
    - Returns true if the resource was deleted, false if it did not exist.
    - Unlike Files.delete, this method does not throw an exception when the file is missing.
    - Output example: true
    */
    boolean exists = Files.deleteIfExists(Path.of("resources/exampleDirectory"));
    IO.println(exists);

    //==================================================================================================================
    // Check Resources
    //==================================================================================================================

    /*
    Check Resource Properties
    - The "Files" class provides methods to check various properties of files and directories.
    - Output shows boolean values indicating the presence of each property.
    */
    IO.println(Files.isDirectory(Path.of("resources")));            // Checks if path is directory: true
    IO.println(Files.isRegularFile(Path.of("resources/file.dat"))); // Checks if path is a file: true
    IO.println(Files.isHidden(Path.of("resources/file.dat")));      // Checks if path is hidden: false
    IO.println(Files.isReadable(Path.of("resources/file.dat")));    // Check if path has read permission: true
    IO.println(Files.isWritable(Path.of("resources/file.dat")));    // Check if path has write permission: true
    IO.println(Files.isExecutable(Path.of("resources/file.dat")));  // Check if path has execute permission: true

    /*
    Check Resource Existence
    - The "Files" class provides methods to check whether a file or directory exists.
    - "Files.exists(path)" returns true if the resource exists.
    - "Files.notExists(path)" returns true if the resource is known not to exist.
    - Note: If the existence cannot be determined (e.g., due to permission issues), both may return false.
    */
    IO.println(Files.exists(Path.of("resources/file.dat")));    // true
    IO.println(Files.notExists(Path.of("resources/file.dat"))); // false

    /*
    Check if file is same
    - The "Files.isSameFile" method checks whether two paths refer to the same file in the filesystem.
    - It resolves symbolic links and normalizes the paths before comparison.
    - Returns true if both paths point to the exact same file or directory.
    - Output example: true
    */
    IO.println(Files.isSameFile(Path.of("resources/file.dat"), Path.of("resources/../resources/file.dat")));

    //==================================================================================================================
    // Read Resources
    //==================================================================================================================

    /*
    Read Bytes
    - The "Files.readAllBytes" method reads all bytes from a file into a byte array.
    - Printing the array directly shows the object reference (type and hashcode), not the actual content.
    - To inspect the contents, you need to iterate over the array or convert it to a readable format.
    - Output: 72 | 101 | 108 | 108 | 111 | 32 | 87 | 111 | 114 | 108 | 100
    */
    byte[] bytes = Files.readAllBytes(Path.of("resources/file.dat"));
    for (byte b : bytes) IO.println(b);

    /*
    Read String
    - The "Files.readString" method reads all text from a file into a String using UTF-8 by default.
    - If the file does not exist, an IOException is thrown.
    - Output example: Hello World
    */
    String content = Files.readString(Path.of("resources/file.txt"));
    IO.println(content);

    /*
    Read Lines
    - The "Files.readAllLines" method reads all lines from a text file into a List of Strings using UTF-8 by default.
    - Each element of the list represents one line of the file.
    - If the file does not exist, an IOException is thrown.
    - Output example: [Hello World]
    */
    List<String> lines = Files.readAllLines(Path.of("resources/file.txt"));
    IO.println(lines);

    //==================================================================================================================
    // Write Resources
    //==================================================================================================================

    /*
    Writing Bytes
    - The "Files.write" method writes the given byte array to the specified file.
    - If the file already exists, its content is replaced; if it does not exist, it is created automatically.
    - To control open behavior, the flags in StandardOpenOption can be used.
    */
    bytes = "Hello World".getBytes();
    Files.write(Path.of("resources/file.txt"), bytes);

    /*
    Writing String
    - The "Files.writeString" method writes the given String to the specified file using UTF-8 by default.
    - If the file already exists, its content is replaced; if it does not exist, it is created automatically.
    - To control open behavior, the flags in StandardOpenOption can be used.
    - Output example: "Hello World" is written to resources/file.txt
    */
    content = "Hello World";
    Files.writeString(Path.of("resources/file.txt"), content);

    //==================================================================================================================
    // Byte Data Stream
    //==================================================================================================================

    /*
    Reading Bytes
    - The "Files.newInputStream" method creates an InputStream for reading binary data from a file.
    - If the file does not exist, an IOException is thrown.
    - Path.of is used to create a platform-independent path to the resource.
    - The entire file is read into memory using readAllBytes().
    - Output: 72 | 101 | 108 | 108 | 111 | 32 | 87 | 111 | 114 | 108 | 100
    */
    try (InputStream in = Files.newInputStream(Path.of("resources/file.dat"))) {
        bytes = in.readAllBytes();
        for (byte b : bytes) IO.println(b);
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

    //==================================================================================================================
    // Text Data Stream
    //==================================================================================================================

    /*
    Reading Text
    - The "Files.newBufferedReader" method creates a BufferedReader for reading text files.
    - If the file does not exist, an IOException is thrown.
    - Path.of is used to create a platform-independent path to the resource.
    - The entire text is read into a String in memory using readAllAsString().
    - Output: Hello World
    */
    try (BufferedReader in = Files.newBufferedReader(Path.of("resources/file.txt"))) {
        content = in.readAllAsString();
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
        content = "Hello World";
        out.write(content);
    }

    //==================================================================================================================
    // Walk File Tree
    //==================================================================================================================

    /*
    Walk File Tree
    - The "Files.walkFileTree" method recursively traverses a directory tree starting from the specified path.
    - The traversal is controlled by a FileVisitor (or SimpleFileVisitor), allowing actions on files and directories.
    - In this example, we override the visitFile method to print the path of each file visited.
    - FileVisitResult.CONTINUE indicates that the traversal should continue normally.
    - Output example: Visiting: resources\file.dat | Visiting: resources\file.txt
    */
    Files.walkFileTree(Path.of("resources"), new SimpleFileVisitor<Path>() {
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            IO.println("Visiting: " + file);
            return FileVisitResult.CONTINUE;
        }
    });
}