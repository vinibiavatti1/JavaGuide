/*
 * System
 * - This section explains the "System" class in Java, which provides access to standard input, output, and error
 *   streams, system properties, environment variables, and utility methods for array copying, current time, and garbage
 *   collection control.
 *
 * Overview
 * - The "System" class is part of the java.lang package and is automatically available without imports.
 * - It contains only static fields and methods; no instances of System can be created.
 * - Provides access to system-level resources, including standard I/O streams, environment information, and runtime 
 *   operations.
 *
 * Key Characteristics
 * - Static fields for standard streams: "System.in", "System.out", and "System.err".
 * - Methods for interacting with system properties: "getProperty", "setProperty", and "clearProperty".
 * - Access to environment variables via "System.getenv".
 * - Utility methods for array copying, timing, and garbage collection.
 * - Logging support via "System.getLogger".
 * - Method for exiting the JVM.
 *
 * Usage
 * - Use System to read from standard input, write to standard output and error, and interact with the runtime
 *   environment.
 * - Retrieve system properties or environment variables for configuration and runtime checks.
 * - Perform low-level operations such as copying arrays efficiently or measuring execution time.
 * - Control JVM termination, trigger garbage collection, or access system-specific constants.
 */
void main() throws IOException {
    //==================================================================================================================
    // Standard Streams
    //==================================================================================================================

    /*
     * Output Stream
     * - Writes data to the standard output stream using System.out, which is typically the console.
     * - println appends a newline after the output, while print does not.
     * - Useful for debugging, logging simple messages, or displaying program results to the user.
     * - Note: In Java 25, a new IO.println method was introduced as a shorthand for System.out.println.
     * - Output: Hello World!
     */
    System.out.println("Hello World!");

    /*
     * Error Output Stream
     * - Writes data to the standard error stream using System.err, which is typically the console.
     * - Useful for displaying error messages or logging problems separately from standard output.
     * - Unlike System.out, System.err can be redirected independently to separate logs or consoles.
     * - Output: An error occurred
     */
    System.err.println("An error occurred");

    /*
     * Input Stream
     * - Provides access to the standard input stream using System.in, typically connected to the console.
     * - Can be used to read bytes or characters entered by the user.
     * - For interactive input, consider using Scanner or BufferedReader for easier and non-blocking reading.
     * - Note: The example is commented since reading from console blocks the current thread.
     */
    /// byte[] bytes = System.in.readAllBytes();

    //==================================================================================================================
    // System Utilities
    //==================================================================================================================

    /*
     * Current Time Millis
     * - Returns the current time in milliseconds since the Unix epoch (January 1, 1970, 00:00:00 UTC).
     * - Useful for measuring timestamps, logging, or calculating elapsed time.
     * - Note: The returned value is system-dependent and may change if the system clock is adjusted.
     * - Output: 1768944931632
     */
    IO.println(System.currentTimeMillis());

    /*
     * Nano Time
     * - Returns the current value of the most precise available system timer, in nanoseconds.
     * - Primarily used for measuring elapsed time with high precision; not related to wall-clock time.
     * - The value has no absolute meaning and should only be used to calculate differences between two calls.
     * - Output: 176722178010500
     */
    IO.println(System.nanoTime());

    /*
     * Line Separator
     * - Returns the system-dependent line separator string used by the operating system.
     * - Common options include:
     *   - Windows: "\r\n"
     *   - Unix/Linux/macOS: "\n"
     *   - Older Mac OS (pre-OS X): "\r"
     * - Useful for generating text files or console output that is compatible with the underlying OS.
     * - Output: \r\n
     */
    IO.println(System.lineSeparator());

    /*
     * Array Copy
     * - Copies elements from a source array to a destination array using System.arraycopy.
     * - Provides a fast, low-level array copy mechanism compared to manual loops.
     * - Output: [1, 2, 3]
     */
    int[] src = new int[] {1, 2, 3};
    int[] dst = new int[3];
    System.arraycopy(src, 0, dst, 0, 3);
    IO.println(Arrays.toString(dst));

    //==================================================================================================================
    // Java Properties
    //==================================================================================================================

    /*
     * Get Property
     * - Retrieves the value of a system property from the JVM using System.getProperty.
     * - Common properties include:
     *   - "user.home" : user's home directory
     *   - "java.version" : Java runtime version
     *   - "os.name" : operating system name
     *   - "file.separator" : system file separator
     * - Returns the property value as a String, or null if the property is not set.
     * - Output: C:\home
     */
    IO.println(System.getProperty("user.home"));

    /*
     * Set Property
     * - Sets or updates a system property in the JVM using System.setProperty.
     * - The first parameter is the property name, and the second is its value.
     * - Properties set at runtime are available to the current JVM session and can be retrieved using
     *   System.getProperty.
     * - Useful for configuring runtime behavior without restarting the application.
     * - System properties can also be set when starting the JVM using the -D option: e.g., java -DmyProp=value MyApp
     */
    System.setProperty("my.prop", "abc");

    /*
     * Clear Property
     * - Removes a system property from the JVM using System.clearProperty.
     * - The property specified by the name parameter will no longer be available via System.getProperty.
     * - Useful for cleaning up or resetting configuration properties during runtime.
     */
    System.clearProperty("my.prop");

    /*
     * List Properties
     * - Retrieves all system properties from the JVM and prints them.
     * - System.getProperties() returns a Properties object containing key-value pairs for configuration, runtime
     *   environment, OS details, user information, and JVM settings.
     * - Use for debugging, configuration inspection, or logging runtime environment details.
     * - Output:
     *   java.specification.version: 25
     *   sun.cpu.isalist: amd64
     *   sun.jnu.encoding: Cp1252
     *   ...
     */
    System.getProperties().forEach((k, v) -> IO.println(k + ": " + v));

    //==================================================================================================================
    // Environment Variables
    //==================================================================================================================

    /*
     * Get Environment Variable
     * - Retrieves the value of an operating system environment variable using System.getenv.
     * - The parameter is the name of the environment variable to fetch.
     * - Returns the variable's value as a String, or null if the variable is not set.
     * - Useful for accessing OS-level configuration, user information, or paths.
     * - Output: John
     */
    IO.println(System.getenv("USERNAME"));

    /*
     * List Environment Variables
     * - Retrieves all environment variables from the operating system and prints them.
     * - System.getenv() returns an unmodifiable Map containing key-value pairs of environment variables.
     * - Useful for inspecting system configuration, paths, user information, or runtime environment details.
     * - Output:
     *   PROCESSOR_LEVEL: 25
     *   PROCESSOR_ARCHITECTURE: AMD64
     *   Path: C:\WINDOWS\system32;C:\WINDOWS;...
     *   ...
     */
    System.getenv().forEach((k, v) -> IO.println(k + ": " + v));

    //==================================================================================================================
    // JVM Operations
    //==================================================================================================================

    /*
     * Run Garbage Collector
     * - Suggests that the Java Virtual Machine perform garbage collection to reclaim memory.
     * - System.gc() is a request to the JVM; it does not guarantee immediate collection.
     * - Useful for testing, memory management experiments, or reducing memory usage in controlled scenarios.
     * - For production applications, rely on the JVM's automatic garbage collection rather than calling System.gc().
     */
    System.gc();

    /*
     * Exit
     * - Terminates the currently running Java Virtual Machine using System.exit.
     * - The parameter is the status code returned to the operating system:
     *   - 0 typically indicates normal termination.
     *   - Non-zero values indicate abnormal termination or error codes.
     * - Immediately stops all running threads and shuts down the JVM.
     * - Useful for ending applications programmatically, signaling success or failure to external processes.
     */
    System.exit(0);
}