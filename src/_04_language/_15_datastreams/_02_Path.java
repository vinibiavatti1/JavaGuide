/*
Path
- This section explains the "Path" interface in Java, which represents a platform-independent path to a file or
  directory in the filesystem and serves as the foundation of the NIO.2 API.

Overview
- The "Path" interface is part of the java.nio.file package.
- It represents the location of a file or directory without performing I/O operations by itself.
- Paths can be absolute or relative and are resolved by a filesystem implementation.
- Introduced in Java 7 as part of the NIO.2 (New I/O) API.

Key Characteristics
- Path is an interface, not a concrete class; it is typically obtained via Path.of(...).
- Provides methods for path manipulation, such as resolving, normalizing, and comparing paths.
- Does not access the filesystem directly; actual I/O operations are performed by the Files utility class.
- Immutable: operations like resolve or normalize return new Path instances.

Notes
- Path replaces the legacy java.io.File class for representing filesystem locations.
- Relative paths are resolved against the current working directory of the JVM.
- Path operations are platform-independent, handling separators and filesystem rules automatically.
- Can represent files, directories, symbolic links, or non-existent resources.
- Avoid using the "Paths" class since this class may be deprecated in a future release.

Usage
- Use Path to represent and manipulate filesystem paths.
- Common operations include resolving child paths, navigating to parent paths, normalizing paths, and converting
  between absolute and relative paths.
- Typically used together with the Files class to perform actual file or directory operations.
*/
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
    Declaration
    - Creates a Path instance representing a file or directory location.
    - The path can be absolute or relative and does not require the resource to exist.
    - No I/O operation is performed; this only represents the filesystem path.
    - Output: C:\directory\file.txt
    */
    Path path = Path.of("C:/directory/file.txt");
    IO.println(path);

    //==================================================================================================================
    // Transformation
    //==================================================================================================================

    /*
    Normalization
    - Removes redundant elements such as "." and ".." from a path.
    - Simplifies the path without accessing the filesystem.
    - Output: C:\directory\file.txt
    */
    path = Path.of("C:/directory/../directory/file.txt");
    IO.println(path.normalize());

    /*
    Convert to Absolute Path
    - Converts a relative path into an absolute path based on the JVM's current working directory.
    - No filesystem access is performed.
    - Output: C:\directory\file.txt
    */
    path = Path.of("directory/file.txt");
    IO.println(path.toAbsolutePath());

    //==================================================================================================================
    // Checks
    //==================================================================================================================

    /*
    Is Absolute Path
    - Checks whether the path is absolute or relative.
    - An absolute path contains all information required to locate a file in the filesystem.
    - Output: false
    */
    path = Path.of("directory/file.txt");
    IO.println(path.isAbsolute());

    /*
    Path Equality
    - Checks whether two Path instances represent the same path.
    - Comparison is syntactic only; does not access the filesystem.
    - Output: true
    */
    path = Path.of("directory/file.txt");
    IO.println(path.equals(Path.of("directory/file.txt")));

    /*
    Path Comparison
    - Compares two Path instances lexicographically.
    - Returns 0 if equal, negative if this path precedes the other, positive if it follows.
    - Output: 0 (equal)
    */
    path = Path.of("directory/file.txt");
    IO.println(path.compareTo(Path.of("directory/file.txt")));

    /*
    Starts With
    - Checks whether a path begins with the specified path.
    - Comparison is done at the path component level, not as a simple string prefix.
    - Output: true
    */
    path = Path.of("directory/file.txt");
    IO.println(path.startsWith(Path.of("directory")));

    /*
    Ends With
    - Checks whether a path ends with the specified path.
    - Comparison is done using path components, not simple string matching.
    - Output: true
    */
    path = Path.of("directory/file.txt");
    IO.println(path.endsWith(Path.of("file.txt")));

    //==================================================================================================================
    // Components
    //==================================================================================================================

    /*
    File Name
    - Returns the name of the file or last element of the path.
    - Does not access the filesystem.
    - Output: file.txt
    */
    path = Path.of("C:/directory/file.txt");
    IO.println(path.getFileName());

    /*
    Parent Path
    - Returns the parent directory of the current path.
    - Returns null if there is no parent (e.g., root path).
    - Output: C:\directory
    */
    path = Path.of("C:/directory/file.txt");
    IO.println(path.getParent());

    /*
    Root Path
    - Returns the root component of the path (e.g., "C:\").
    - Returns null if the path is relative.
    - Output: C:\
    */
    path = Path.of("C:/directory/file.txt");
    IO.println(path.getRoot());
}
