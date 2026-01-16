/*
 * Proxy Design Pattern
 * - This section explains the "Proxy" design pattern, which provides a surrogate or placeholder for another object to
 *   control access, reduce cost, or add additional functionality.
 *
 * Overview
 * - The Proxy pattern is a structural design pattern.
 * - It provides a representative object (proxy) that controls access to a real object (subject).
 * - Commonly used for lazy initialization, access control, logging, caching, or remote communication.
 *
 * Key Elements
 * - Subject: defines the common interface for the real object and the proxy.
 * - RealSubject: the actual object that performs the work.
 * - Proxy: maintains a reference to the RealSubject and controls access to it, possibly adding extra behavior.
 * - Client: interacts with the Subject interface, unaware whether it is dealing with a proxy or the real object.
 *
 * Key Characteristics
 * - Enables controlled access to an object without changing its interface.
 * - Supports lazy initialization (creating expensive objects only when needed).
 * - Can add extra functionality such as caching, logging, or security checks.
 * - Helps manage resources efficiently, especially for remote or large objects.
 *
 * Usage
 * - Use Proxy when direct access to an object is undesirable, expensive, or needs additional control.
 * - Apply for virtual proxies (lazy creation), protection proxies (access control), or remote proxies (network
 *   communication).
 * - Ideal when you want to add functionality transparently without modifying the original class.
 */

/*
 * Subject
 * - Defines the common interface for the real object and the proxy.
 */
public interface Connector {
    void connect(String user, String password);
}

/*
 * RealSubject
 * - The actual object that performs the work.
 */
public class Database implements Connector {
    @Override
    public void connect(String user, String password) {
        IO.println("Connected!");
    }
}

/*
 * Proxy
 * - Maintains a reference to the RealSubject and controls access to it, possibly adding extra behavior.
 */
public class SecureDatabaseProxy implements Connector {
    private Database readDatabase;

    public SecureDatabaseProxy() {
        this.readDatabase = new Database();
    }

    @Override
    public void connect(String user, String password) {
        if (user.equals("admin") && password.equals("12345")) {
            readDatabase.connect(user, password);
            return;
        }
        IO.println("Access Denied!");
    }
}

/*
 * Client
 * - Interacts with the Subject interface, unaware whether it is dealing with a proxy or the real object.
 */
public class DatabaseService {
    private Connector connector;

    public DatabaseService(Connector connector, String name, String password) {
        this.connector = connector;
        this.connector.connect(name, password);
    }
}

/*
 * Example
 * - The example below shows the usage of the Proxy design pattern.
 */
void main() {
    Database database = new Database();
    SecureDatabaseProxy secureDatabaseProxy = new SecureDatabaseProxy();

    String user = "john", password = "123";
    new DatabaseService(database, user, password);            // Output: Connected!
    new DatabaseService(secureDatabaseProxy, user, password); // Output: Access Denied!
}