/*
 * LocalDateTime
 * - This section explains the LocalDateTime class in Java and how it represents a date and time without time-zone
 *   information.
 *
 * Overview
 * - LocalDateTime is part of the java.time package and represents both a date (year-month-day) and a time
 *   (hour-minute-second).
 * - It does not include time zone information, making it suitable for local date-time calculations.
 * - Provides immutability and thread-safety, ensuring reliable date-time manipulations.
 * - Supports operations such as addition, subtraction, comparison, and formatting.
 *
 * Key Characteristics
 * - Immutable: all modification methods return a new LocalDateTime instance.
 * - Provides methods to get individual components: getYear(), getMonthValue(), getDayOfMonth(), getHour(), getMinute(),
 *   getSecond().
 * - Supports comparisons via isBefore(), isAfter(), isEqual(), and compareTo().
 * - Can be converted to OffsetDateTime or ZonedDateTime for time-zone-aware operations.
 * - Provides parsing and formatting using DateTimeFormatter.
 *
 * Related Classes
 * - LocalDateTime: Represents both date and time without time zone. Use when both components are needed locally.
 * - LocalDate: Represents only the date (year-month-day) without time. Use when time information is not required.
 * - LocalTime: Represents only the time (hour-minute-second) without date. Use when only time-of-day calculations are
 *   needed.
 *
 * Usage
 * - Use LocalDateTime when you need to store or manipulate both date and time values locally.
 * - Can perform arithmetic operations like plusHours(), minusDays(), or with(ChronoField) to adjust specific parts of
 *   the date-time.
 * - Useful in combination with other java.time classes for conversions and formatting.
 */
