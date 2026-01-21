/*
 * ResourceBundle
 * - This section explains the "ResourceBundle" class in Java, which provides a way to store and retrieve
 *   locale-specific objects, typically strings for internationalized messages.
 *
 * Overview
 * - Part of the java.util package.
 * - Loads key-value pairs from property files (e.g., messages.properties) or classes.
 * - Property files must be placed in the *classpath so that the JVM can locate them at runtime.
 * - Supports multiple locales automatically (e.g., messages_en_US.properties, messages_pt_BR.properties).
 * - Often used together with MessageFormat to insert dynamic values into localized messages.
 *
 * Key Characteristics
 * - Locale-sensitive: automatically selects the appropriate bundle based on the specified or default Locale.
 * - Provides getString(key) to retrieve the value of a given key.
 * - Falls back to default bundle if a specific locale bundle is not found.
 * - Simplifies internationalization (i18n) of messages, labels, and other UI text.
 *
 * Usage
 * - Use ResourceBundle to store and retrieve messages or other objects for different locales.
 * - Ensure the property files are available in the classpath so they can be loaded at runtime.
 * - Combine with MessageFormat for dynamic values.
 * - Ideal for applications that need to support multiple languages without changing code.
 */
void main() {
    /*
     * Get Bundle
     * - Loads the default ResourceBundle from the classpath using the base name "messages".
     * - Useful for retrieving locale-specific messages using the default locale of the JVM.
     * - File location: /resources/messages.properties
     */
    ResourceBundle resourceBundle = ResourceBundle.getBundle("messages");

    /*
     * Get Message
     * - Retrieves the message pattern associated with the key "home.welcome" from the ResourceBundle.
     * - Can be combined with MessageFormat to insert dynamic values.
     * - Output: Welcome, John!
     */
    String pattern = resourceBundle.getString("home.welcome");
    String message = MessageFormat.format(pattern, "John");
    IO.println(message);

    /*
     * Get Bundle For Specific Locale
     * - Loads a ResourceBundle for a specific locale, in this case Portuguese (Brazil).
     * - Useful when displaying messages in a specific language or region.
     * - File location: /resources/messages_pt_BR.properties
     */
    resourceBundle = ResourceBundle.getBundle("messages", Locale.of("pt", "BR"));

    /*
     * Get Message From Specific Locale
     * - Retrieves the localized message pattern from the bundle for the specified locale.
     * - Combines with MessageFormat to insert dynamic values.
     * - Output: Bem vindo, John!
     */
    pattern = resourceBundle.getString("home.welcome");
    message = MessageFormat.format(pattern, "John");
    IO.println(message);
}