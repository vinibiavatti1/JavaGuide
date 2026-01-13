/*
ServiceLoader
- This section explains the Java ServiceLoader facility, which provides a standardized and explicit mechanism
  for discovering and loading service implementations at runtime using the Service Provider Interface (SPI) pattern.

Overview
- ServiceLoader is part of the java.util package.
- It formalizes the Service Provider Interface (SPI) pattern in the Java platform.
- A service defines a contract, while providers supply concrete implementations of that contract.
- Consumers interact only with the service type; implementations are discovered dynamically at runtime.
- Service discovery is explicit and deterministic, based on provider registration rather than classpath scanning.

Key Characteristics
- Decouples service APIs from their implementations.
- Supports multiple providers for the same service contract.
- Provider discovery relies on explicit registration, not annotations or package scanning.
- Provider instantiation is lazy and occurs only when providers are accessed.
- Providers are cached by the ServiceLoader instance.
- Works on the classpath-based resource model using META-INF/services.
- Optionally, a custom ClassLoader can be provided to load providers from alternative or external locations.

Core Concepts
- Service:
  - A public interface or abstract class that defines a contract.
  - Represents a capability or behavior without binding to a specific implementation.
- Provider:
  - A concrete, public class that implements or extends the service.
  - Supplies the actual behavior defined by the service contract.
  - Must be instantiable by the ServiceLoader.
- Consumer:
  - Code that uses ServiceLoader to locate and use providers.
  - Depends only on the service type, not on specific provider classes.

Provider Requirements
- Provider classes must be public and non-abstract.
- Providers must implement the service interface or extend the abstract service class.
- A public no-argument constructor is required.
- Providers must be visible on the runtime classpath.
- Providers may be top-level classes or static nested classes.
- Non-static inner classes, local classes, and anonymous classes are not supported.

Registration and Discovery (Classpath-Based)
- Step 1: Define the service contract.
  - Create a public interface or abstract class.
  - Example: com.example.Service
- Step 2: Implement one or more providers.
  - Create concrete classes that implement the service.
  - Example: com.example.Provider
- Step 3: Register providers.
  - Create a text file at: META-INF/services/com.example.Service
  - List the fully-qualified provider class name(s) in the file.
  - Multiple providers may be registered for the same service.
- Step 4: Ensure resources are available.
  - Verify provider classes and META-INF/services files are present on the runtime classpath.
- Step 5: Load and iterate providers.
  - Use ServiceLoader.load(ServiceType.class) in consumer code.
  - Providers are discovered and instantiated lazily during iteration.

Notes
- ServiceLoader does not perform dependency injection or lifecycle management.
- No automatic scanning or inference is performed; registration is mandatory.
- ServiceLoader behavior is consistent whether running from an IDE or a packaged JAR.
- All classes in this guide are inner classes for simplicity, which is why the "$" symbol appears in their fully
  qualified names.

Service
- The interface below represents the Service, defining the contract that providers must implement.
- The Service interface is registered in the file located at: resources/META-INF/services/_01_ServiceLoader$Service
*/
public static interface Service {
    void run();
}

/*
Provider
- The class below represents the Provider, which implements the Service contract and provides the concrete behavior.
- The Provider class is registered in that file as: _03_AnnotationCompileProcessing$MyProcessor
*/
public static class Provider implements Service {
    @Override
    public void run() {
        IO.println("Hello World!");
    }
}

/*
Service Loader
- The method below uses ServiceLoader to dynamically discover and load the Provider at runtime.
*/
void main() {
    ServiceLoader<Service> loader = ServiceLoader.load(Service.class);
    for (Service provider : loader) {
        provider.run(); // Output: Hello World!
    }
}