void main() {
    //==================================================================================================================
    // Declaration
    //==================================================================================================================

    /*
     * Declare Specific DateTime
     * - The "LocalDateTime.of" method creates a date-time using explicit year, month, day, hour, minute, and second
     *   values.
     * - The month is 1-based (January = 1), and the day, hour, minute, and second must be valid for their respective
     *   ranges.
     * - Output: 2026-01-06T12:30:00
     */
    LocalDateTime dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime);

    /*
     * Declare Current DateTime
     * - The "LocalDateTime.now" method obtains the current date and time from the system clock using the default
     *   time-zone.
     * - The returned value represents the date-time at execution time.
     * - Output: current date-time
     */
    dateTime = LocalDateTime.now();
    IO.println(dateTime);

    //==================================================================================================================
    // Parse / Format
    //==================================================================================================================

    /*
     * Parse
     * - The "LocalDateTime.parse" method converts a string to a LocalDateTime using a specified DateTimeFormatter
     *   pattern.
     * - If no formatter is provided, LocalDateTime.parse expects the string in the ISO_LOCAL_DATE_TIME format
     *   ("yyyy-MM-dd'T'HH:mm:ss").
     * - If the input string does not match the expected format, a DateTimeParseException is thrown.
     * - Output: 2026-01-06T12:30
     */
    dateTime = LocalDateTime.parse("06/01/2026 12:30:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    IO.println(dateTime);

    /*
     * Format
     * - The "format" method converts a LocalDateTime into a string using a specified DateTimeFormatter pattern.
     * - You can include both date and time components.
     * - Output: 06/01/2026 12:30:00
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

    //==================================================================================================================
    // Convert
    //==================================================================================================================

    /*
     * Convert to LocalDate
     * - The "toLocalDate" method extracts the date part from a LocalDateTime, returning a LocalDate.
     * - Useful when only the calendar date is needed without the time.
     * - Output: 2026-01-06
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.toLocalDate());

    /*
     * Convert to LocalTime
     * - The "toLocalTime" method extracts the time part from a LocalDateTime, returning a LocalTime.
     * - Useful when only the time of day is needed without the date.
     * - Output: 12:30
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.toLocalTime());

    /*
     * Convert to OffsetDateTime
     * - The "atOffset" method adds a ZoneOffset to a LocalDateTime, producing an OffsetDateTime.
     * - The OffsetDateTime represents the date and time with a specific offset from UTC.
     * - Output: 2026-01-06T12:30+00:00
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.atOffset(ZoneOffset.UTC));

    /*
     * Convert to ZonedDateTime
     * - The "atZone" method combines a LocalDateTime with a ZoneId, producing a ZonedDateTime.
     * - The ZonedDateTime represents the date and time with a specific time zone, including any daylight saving rules.
     * - Output: 2026-01-06T12:30-03:00[America/Sao_Paulo]
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.atZone(ZoneId.of("America/Sao_Paulo")));

    /*
     * Convert to Instant
     * - The "toInstant" method converts a LocalDateTime to an Instant using a specified ZoneOffset.
     * - An Instant represents a point on the UTC timeline and retains both seconds and nanoseconds,
     *   providing more detailed information about the date-time.
     * - Useful for APIs and precise date-time calculations.
     * - Output: 2026-01-06T12:30:00Z
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.toInstant(ZoneOffset.UTC));

    /*
     * Convert to Timestamp
     * - The "toEpochSecond" method converts a LocalDateTime directly to a timestamp (seconds since
     *   1970-01-01T00:00:00Z) using a specified ZoneOffset.
     * - Returns a simple numeric value ideal for storing in databases or for quick comparisons.
     * - Output: 1767772200
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.toEpochSecond(ZoneOffset.UTC));

    //==================================================================================================================
    // Elements
    //==================================================================================================================

    /*
     * Get
     * - The "get" method retrieves specific values from a LocalDateTime using ChronoField constants.
     * - YEAR, MONTH_OF_YEAR, and DAY_OF_MONTH return date components; HOUR_OF_DAY, MINUTE_OF_HOUR, and SECOND_OF_MINUTE
     *   return time components.
     * - Useful for extracting individual parts of the date-time for calculations or display.
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 45);
    IO.println(dateTime.get(ChronoField.YEAR));             // 2026
    IO.println(dateTime.get(ChronoField.MONTH_OF_YEAR));    // 1
    IO.println(dateTime.get(ChronoField.DAY_OF_MONTH));     // 6
    IO.println(dateTime.get(ChronoField.HOUR_OF_DAY));      // 12
    IO.println(dateTime.get(ChronoField.MINUTE_OF_HOUR));   // 30
    IO.println(dateTime.get(ChronoField.SECOND_OF_MINUTE)); // 45

    //==================================================================================================================
    // Arithmetic Operations
    //==================================================================================================================

    /*
     * Minus
     * - The "minus" method subtracts a specified amount of time from the LocalDateTime using a ChronoUnit.
     * - ChronoUnit can be DAYS, WEEKS, MONTHS, YEARS, HOURS, MINUTES, SECONDS, etc., allowing flexible date-time
     *   arithmetic.
     * - The original LocalDateTime is immutable; minus() returns a new LocalDateTime with the adjustment applied.
     * - Output: 2025-10-06T12:30
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.minus(3, ChronoUnit.MONTHS));

    /*
     * Plus
     * - The "plus" method adds a specified amount of time to the LocalDateTime using a ChronoUnit.
     * - ChronoUnit can be DAYS, WEEKS, MONTHS, YEARS, HOURS, MINUTES, SECONDS, etc.
     * - The original LocalDateTime is immutable; plus() returns a new LocalDateTime with the adjustment applied.
     * - Output: 2026-04-06T12:30
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.plus(3, ChronoUnit.MONTHS));

    //==================================================================================================================
    // Mutation
    //==================================================================================================================

    /*
     * With
     * - The "with" method returns a copy of the LocalDateTime with one field changed to a new value.
     * - ChronoField constants like YEAR, MONTH_OF_YEAR, DAY_OF_MONTH, HOUR_OF_DAY, MINUTE_OF_HOUR can adjust specific
     *   parts of the date-time.
     * - The original LocalDateTime is immutable; with() returns a new instance with the updated field.
     * - Output: 2026-12-06T12:30
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.with(ChronoField.MONTH_OF_YEAR, 12));

    //==================================================================================================================
    // Comparison
    //==================================================================================================================

    /*
     * Is Before
     * - The "isBefore" method checks if the current LocalDateTime comes before the specified LocalDateTime.
     * - Returns true if the date-time is earlier, false otherwise.
     * - Useful for comparisons and validations.
     * - Output: true
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.isBefore(LocalDateTime.of(2026, 1, 7, 12, 30, 0)));

    /*
     * Is After
     * - The "isAfter" method checks if the current LocalDateTime comes after the specified LocalDateTime.
     * - Returns true if the date-time is later, false otherwise.
     * - Useful for comparisons and validations.
     * - Output: true
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.isAfter(LocalDateTime.of(2026, 1, 5, 12, 30, 0)));

    /*
     * Is Equal
     * - The "isEqual" method checks if the current LocalDateTime is exactly equal to the specified LocalDateTime.
     * - Returns true if both date and time components match; false otherwise.
     * - Useful for precise comparisons.
     * - Output: true
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.isEqual(LocalDateTime.of(2026, 1, 6, 12, 30, 0)));

    /*
     * Compare To
     * - The "compareTo" method compares the current LocalDateTime with another LocalDateTime.
     * - Returns a negative number if this date-time is before the other, zero if equal, and a positive number if after.
     * - Useful for sorting or ordering date-times.
     * - Output: 0 (equal)
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.compareTo(LocalDateTime.of(2026, 1, 6, 12, 30, 0)));

    //==================================================================================================================
    // Equality
    //==================================================================================================================

    /*
     * Equals
     * - The "equals" method checks if the current LocalDateTime is equal to another object.
     * - Returns true if the other object is a LocalDateTime with the same date and time components; false otherwise.
     * - Note: Unlike isEqual, equals requires the other object to be a LocalDateTime, not just any temporal object.
     * - Output: true
     */
    dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime.equals(LocalDateTime.of(2026, 1, 6, 12, 30, 0)));
}