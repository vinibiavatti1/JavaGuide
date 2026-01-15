/*
 * Facade Design Pattern
 * - This section explains the "Facade" design pattern, which provides a simplified, unified interface to a set of
 *   interfaces in a subsystem, making it easier for clients to interact with the subsystem.
 *
 * Overview
 * - The Facade pattern is a structural design pattern.
 * - It defines a higher-level interface that makes a subsystem easier to use.
 * - Clients interact with the Facade instead of dealing directly with complex subsystem classes.
 * - Commonly used to reduce dependencies between clients and subsystems, improving modularity.
 *
 * Key Elements
 * - Facade: provides a simplified interface to the subsystem.
 * - Subsystem Classes: the classes that implement subsystem functionality, which clients would otherwise interact with
 *   directly.
 * - Client: interacts with the subsystem through the Facade.
 *
 * Key Characteristics
 * - Hides subsystem complexity from clients.
 * - Promotes loose coupling between clients and the subsystem.
 * - Improves readability and maintainability of client code.
 * - Can be applied to group related classes and provide a single entry point.
 *
 * Usage
 * - Use Facade when you want to simplify interactions with a complex subsystem.
 * - Apply when you need to decouple clients from subsystem classes.
 * - Ideal for providing a stable interface to a library, framework, or complex module.
 * - Avoid adding business logic to the Facade; it should delegate to subsystem classes only.
 */

/*
 * Facade
 * - Provides a simplified interface to the subsystem
 */
public class OrderFacade {
    private Inventory inventory = new Inventory();
    private Payment payment = new Payment();
    private Shipping shipping = new Shipping();

    public boolean processOrder(String customer, String address, String item, double amount) {
        if (!inventory.checkStock(item)) {
            IO.println("Item not available");
            return false;
        }
        if (!payment.processPayment(customer, amount)) {
            IO.println("Payment not accepted");
            return false;
        }
        shipping.shipItem(item, address);
        return true;
    }
}

/*
 * Subsystem Classes
 * - The classes that implement subsystem functionality, which clients would otherwise interact with directly.
 */
public class Inventory {
    public boolean checkStock(String item) {
        IO.println("Checking stock for item: " + item);
        return true;
    }
}
public class Payment {
    public boolean processPayment(String customer, double amount) {
        IO.println("Processing payment for customer: " + customer + ". Amount: " + amount);
        return true;
    }
}
public class Shipping {
    public void shipItem(String item, String address) {
        IO.println("Shipping " + item + " to " + address);
    }
}

/*
 * Client
 * - Interacts with the subsystem through the Facade.
 */
public class Shop {
    private OrderFacade orderFacade = new OrderFacade();

    public void checkout(String customer, String address, String item, double amount) {
        if (!orderFacade.processOrder(customer, address, item, amount)) {
            IO.println("Error to process the order");
            return;
        }
        IO.println("Order processed successfully!");
    }
}

/*
 * Example
 * - The example below shows the usage of the Facade design pattern.
 */
void main() {
    Shop shop = new Shop();
    shop.checkout("John", "Great Street, AB", "PC", 1500.0);
    // Output:
    // Checking stock for item: PC
    // Processing payment for customer: John. Amount: 1500.0
    // Shipping PC to Great Street, AB
    // Order processed successfully!
}