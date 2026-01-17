/*
 * Regular Expressions
 * - This section explains the use of Regular Expressions (regex) in Java, which provide a powerful way to search,
 *   match, and manipulate text patterns efficiently.
 *
 * Overview
 * - Regex in Java is handled primarily through the java.util.regex package, using the Pattern and Matcher classes.
 * - The Pattern class represents a compiled regex, while the Matcher class applies the pattern to input text.
 * - Supports standard regex features including quantifiers, character classes, alternation, groups, and named groups.
 * - Enables both simple string matching and complex parsing operations.
 *
 * Key Characteristics
 * - Patterns are compiled once via Pattern.compile and can be reused across multiple Matcher instances.
 * - Supports capturing groups, both numbered and named, to extract parts of matched text.
 * - Provides methods for finding matches (find), checking full matches (matches), and retrieving group positions
 *   (start/end).
 * - Integrates with string replacement (replaceAll, replaceFirst) and splitting (split) operations.
 * - Offers flags for case-insensitive matching, multiline handling, and "dot all" mode for flexible text processing.
 *
 * Usage
 * - Use regex to validate input, parse structured text, extract data, or perform complex search and replace operations.
 * - Ideal for processing logs, configuration files, user input, URLs, dates, emails, and other text patterns.
 * - Combine Pattern and Matcher for iterative searches, group extraction, and position-based processing.
 * - Named groups improve readability and maintainability when dealing with multiple capturing groups.
 */
