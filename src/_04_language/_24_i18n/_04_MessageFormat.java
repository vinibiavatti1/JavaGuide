/*
 * MessageFormat
 * - This section explains the "MessageFormat" class in Java, which provides locale-sensitive methods to format messages
 *   with placeholders, allowing insertion of numbers, dates, times, and other objects into strings.
 *
 * Overview
 * - The "MessageFormat" class is part of the java.text package.
 * - Supports formatting messages with one or more placeholders, identified by {0}, {1}, etc.
 * - Can combine with NumberFormat, DateTimeFormatter, and other formatters for locale-aware output.
 * - Useful for internationalized applications where message content and numeric/date formatting must respect locale.
 *
 * Key Characteristics
 * - Supports simple placeholders {0}, {1}, ... and more advanced formatting patterns.
 * - Works with Object arrays or varargs for multiple parameters.
 * - Locale-aware: automatically formats numbers, dates, and currencies if formatters are used.
 * - Can be instantiated as an object (MessageFormat formatter) or used statically (MessageFormat.format()).
 *
 * Usage
 * - Use MessageFormat to build strings with dynamic content in a consistent, locale-aware manner.
 * - Ideal for UI messages, logs, reports, or any situation where variable content must be inserted in text.
 * - Combine with ResourceBundle for fully internationalized messages.
 */
void main() {
    //==================================================================================================================
    // Format Message
    //==================================================================================================================

    /*
     * Format Message
     * - Formats a simple message by replacing a single placeholder {0} with the given argument.
     * - Useful for dynamic messages with a single variable.
     * - Output: Welcome John!
     */
    String message = MessageFormat.format("Welcome {0}!", "John");
    IO.println(message);

    /*
     * Format Message With Multiple Parameters
     * - Formats a message containing multiple placeholders {0}, {1}, etc., replacing each with the corresponding
     *   argument.
     * - Useful when a message requires multiple dynamic values.
     * - Output: Welcome John, you have 15 messages
     */
    message = MessageFormat.format("Welcome {0}, you have {1} messages", "John", 15);
    IO.println(message);

    //==================================================================================================================
    // Format Message Using Formatters
    //==================================================================================================================

    /*
     * Format Message With Number
     * - Combines MessageFormat with NumberFormat to produce locale-aware numeric formatting inside a message.
     * - Useful for currency or other numeric output in messages.
     * - Output: Total price: $1,500.00
     */
    NumberFormat numberFormatter = NumberFormat.getCurrencyInstance(Locale.US);
    message = MessageFormat.format("Total price: {0}", numberFormatter.format(1500));
    IO.println(message);

    /*
     * Format Message With Date
     * - Combines MessageFormat with DateTimeFormatter to insert a formatted date into a message.
     * - Useful for displaying dates in a locale-aware format.
     * - Output: Current date: 1/21/26
     */
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);
    message = MessageFormat.format("Current date: {0}", dateTimeFormatter.format(LocalDateTime.now()));
    IO.println(message);

    /*
     * Format Message With Time
     * - Combines MessageFormat with DateTimeFormatter to insert a formatted time into a message.
     * - Useful for displaying times in a locale-aware format.
     * - Output: Current time: 8:53 PM
     */
    dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.US);
    message = MessageFormat.format("Current time: {0}", dateTimeFormatter.format(LocalDateTime.now()));
    IO.println(message);

    /*
     * Format Message With DateTime
     * - Combines MessageFormat with DateTimeFormatter to insert a full date-time value into a message.
     * - Useful for displaying both date and time in a locale-aware format.
     * - Output: Current datetime: 1/21/26, 8:53 PM
     */
    dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US);
    message = MessageFormat.format("Current datetime: {0}", dateTimeFormatter.format(LocalDateTime.now()));
    IO.println(message);

    //==================================================================================================================
    // Instance
    //==================================================================================================================

    /*
     * Declare Instance
     * - Demonstrates creating a MessageFormat instance with a specific pattern and locale.
     * - Useful when the same format will be used multiple times with different arguments.
     */
    MessageFormat formatter = new MessageFormat("Welcome {0}!", Locale.US);
    IO.println(formatter.format(new Object[]{"John"})); // Output: Welcome John!
    IO.println(formatter.format(new Object[]{"Anna"})); // Output: Welcome Anna!
}
