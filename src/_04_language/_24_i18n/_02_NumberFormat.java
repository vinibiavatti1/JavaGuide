/*
 * NumberFormat
 * - This section explains the "NumberFormat" class in Java, which provides locale-sensitive methods to format and parse
 *   numbers, including integers, decimals, currencies, percentages, and compact representations.
 *
 * Overview
 * - The "NumberFormat" class is part of the java.text package.
 * - It allows numbers to be formatted according to the conventions of a specific Locale.
 * - Supports legacy styles from MessageFormat (integer, currency, percent) as well as modern features like compact
 *   numbers (short and long) and unit formatting (Java 12+ / 17+).
 * - Provides consistent parsing of number strings into numeric values respecting locale rules.
 *
 * Key Characteristics
 * - Locale-sensitive: decimal separators, grouping separators, and currency symbols adapt automatically.
 * - Supports multiple predefined styles: integer, currency, percent, compact_short, compact_long, and unit.
 * - Offers parsing methods to convert formatted strings back to numbers.
 * - Modern APIs allow integration with java.time, BigDecimal, and other numeric types.
 * - Can be customized using subclasses like DecimalFormat for patterns and rounding control.
 *
 * Instances
 * - getNumberInstance(): Returns a general-purpose number formatter for the specified or default locale.
 * - getIntegerInstance(): Returns a number formatter that formats numbers as integers (no decimal places).
 * - getCurrencyInstance(): Returns a number formatter specialized for currency values.
 * - getPercentInstance(): Returns a number formatter specialized for percentages.
 * - getCompactNumberInstance(): Returns a formatter that displays numbers in compact form (short or long).
 *
 * Usage
 * - Use NumberFormat when displaying numbers to end users in a locale-aware manner.
 * - Ideal for financial applications (currency), statistical displays (percentages), or large numbers
 *   (compact notation).
 * - Apply parsing methods when reading user input that is formatted according to locale conventions.
 * - Combine with ResourceBundle for fully internationalized UI messages.
 */
void main() {
    /*
     * Number
     * - The "getNumberInstance" method of NumberFormat returns a general-purpose number formatter for the specified
     *   locale, which formats numbers with locale-specific grouping separators, decimal points, and digit conventions.
     * - Useful for displaying numeric values in a way that respects regional formatting rules, such as commas or
     *   periods for thousands and decimal separators.
     * - Supports formatting of integers and decimals, with automatic rounding according to locale conventions.
     * - Can be customized further by setting maximum and minimum fraction digits or using subclasses like
     *   DecimalFormat.
     * - Output: 1,000.5
     */
    NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
    IO.println(formatter.format(1000.50));

    /*
     * Integer
     * - The "getIntegerInstance" method of NumberFormat returns a number formatter that formats numeric values as
     *   integers, rounding them according to the locale-specific rules and omitting any fractional digits.
     * - Useful when you need to display whole numbers only, regardless of the original value’s decimals.
     * - Automatically applies grouping separators (like commas or periods) based on the locale.
     * - Can be combined with locale-aware formatting for consistent display in internationalized applications.
     * - Output: 1,000
     */
    formatter = NumberFormat.getIntegerInstance(Locale.US);
    IO.println(formatter.format(1000.50));

    /*
     * Currency
     * - The "getCurrencyInstance" method of NumberFormat returns a number formatter specialized for currency values,
     *   using the locale-specific currency symbol, placement, and formatting conventions.
     * - Useful for displaying monetary amounts in a way that respects regional standards, including proper use of
     *   decimal and grouping separators.
     * - Automatically rounds values according to the locale’s currency precision (typically two decimal places).
     * - Can be combined with different locales to display amounts in local currencies (e.g., USD, EUR, BRL).
     * - Output: $1,000.50
     */
    formatter = NumberFormat.getCurrencyInstance(Locale.US);
    IO.println(formatter.format(1000.50));

    /*
     * Percent
     * - The "getPercentInstance" method of NumberFormat returns a formatter specialized for percentages, multiplying
     *   the numeric value by 100 and appending the locale-specific percent symbol.
     * - Useful for displaying fractional values as percentages in a user-friendly, locale-aware format.
     * - Automatically applies grouping separators and rounds values according to locale conventions.
     * - Can be customized with minimum and maximum fraction digits if more precision is needed.
     * - Output: 55%
     */
    formatter = NumberFormat.getPercentInstance(Locale.US);
    IO.println(formatter.format(0.55));

    /*
     * Compact Short
     * - The "getCompactNumberInstance" method of NumberFormat with Style.SHORT returns a formatter that displays
     *   numbers in a compact, abbreviated form suitable for the specified locale (e.g., 1K, 12M).
     * - Useful for presenting large numbers in a concise, readable way in user interfaces, dashboards, or reports.
     * - Automatically applies locale-specific abbreviations for thousands, millions, and beyond.
     * - Supports both integers and decimals, rounding values according to locale conventions.
     * - Output: 1K
     */
    formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
    IO.println(formatter.format(1000));

    /*
     * Compact Long
     * - The "getCompactNumberInstance" method of NumberFormat with Style.LONG returns a formatter that displays numbers
     *   in a compact, full-text form suitable for the specified locale (e.g., 1 thousand, 12 million).
     * - Useful for presenting large numbers in a readable, human-friendly way in reports, documents, or interfaces
     *   where clarity is more important than brevity.
     * - Automatically applies locale-specific full-word abbreviations for thousands, millions, and larger numbers.
     * - Supports both integers and decimals, rounding values according to locale conventions.
     * - Output: 1 thousand
     */
    formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
    IO.println(formatter.format(1000));
}