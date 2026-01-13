/*
 * Enums Properties
 * - This section explains how Java enums can include fields, constructors, and methods to represent additional data and
 *   behavior for each constant.
 *
 * Overview
 * - Enums in Java are more than just named constants; they can have fields and methods.
 * - Each enum constant can store associated data via fields.
 * - Constructors initialize these fields for each constant.
 * - Methods provide controlled access to the enum's data, similar to regular classes.
 *
 * Key Characteristics
 * - Fields can be private and final to enforce immutability.
 * - Enum constructors are always private (implicitly) and cannot be public.
 * - Getter methods allow access to each constant's data.
 * - Enums can implement interfaces and contain additional behavior if needed.
 *
 * Usage
 * - Use fields to associate metadata or identifiers with each constant.
 * - Use methods to expose this data safely and encapsulate logic.
 * - Useful for representing entities with a fixed set of instances plus properties (e.g., error codes, statuses,
 *   colors).
 *
 * Example:
 * - The example shows an enum "Color" with an "id" and a "description" field for each constant.
 * - Getter methods provide access to the fields.
 */
public enum Color {
    RED(1, "Red"),
    GREEN(2, "Green"),
    BLUE(3, "Blue");

    // Fields
    private final int id;
    private final String description;

    // Private Constructor
    Color(int id, String description) {
        this.id = id;
        this.description = description;
    }

    // Methods
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
}

void main() {
    IO.println(Color.RED);                  // RED
    IO.println(Color.RED.getId());          // 1
    IO.println(Color.RED.getDescription()); // Red
}