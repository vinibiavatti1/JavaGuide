/*
 * Classpath Resources
 * - This section explains classpath resources in Java, which are non-code files packaged together with the application
 *   and loaded via the classpath at runtime, independently of the underlying filesystem structure.
 *
 * Overview
 * - Classpath resources are files included in the application's classpath (e.g., text files, configuration files,
 *   templates, SQL scripts, JSON, XML, icons, etc.).
 * - They are typically placed under a resources directory and copied to the classpath during the build process.
 * - Resources are accessed through the Class or ClassLoader APIs, not via direct filesystem paths.
 * - The same access mechanism works consistently whether the application runs from an IDE, a JAR, or a module.
 *
 * Key Characteristics
 * - Resources are resolved through the classpath abstraction, not as physical files.
 * - Access is read-only; resources should be treated as immutable at runtime.
 * - Loading is performed using getResource or getResourceAsStream, returning a URL or InputStream.
 * - The physical location of the resource (directory, JAR, module) is intentionally hidden.
 * - Path-based APIs (File, Path, Files) are not guaranteed to work with classpath resources.
 *
 * How Resources Are Accessed
 * - Resources are loaded via the Class or ClassLoader APIs, which perform a lookup on the application's classpath.
 * - Class.getResource(...) resolves paths relative to the package of the calling class, unless an absolute path is
 *   used.
 * - An absolute path (starting with "/") is resolved from the root of the classpath.
 * - ClassLoader.getResource(...) and getResourceAsStream(...) always resolve paths from the classpath root.
 * - The result is typically a URL or an InputStream, which should be treated as a read-only data source.
 *
 * Notes
 * - When a resource is loaded from the root of the classpath using an absolute path, the specific class used to invoke
 *   "getClass()" does not matter, since the resource is resolved against the global classpath rather than relative to
 *   the caller's package.
 *
 * Usage
 * - Use classpath resources for static, application-bundled data such as templates, default configuration files,
 *   documentation samples, test fixtures, icon files, etc.
 * - Prefer "getResourceAsStream" for portable and safe access across different runtime environments.
 * - Avoid modifying or writing to classpath resources; externalize any data that requires persistence or mutation.
 * - Apply classpath resources when data must travel with the application and remain consistent across deployments.
 */
void main() throws IOException {
    /*
     * Reading Classpath Bytes File
     * - The "getResourceAsStream" method loads a resource from the classpath as an InputStream.
     * - The resource path is resolved via the classpath abstraction, not the filesystem.
     * - An absolute path (starting with "/") is resolved from the root of the classpath.
     * - The resource may be located inside a directory, JAR, or module, transparently to the caller.
     * - If the resource cannot be found, "getResourceAsStream" returns null.
     * - Output: -119 | 80 | 78 | 71 | 13 | ...
     */
    try (InputStream in = getClass().getResourceAsStream("/icon.png")) {
        byte[] content = in.readAllBytes();
        for (byte b : content) IO.println(b);
    }

    /*
     * Reading Classpath Text File
     * - The "getResourceAsStream" method loads a text resource from the classpath as a raw InputStream.
     * - Unlike the Files utility class, classpath resource access does not provide format-specific convenience methods.
     * - Decorator streams (such as InputStreamReader and BufferedReader) must be applied manually to interpret the
     *   data.
     * - InputStreamReader is used to convert bytes into characters using a character encoding.
     * - BufferedReader adds efficient buffering and high-level text reading operations.
     * - The resource is resolved via the classpath abstraction and may reside inside a directory, JAR, or module.
     * - If the resource cannot be found, "getResourceAsStream" returns null.
     * - Output: prop=value
     */
    try (InputStream in = getClass().getResourceAsStream("/config.txt")) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String content = reader.readAllAsString();
        IO.println(content);
    }
}
