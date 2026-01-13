/*
 * Dates in Java
 * - This section explains how Java handles dates and times, including the main classes, their purposes, and legacy
 *   alternatives.
 *
 * Overview
 * - Java provides a rich API for representing dates, times, and date-time combinations.
 * - Modern classes are found in the java.time package (introduced in Java 8) and are immutable, thread-safe, and easier
 *   to use than legacy classes.
 * - Key concepts include separating date, time, time zone, and offsets to handle various scenarios.
 *
 * Key Classes (Modern)
 * - LocalDate: Represents a date without time or time zone (e.g., 2026-01-06).
 * - LocalTime: Represents a time of day without date or time zone (e.g., 12:30:00).
 * - LocalDateTime: Combines LocalDate and LocalTime, still without time zone (e.g., 2026-01-06T12:30:00).
 * - OffsetDateTime: Represents date and time with an offset from UTC (e.g., 2026-01-06T12:30+02:00).
 * - ZonedDateTime: Represents date and time with a time zone (e.g., 2026-01-06T12:30-03:00[America/Sao_Paulo]).
 * - Instant: Represents a moment on the timeline in UTC (useful for timestamps).
 * - Duration: Represents a time-based amount of time (e.g., hours, minutes, seconds).
 * - Period: Represents a date-based amount of time (e.g., years, months, days).
 * - DateTimeFormatter: Provides formatting and parsing for date-time objects.
 *
 * Legacy Classes (java.util / java.sql)
 * - Date: Represents a specific instant in time, including date and time. Often combined with Calendar for manipulation
 * - Calendar: Provides richer functionality for date arithmetic and field-based access (e.g., year, month, day), but
 *   mutable and error-prone.
 * - GregorianCalendar: A concrete subclass of Calendar implementing the standard calendar system.
 * - java.sql.Date, Time, Timestamp: Used primarily for database interactions.
 *
 * Usage
 * - Prefer java.time classes for new code due to immutability, better API design, and easier handling of time zones.
 * - Use legacy classes only when interacting with older APIs or databases that require them.
 * - Convert between legacy and modern classes via Instant, Date.from(), and Date.toInstant() when necessary.
 */
void main() {
    //==================================================================================================================
    // Date/Time types
    //==================================================================================================================

    /*
     * LocalDate
     * - Represents a date without time or time zone (e.g., 2026-01-06).
     * - Output: 2026-01-06
     */
    LocalDate date = LocalDate.of(2026, 1, 6);
    IO.println(date);

    /*
     * LocalTime
     * - Represents a time of day without date or time zone (e.g., 12:30:00).
     * - Output: 12:30
     */
    LocalTime time = LocalTime.of(12, 30, 0);
    IO.println(time);

    /*
     * LocalDateTime
     * - Combines LocalDate and LocalTime, still without time zone (e.g., 2026-01-06T12:30:00).
     * - Output: 2026-01-06T12:30
     */
    LocalDateTime dateTime = LocalDateTime.of(2026, 1, 6, 12, 30, 0);
    IO.println(dateTime);

    /*
     * OffsetDateTime
     * - Represents date and time with an offset from UTC (e.g., 2026-01-06T12:30+02:00).
     * - Output: 2026-01-06T12:30Z
     */
    OffsetDateTime offset = OffsetDateTime.of(LocalDateTime.of(2026, 1, 6, 12, 30, 0), ZoneOffset.UTC);
    IO.println(offset);

    /*
     * ZonedDateTime
     * - Represents date and time with a time zone (e.g., 2026-01-06T12:30-03:00[America/Sao_Paulo]).
     * - Output: 2026-01-06T12:30-03:00[America/Sao_Paulo]
     */
    ZonedDateTime zoned = ZonedDateTime.of(LocalDateTime.of(2026, 1, 6, 12, 30, 0), ZoneId.of("America/Sao_Paulo"));
    IO.println(zoned);

    //==================================================================================================================
    // Date/Time Representations
    //==================================================================================================================

    /*
     * Instant
     * - Represents a moment on the timeline in UTC (useful for timestamps).
     * - Output: 2026-01-06T21:48:18.902141900Z
     */
    Instant instant = Instant.now();
    IO.println(instant);

    /*
     * Duration
     * - Represents a time-based amount of time (e.g., hours, minutes, seconds).
     * - Output: PT240H
     */
    Duration duration = Duration.of(10, ChronoUnit.DAYS);
    IO.println(duration);

    /*
     * Period
     * - Represents a date-based amount of time (e.g., years, months, days).
     * - Output: P1Y
     */
    Period period = Period.between(LocalDate.of(2025, 1, 6), LocalDate.of(2026, 1, 6));
    IO.println(period);

    /*
     * DateTimeFormatter
     * - Provides formatting and parsing for date-time objects.
     * - Output: 06/01/2025
     */
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    IO.println(LocalDate.of(2025, 1, 6).format(format));
}