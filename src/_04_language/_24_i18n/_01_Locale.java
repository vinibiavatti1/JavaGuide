/*
 * Locale
 * - This section explains the "Locale" class in Java, which represents a specific geographical, political, or cultural
 *   region and is a core building block for internationalization (i18n).
 *
 * Overview
 * - The "Locale" class is part of the java.util package.
 * - It encapsulates language, country/region, and optional variants or extensions.
 * - Locales are used by i18n-aware APIs to adapt behavior such as language, formatting, and cultural conventions.
 * - Modern Java versions provide factory methods like Locale.of(...) aligned with the BCP 47 standard.
 *
 * Key Characteristics
 * - Immutable objects representing language and regional preferences.
 * - Used as a key or parameter for i18n APIs such as ResourceBundle, DateFormat, NumberFormat, and Collator.
 * - Supports language tags (BCP 47), scripts, regions, and extensions.
 * - Provides predefined constants for common locales (e.g., Locale.ENGLISH, Locale.US).
 *
 * Default Locale
 * - The Default Locale represents the JVM’s current locale, typically derived from the underlying operating system or
 *   JVM configuration.
 * - Influences all locale-sensitive operations that rely on a default when no explicit Locale is provided, such as
 *   formatting dates, numbers, currencies, and loading localized resources.
 * - Can be retrieved with Locale.getDefault() and changed at runtime with Locale.setDefault(...).
 * - Can also be configured at JVM startup using system properties, for example:
 *   - java -Duser.language=pt -Duser.country=BR MyApp
 * - Useful for ensuring consistent language and regional behavior across an application or system.
 *
 * Usage
 * - Use Locale to control language and regional behavior in applications.
 * - Pass Locale instances to formatting APIs to ensure correct cultural representation.
 * - Combine with ResourceBundle to load localized resources based on user or system locale.
 * - Prefer Locale.of(...) in modern code for validation and standard compliance; use constructors mainly for legacy or
 *   compatibility scenarios.
 */
void main() {
    //==================================================================================================================
    // Locale Constants
    //==================================================================================================================

    /*
     * Language Constants
     * - The "Locale" class provides predefined constants for commonly used languages and regions.
     * - The "Locale.ENGLISH" represents the English language without a specific country or region.
     * - These constants help avoid hard-coded strings and reduce the risk of invalid locale definitions.
     * - Useful when language-specific behavior is required but regional variations are not relevant.
     * - Commonly used with i18n APIs such as ResourceBundle, DateFormat, and NumberFormat.
     * - Output: en
     */
    IO.println(Locale.ENGLISH);

    /*
     * Country Constants
     * - The "Locale" class provides predefined constants that represent both language and country/region combinations.
     * - The "Locale.US" represents the English language as used in the United States.
     * - Includes both language ("en") and country ("US"), following ISO standards.
     * - Useful when regional formatting rules (dates, numbers, currency) and localized resources depend on the country.
     * - Commonly used with i18n APIs such as ResourceBundle, DateFormat, NumberFormat, and Currency.
     * - Output: en_US
     */
    IO.println(Locale.US);

    //==================================================================================================================
    // Default Locale
    //==================================================================================================================

    /*
     * Get Default Locale
     * - The "getDefault" method returns the system’s current default Locale.
     * - This Locale is typically derived from the operating system or JVM configuration.
     * - Used as the fallback Locale when no explicit Locale is provided to i18n-aware APIs.
     * - Influences default language, date, number, and currency formatting in the application.
     * - The default Locale can be changed at runtime using Locale.setDefault(...).
     * - Output: pt_PT
     */
    IO.println(Locale.getDefault());

    /*
     * Set Default Locale
     * - The "setDefault" method changes the JVM’s default Locale at runtime.
     * - Affects all locale-sensitive operations that rely on the default Locale.
     * - Commonly used in applications to enforce a consistent language or regional behavior.
     * - Should be used with caution, especially in multithreaded or library code, as it impacts global state.
     * - Often applied during application startup or initialization.
     * - Output: en_US
     */
    Locale.setDefault(Locale.US);
    IO.println(Locale.getDefault());

    //==================================================================================================================
    // Locale Instance
    //==================================================================================================================

    /*
     * Get Instance From Language
     * - The "Locale.of" factory method creates a Locale using only a language code.
     * - The language must follow ISO 639 standards (e.g., "pt" for Portuguese).
     * - Produces a Locale without an associated country or region.
     * - Preferred over constructors in modern Java, as it validates input and follows BCP 47.
     * - Useful when only language-level localization is required.
     * - Output: pt
     */
    Locale locale = Locale.of("pt");
    IO.println(locale);

    /*
     * Get Instance From Language And Country
     * - The "Locale.of" factory method creates a Locale using both a language code and a country/region code.
     * - Language codes follow ISO 639 standards (e.g., "pt" for Portuguese), and country codes follow ISO 3166 (e.g.,
     *   "BR" for Brazil).
     * - Produces a Locale that can be used for region-specific formatting, resources, and cultural conventions.
     * - Preferred over constructors in modern Java for validation and BCP 47 compliance.
     * - Useful when both language and regional variations are important in internationalized applications.
     * - Output: pt_BR
     */
    locale = Locale.of("pt", "BR");
    IO.println(locale);

    /*
     * Declaration With Language (Legacy)
     * - The "new Locale" constructor creates a Locale using only a language code.
     * - Considered legacy because it does not validate input or enforce BCP 47 compliance.
     * - Language codes should follow ISO 639 standards (e.g., "pt" for Portuguese), but invalid codes are allowed.
     * - Produces a Locale without an associated country or region.
     * - Use primarily for legacy code or backward compatibility; prefer Locale.of(...) in modern applications.
     * - Output: pt
     */
    locale = new Locale("pt");
    IO.println(locale);

    /*
     * Declaration With Language And Country (Legacy)
     * - The "new Locale" constructor creates a Locale using both a language code and a country/region code.
     * - Considered legacy because it does not validate the codes or enforce BCP 47 compliance.
     * - Language codes follow ISO 639 (e.g., "pt") and country codes follow ISO 3166 (e.g., "BR"), but invalid values
     *   are allowed.
     * - Produces a Locale suitable for region-specific formatting and resources, but with less safety than
     *   Locale.of(...).
     * - Use primarily for legacy code or backward compatibility; prefer Locale.of(...) in modern applications.
     * - Output: pt_BR
     */
    locale = new Locale("pt", "BR");
    IO.println(locale);
}