/*
 * Object Serialization
 * - This section explains Java's built-in object serialization mechanism, which allows converting objects into a byte
 *   stream for storage or transmission, and reconstructing them back into objects.
 *
 * Overview
 * - Object serialization in Java is based on the java.io package, primarily using ObjectOutputStream and
 *   ObjectInputStream.
 * - A class must implement the marker interface Serializable to be eligible for serialization.
 * - It is recommended to declare a static final serialVersionUID in Serializable classes to control versioning and
 *   maintain compatibility across different versions of the class.
 * - Serialization supports not only single objects but also collections of objects, arrays, and nested object graphs.
 *
 * Key Characteristics
 * - Serializable is a marker interface with no methods; it signals that the class can be serialized.
 * - serialVersionUID serves as a version identifier for the class; mismatches during deserialization will throw
 *   InvalidClassException.
 * - ObjectOutputStream handles converting objects to a byte stream, writing to files or other outputs.
 * - ObjectInputStream reads the byte stream and reconstructs the original objects.
 * - Fields marked as transient are ignored during serialization.
 * - Supports serializing complex object graphs, including nested objects and standard collection classes (List, Map,
 *   Set, etc.).
 *
 * Transient Fields
 * - Java has a keyword "transient" that can be applied to fields in a Serializable class.
 * - Transient fields are skipped during serialization and are not written to the output stream.
 * - When the object is deserialized, transient fields are initialized to their default values (null for objects,
 *   0 for numbers, false for booleans).
 * - Useful for sensitive data, temporary state, or values that can be recomputed and should not be persisted.
 *
 * Usage
 * - Use ObjectOutputStream to persist objects to files or transmit them over network streams.
 * - Use ObjectInputStream to reconstruct serialized objects back into memory.
 * - Always implement Serializable for classes whose instances need to be serialized.
 * - Declare serialVersionUID to maintain compatibility between class versions.
 * - Useful for saving program state, caching objects, or transferring objects between JVMs.
 *
 * Example:
 * - This example demonstrates object serialization and deserialization in Java using ObjectOutputStream and
 *   ObjectInputStream.
 * - A class "Product" implements Serializable and declares a serialVersionUID for version control.
 * - The field "tempData" is marked transient, so it is not serialized and will be null after deserialization.
 * - The example shows how to persist a Product object to a file and restore it, preserving the non-transient fields.
 */
static class Product implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double price;
    private transient String tempData; // Transient Field - Not serialized, will be null after deserialization

    public Product() {}

    public Product(String name, double price, String tempData) {
        this.name = name;
        this.price = price;
        this.tempData = tempData;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getTempData() {
        return tempData;
    }
}

void main() throws IOException, ClassNotFoundException {
    /*
     * Object Serialization
     * - Serializes a Product object to a file using ObjectOutputStream.
     * - The Product class implements Serializable and defines a serialVersionUID for version control.
     * - Fields marked as transient (like tempData) are not serialized and will be null when deserialized.
     * - Useful for persisting objects, caching state, or sending objects over a network.
     * - Works with single objects, arrays, and collections of Serializable objects.
     * - Output: Binary file "resources/product.dat" containing the serialized object
     */
    Product outProduct = new Product("Computer", 1500.0, "temp_1234");
    try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Path.of("resources/product.dat")))) {
        out.writeObject(outProduct);
    }

    /*
     * Object Deserialization
     * - Reads a serialized Product object from a file using ObjectInputStream.
     * - Restores all non-transient fields to their original values.
     * - Transient fields (like tempData) are not persisted and will be null after deserialization.
     * - Useful for retrieving persisted objects, restoring application state, or receiving objects from a network.
     * - Works with single objects, arrays, and collections of Serializable objects.
     */
    Product inProduct = null;
    try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Path.of("resources/product.dat")))) {
        inProduct = (Product) in.readObject();
    }
    IO.println(inProduct.getName());     // Computer
    IO.println(inProduct.getPrice());    // 1500.0
    IO.println(inProduct.getTempData()); // null (transient, not serialized)
}