void main() {
    //==================================================================================================================
    // Components
    //==================================================================================================================

    /*
     * Pattern
     * - Represents a compiled regular expression in Java using the Pattern class from java.util.regex.
     * - Can include optional flags such as CASE_INSENSITIVE, MULTILINE, or DOTALL to modify matching behavior.
     * - Once compiled, the Pattern can be reused to create multiple Matcher instances for efficient matching.
     * - Output: \d+
     */
    Pattern pattern = Pattern.compile("\\d+");
    IO.println(pattern);

    /*
     * Matcher
     * - Applies a compiled Pattern to a given input string to perform regex matching operations.
     * - Provides methods like find(), matches(), group(), start(), and end() to locate and extract matches.
     * - Can handle both numbered and named capturing groups for more structured text parsing.
     * - Output: java.util.regex.Matcher[pattern=\d+ region=0,3 lastmatch=]
     */
    Matcher matcher = pattern.matcher("123");
    IO.println(matcher);

    //==================================================================================================================
    // Simplified Usage (Pattern.matches())
    //==================================================================================================================

    /*
     * Simplified Pattern Match
     * - Uses the static Pattern.matches() method to check if the entire input string matches the given regular
     *   expression.
     * - Convenient for simple validation tasks without explicitly creating Pattern and Matcher objects.
     * - Note: Pattern.matches() attempts to match the entire string, not just a substring.
     * - Note: Equivalent to calling str.matches(regex) on a String.
     * - Output: true for "123", false for "ABC"
     */
    String regex = "\\d+";
    IO.println(Pattern.matches(regex, "123")); // Output: true
    IO.println(Pattern.matches(regex, "ABC")); // Output: false

    //==================================================================================================================
    // Full Usage (Matcher Object)
    //==================================================================================================================

    /*
     * Matches
     * - Uses the Matcher.matches() method to check if the entire input string matches the compiled pattern.
     * - Provides a more robust and flexible approach than Pattern.matches(), as it allows reuse of the Matcher object
     *   for multiple operations such as find(), group(), start(), end(), and handling of capturing groups.
     * - Ideal for scenarios where you need repeated matching, partial matches, or access to match positions and groups.
     * - Output: true
     */
    pattern = Pattern.compile("[A-Z]+");
    matcher = pattern.matcher("ABC");
    IO.println(matcher.matches());

    /*
     * Find
     * - Uses the Matcher.find() method to locate successive substrings that match the pattern within the input.
     * - Unlike matches(), find() performs partial matching and can return multiple results from the same input.
     * - The group() method returns the text matched by the entire pattern for the current find operation.
     * - group(0) is equivalent to group() and represents the full match; higher indices are used for capturing groups.
     * - Output: ABC | DEF | GHI
     */
    pattern = Pattern.compile("[A-Z]+");
    matcher = pattern.matcher("ABC DEF GHI");
    while(matcher.find()) {
        IO.println(matcher.group());
    }

    /*
     * Indexes
     * - Uses the Matcher.start() and Matcher.end() methods to obtain the position of each match in the input string.
     * - start() returns the zero-based index where the current match begins (inclusive).
     * - end() returns the index immediately after the last matched character (exclusive).
     * - These indexes are useful for substring extraction, highlighting matches, or advanced text processing.
     * - Output: 0-3 | 4-7 | 8-11
     */
    pattern = Pattern.compile("[A-Z]+");
    matcher = pattern.matcher("ABC DEF GHI");
    while(matcher.find()) {
        IO.println(matcher.start() + "-" + matcher.end());
    }

    /*
     * Groups
     * - Groups are defined using parentheses in a regular expression to capture specific parts of a match.
     * - Each group can be accessed by its index using group(n), where n starts at 1 for the first capturing group.
     * - group(0) is a special group that always represents the entire substring matched by the pattern.
     * - Groups are commonly used to extract structured data such as dates, identifiers, or components of a string.
     */
    pattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
    matcher = pattern.matcher("2000-01-15");
    if (matcher.find()) {
        IO.println(matcher.group(0)); // Output: 2000-01-15 (Group 0 is always the entire match)
        IO.println(matcher.group(1)); // Output: 2000
        IO.println(matcher.group(2)); // Output: 01
        IO.println(matcher.group(3)); // Output: 15
    }

    /*
     * Named Groups
     * - Named groups are capturing groups that are assigned a meaningful name instead of relying on numeric indexes.
     * - They improve readability and maintainability, especially in patterns with multiple capturing groups.
     * - Named groups are accessed using group("name") on the Matcher.
     * - group(0) still represents the entire substring matched by the pattern, even when named groups are used.
     * - Syntax: (?<groupName>regex)
     */
    pattern = Pattern.compile("(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})");
    matcher = pattern.matcher("2000-01-15");
    if (matcher.find()) {
        IO.println(matcher.group(0));       // Output: 2000-01-15 (Group 0 is always the entire match)
        IO.println(matcher.group("year"));  // Output: 2000
        IO.println(matcher.group("month")); // Output: 01
        IO.println(matcher.group("day"));   // Output: 15
    }

    //==================================================================================================================
    // Pattern Flags
    //==================================================================================================================

    /*
     * Case Insensitive Flag
     * - Uses the CASE_INSENSITIVE flag to ignore character case during pattern matching.
     * - Allows lowercase and uppercase characters to be treated as equivalent.
     * - Useful for user input validation or text matching where case should not matter.
     * - Output: true
     */
    pattern = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);
    matcher = pattern.matcher("ABC");
    IO.println(matcher.matches());

    /*
     * Multiline Flag
     * - Uses the MULTILINE flag to change the behavior of the ^ and $ anchors.
     * - With MULTILINE enabled, ^ matches the start of each line and $ matches the end of each line, instead of only
     *   the start and end of the entire input.
     * - Allows patterns to be applied line by line within multi-line text.
     * - Commonly used when processing logs, files, or user input containing line breaks.
     * - Output: ABC | DEF | GHI
     */
    pattern = Pattern.compile("^[A-Z]+$", Pattern.MULTILINE);
    matcher = pattern.matcher("ABC\nDEF\nGHI");
    while (matcher.find()) {
        IO.println(matcher.group());
    }

    /*
     * Dot All Flag
     * - Uses the DOTALL flag to allow the dot (.) meta-character to match newline characters.
     * - By default, the dot matches any character except line terminators.
     * - When DOTALL is enabled, the dot matches any character, including '\n'.
     * - Useful when processing multi-line text as a single continuous block.
     * - Output: true
     */
    pattern = Pattern.compile(".", Pattern.DOTALL);
    matcher = pattern.matcher("\n");
    IO.println(matcher.matches());
}