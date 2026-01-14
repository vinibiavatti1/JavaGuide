/*
 * External Service Loader
 * - This section explains how to use ServiceLoader to discover and load service implementations from external JARs at
 *   runtime using a custom ClassLoader. This approach enables dynamic plugin loading without compile-time dependencies
 *   on the provider implementations.
 *
 * Overview
 * - External ServiceLoader builds on the standard ServiceLoader mechanism but allows providers to reside in JARs
 *   outside the main application classpath.
 * - A custom ClassLoader (typically a URLClassLoader) is used to load the external JARs containing providers.
 * - The service interface must be accessible to both the consumer and the provider JARs.
 * - Service discovery relies on the "META-INF/services" registration mechanism inside the external JARs.
 *
 * Notes
 * - Each provider JAR must include a "META-INF/services/<service>" file listing all provider classes for the service.
 * - The consumer project requires a compile-time dependency only on the service interface, not on the provider JAR.
 * - Multiple external JARs can be loaded using the same ClassLoader or separate ClassLoaders.
 * - Lazy instantiation and caching of providers behave the same as the standard ServiceLoader.
 *
 * External JARs
 * - Service JAR: lib/JavaServiceLoaderService.jar
 *   - Contains the service interface: com.example.ExternalService
 * - Provider JAR: plugins/JavaServiceLoaderProvider.jar
 *   - Contains the provider implementation: com.example.ExternalProvider
 *   - Depends on the service JAR.
 *   - Registers the provider in:
 *     - META-INF/services/com.example.ExternalService
 *       | com.example.ExternalProvider
 *
 * Example
 * - The service and provider are packaged in separate JARs as described above.
 * - The guide project depends on the service JAR (/lib/JavaServiceLoaderService.jar) but not on the provider JAR.
 * - The code below dynamically loads the external provider JAR using a URLClassLoader, then uses ServiceLoader to
 *   discover and invoke the provider:
 * - This allows the main application to remain independent of provider JARs at compile time, enabling runtime
 *   extensibility and dynamic plugin loading.
 */
import com.example.ExternalService;

void main() throws Exception {
    // Step 1: Locate the external provider JAR
    Path jarPath = Path.of("plugins/JavaServiceLoaderProvider.jar");

    // Step 2: Convert the path to a URL and create an array for the URLClassLoader (supports multiple JARs)
    URL[] classLoaderUrls = new URL[] { jarPath.toUri().toURL() };

    // Step 3: Create a URLClassLoader for the external JAR, using the current class loader as parent
    URLClassLoader classLoader = new URLClassLoader(classLoaderUrls, this.getClass().getClassLoader());

    // Step 4: Use ServiceLoader with the custom ClassLoader to find providers implementing ExternalService
    ServiceLoader<ExternalService> loader = ServiceLoader.load(ExternalService.class, classLoader);

    // Step 5: Iterate over discovered providers and execute their run() method
    for (ExternalService provider : loader) {
        provider.run(); // Output: Hello From External Provider!
    }
}