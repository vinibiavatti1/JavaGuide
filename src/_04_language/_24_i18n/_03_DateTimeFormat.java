/*
 * DateTimeFormatter
 * - This section explains the "DateTimeFormatter" class in Java, which provides locale-sensitive methods to format and
 *   parse date and time values, including LocalDateTime, LocalDate, LocalTime, and ZonedDateTime.
 *
 * Overview
 * - The "DateTimeFormatter" class is part of the java.time.format package.
 * - It allows dates and times to be formatted according to the conventions of a specific Locale.
 * - Supports predefined localized styles: SHORT, MEDIUM, LONG, and FULL, as well as custom patterns.
 * - Works directly with the java.time API (LocalDate, LocalTime, LocalDateTime, ZonedDateTime) without conversion.
 *
 * Key Characteristics
 * - Locale-sensitive: month names, day names, order of day/month/year, time formats, and AM/PM symbols adapt
 *   automatically.
 * - Supports formatting and parsing of date-only, time-only, or combined date-time values.
 * - Can handle time zones via ZonedDateTime, respecting localized zone names and offsets.
 * - Predefined FormatStyles: SHORT, MEDIUM, LONG, FULL, applied to date, time, or date-time.
 * - Offers flexibility for custom patterns with ofPattern(String) if specialized formatting is required.
 *
 * Format Styles
 * - SHORT: 1/21/26, 8:19 PM
 * - MEDIUM: Jan 21, 2026, 8:19:26 PM
 * - LONG: January 21, 2026, 8:19:26 PM WET
 * - FULL: Wednesday, January 21, 2026, 8:19:26 PM Western European Standard Time
 *
 * Usage
 * - Use DateTimeFormatter when displaying or parsing dates and times in a locale-aware manner.
 * - Ideal for internationalized applications, reports, logs, and user interfaces.
 * - Combine with ResourceBundle for fully localized date/time messages.
 */
void main() {
    //==================================================================================================================
    // Date Locale Formats
    //==================================================================================================================

    /*
     * Short Date
     * - Formats date only in a concise, locale-specific style.
     * - Useful for compact date displays in UIs or forms.
     * - Output: 1/21/26
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Medium Date
     * - Formats date in a medium-length, locale-specific style.
     * - Useful for clarity while maintaining brevity.
     * - Output: Jan 21, 2026
     */
    formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Long Date
     * - Formats date in a long, locale-specific style including month names.
     * - Useful for reports or user interfaces where clarity is needed.
     * - Output: January 21, 2026
     */
    formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Full Date
     * - Formats date including full day-of-week in a locale-specific style.
     * - Useful when maximum clarity and user readability is required.
     * - Output: Wednesday, January 21, 2026
     */
    formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    //==================================================================================================================
    // Time Locale Formats
    //==================================================================================================================

    /*
     * Short Time
     * - Formats time in a concise, locale-specific style.
     * - Useful for clocks, dashboards, or compact UI elements.
     * - Output: 8:19 PM
     */
    formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Medium Time
     * - Formats time in a medium-length, locale-specific style including seconds.
     * - Useful when more detail is required than SHORT style.
     * - Output: 8:19:26 PM
     */
    formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Long Time (ZonedDateTime)
     * - Formats time including short time zone notation.
     * - Useful for interfaces, reports, or logs where time zone information is relevant.
     * - Output: 8:19:26 PM WET
     */
    formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG).withLocale(Locale.US);
    IO.println(formatter.format(ZonedDateTime.now()));

    /*
     * Full Time (ZonedDateTime)
     * - Formats time including full time zone name.
     * - Useful for maximum clarity in applications requiring detailed temporal information.
     * - Output: 8:19:26 PM Western European Standard Time
     */
    formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.FULL).withLocale(Locale.US);
    IO.println(formatter.format(ZonedDateTime.now()));

    //==================================================================================================================
    // DateTime Locale Formats
    //==================================================================================================================

    /*
     * Short DateTime
     * - Formats date and time in a concise, locale-specific style suitable for compact display.
     * - Useful for quick date-time references where brevity is required.
     * - Output: 1/21/26, 8:19 PM
     */
    formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Medium DateTime
     * - Formats date and time in a medium-length, locale-specific style.
     * - Useful when more clarity is needed than SHORT, while still keeping the output compact.
     * - Output: Jan 21, 2026, 8:19:26 PM
     */
    formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(Locale.US);
    IO.println(formatter.format(LocalDateTime.now()));

    /*
     * Long DateTime (ZonedDateTime)
     * - Formats date and time including time zone information, in a long, locale-specific style.
     * - Useful for logs, reports, or interfaces where time zone clarity is important.
     * - Output: January 21, 2026, 8:19:26 PM WET
     */
    formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withLocale(Locale.US);
    IO.println(formatter.format(ZonedDateTime.now()));

    /*
     * Full DateTime (ZonedDateTime)
     * - Formats date and time including full day-of-week and full time zone name.
     * - Useful when maximum detail and clarity is required for end users.
     * - Output: Wednesday, January 21, 2026, 8:19:26 PM Western European Standard Time
     */
    formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.US);
    IO.println(formatter.format(ZonedDateTime.now()));
}
