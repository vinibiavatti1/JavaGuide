/*

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
    */
    bytes = "Hello World".getBytes();
    Files.write(Path.of("resources/file.txt"), bytes);

    /*
    Writing String
    - The "Files.writeString" method writes the given String to the specified file using UTF-8 by default.
    - If the file already exists, its content is replaced; if it does not exist, it is created automatically.
    - Output example: "Hello World" is written to resources/file.txt
    */
    content = "Hello World";
    Files.writeString(Path.of("resources/file.txt"), content);
}