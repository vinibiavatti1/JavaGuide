/*
 * Singleton Design Pattern
 * - This section explains the "Singleton" design pattern, which ensures that a class has only one instance and provides
 *   a global point of access to it.
 *
 * Overview
 * - The Singleton pattern is a creational design pattern.
 * - It restricts instantiation of a class to a single object and provides a static method to access it.
 * - Useful when exactly one object is needed to coordinate actions across the system.
 * - Commonly used for logging, configuration management, thread pools, or caching.
 *
 * Key Elements
 * - Singleton Class: contains a private static field to hold the single instance and a private constructor to prevent
 *   external instantiation.
 * - getInstance(): a public static method that returns the single instance, creating it if necessary.
 * - Optional: lazy initialization, eager initialization, or thread-safe variants depending on requirements.
 *
 * Key Characteristics
 * - Guarantees a single instance of a class throughout the application.
 * - Provides a global access point to the instance.
 * - Can control access and manage shared resources efficiently.
 * - Variants may support thread safety, lazy initialization, or serialization.
 *
 * Usage
 * - Use Singleton when only one instance of a class is required, and it must be accessible globally.
 * - Apply in scenarios like configuration managers, logging, caching, or resource pools.
 * - Prefer thread-safe implementations in multithreaded applications.
 * - Avoid overusing Singletons, as they introduce global state and can complicate testing and dependency management.
 */

/*
 * Singleton Class
 * - Contains a private static field to hold the single instance and a private constructor to prevent external
 *   instantiation.
 */
public static class Database {
    // Static field to hold the single instance
    private static Database INSTANCE = null;

    // Private Constructor to prevent external instantiation.
    private Database() {}

    // Public static method that returns the single instance, creating it if necessary.
    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }
}

/*
 * Example
 * - The example below shows the usage of the Singleton design pattern.
 */
void main() {
    Database database1 = Database.getInstance();
    Database database2 = Database.getInstance();
    IO.println(database1 == database2); // true - they are the same instance
}