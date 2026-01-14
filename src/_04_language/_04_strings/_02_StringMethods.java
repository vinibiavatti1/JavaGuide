/*
 * String Methods
 * - This section explains the methods provided by the "String" class to manipulate, inspect, and transform textual
 *   data.
 *
 * Overview
 * - Strings provide a wide range of methods for searching, comparing, formatting, and converting text.
 * - All modification methods return new string instances because strings are immutable.
 * - Supports both simple character-based and Unicode code point–aware operations.
 *
 * Key Characteristics
 * - Index-based operations work on UTF-16 code units ("char"), not necessarily on user-perceived characters.
 * - Immutable nature ensures thread safety and predictable behavior.
 * - Includes methods such as "length()", "charAt()", "substring()", "equals()", "compareTo()", "contains()", and
 *   "replace()".
 *
 * Usage
 * - Use string methods to inspect content, perform comparisons, or extract substrings.
 * - Combine multiple methods to transform or validate textual data.
 * - Be aware of immutability when performing repetitive modifications; consider "StringBuilder" for efficiency.
 */
void main() {
    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /*
     * Value Of
     * - Returns the string representation of the given argument.
     * - Has overloads for all primitive types, objects, and even char arrays.
     * - Output: 3.14 (as string)
     */
    String x = String.valueOf(3.14);
    IO.println(x);

    /*
     * Join
     * - Returns a new String composed of copies of the CharSequence elements joined together with the specified
     *   delimiter.
     * - Can accept either a varargs of CharSequence or an Iterable (e.g., List<String>).
     * - Output: A, B, C
     */
    x = String.join(", ", "A", "B", "C");
    IO.println(x);

    /*
     * Format
     * - Returns a formatted string using the specified format string and arguments.
     * - Supports multiple overloads, including optional Locale specification.
     * - Useful for creating strings with dynamic values in a controlled format.
     * - Output: Hello, John! You have 3 messages.
     */
    String template = "Hello, %s! You have %d messages.";
    x = String.format(template, "John", 3);
    IO.println(x);

    //==================================================================================================================
    // Length
    //==================================================================================================================

    /*
     * Get String Length
     * - The length() method returns the number of Unicode code units in a string.
     * - Works correctly with all characters, including ASCII and Unicode.
     * - Output: 11
     */
    x = "Hello World";
    IO.println(x.length());

    //==================================================================================================================
    // Index Operations
    //==================================================================================================================

    /*
     * Get Character at Index
     * - The "charAt(index)" method returns the character at the specified zero-based index in the string.
     * - Index must be between 0 and length()-1, otherwise it throws StringIndexOutOfBoundsException.
     * - Output: W
     */
    x = "Hello World";
    IO.println(x.charAt(6));

    /*
     * Get Index
     * - Returns the index of the first occurrence of the specified character or substring.
     * - The fromIndex and endIndex are optional parameters to specify the start (inclusive) and end (exclusive) of the
     *   search range.
     * - If not found, returns -1.
     * - Output: 6
     */
    x = "Hello World";
    IO.println(x.indexOf("W"));

    /*
     * Get Last Index
     * - Returns the index of the last occurrence of the specified character or substring, searching backward.
     * - The fromIndex and endIndex are optional parameters to define the search range (fromIndex inclusive, endIndex
     *   exclusive).
     * - If not found, returns -1.
     * - Output: 9
     */
    x = "Hello World";
    IO.println(x.lastIndexOf("l"));

    //==================================================================================================================
    // Transformation
    //==================================================================================================================

    /*
     * Concat
     * - Concatenates the specified string to the end of this string.
     * - The argument string is required; no optional parameters.
     * - Output: Hello World
     */
    x = "Hello ";
    IO.println(x.concat("World"));

    /*
     * Trim
     * - Returns a string with all leading and trailing whitespace removed.
     * - Whitespace is defined as any character with a codepoint <= U+0020 (space, tab, newline, carriage return, etc.).
     * - Output: Hello World
     */
    x = " Hello World ";
    IO.println(x.trim());

    /*
     * Strip
     * - Returns a string with all leading and trailing Unicode whitespace removed.
     * - Removes any character classified as whitespace by Character.isWhitespace(...).
     * - Related methods: stripLeading() removes only leading whitespace, stripTrailing() removes only trailing
     *   whitespace.
     * - Output: Hello World
     */
    x = "  Hello World  ";
    IO.println(x.strip());

    /*
     * Lower Case
     * - Converts all characters in the string to lower case.
     * - To specify a locale, use toLowerCase(Locale), otherwise the default locale will be used.
     * - Output: hello world
     */
    x = "Hello World";
    IO.println(x.toLowerCase());

    /*
     * Upper Case
     * - Converts all characters in the string to upper case.
     * - To specify a locale, use toUpperCase(Locale), otherwise the default locale will be used.
     * - Output: HELLO WORLD
     */
    x = "Hello World";
    IO.println(x.toUpperCase());

    /*
     * Repeat
     * - Returns a string that is the concatenation of this string repeated count times.
     * - Output: Hello Hello Hello
     */
    x = "Hello ";
    IO.println(x.repeat(3));

    /*
     * Replace
     * - Returns a new string resulting from replacing all occurrences of a target character or substring with a
     *   replacement.
     * - Output: Hi World
     */
    x = "Hello World";
    IO.println(x.replace("Hello", "Hi"));

    /*
     * Replace All (Regex)
     * - Returns a new string where each substring matching the given regular expression is replaced with the specified
     *   replacement.
     * - This method uses regular expressions (regex) for matching, so special regex characters in the pattern must be
     *   escaped if needed.
     * - Output: Hi
     */
    x = "Hello";
    IO.println(x.replaceAll("[a-z]+", "i"));

    /*
     * Replace First (Regex)
     * - Returns a new string where the first substring matching the given regular expression is replaced with the
     *   specified replacement.
     * - This method uses regular expressions (regex) for matching, so special regex characters in the pattern must be
     *   escaped if needed.
     * - Output: Hi Hello
     */
    x = "Hello Hello";
    IO.println(x.replaceFirst("[a-z]+", "i"));

    /*
     * Substring
     * - Returns a new string that is a substring of this string.
     * - The beginIndex (inclusive) and endIndex (exclusive) specify the range to extract.
     * - Output: World
     */
    x = "Hello World";
    IO.println(x.substring(6, 11));

    /*
     * Split
     * - Splits this string around matches of the given regular expression.
     * - This method uses regular expressions (regex) for matching, so special regex characters must be escaped if
     *   needed.
     * - An optional limit parameter can be specified to control the number of resulting substrings.
     * - Output: [A, B, C]
     */
    x = "A,B,C";
    String[] parts = x.split(",");
    IO.println(Arrays.toString(parts));

    //==================================================================================================================
    // Equality and Matching
    //==================================================================================================================

    /*
     * Equals
     * - Compares this string to the specified object for equality.
     * - Related method: equalsIgnoreCase(...) compares ignoring case differences.
     * - Output: true
     */
    String a = "Hello World";
    String b = "Hello World";
    IO.println(a.equals(b));

    /*
     * Compare
     * - Compares two strings lexicographically based on the Unicode value of each character.
     * - Related method: compareToIgnoreCase(...) compares strings ignoring case differences.
     * - Output: 0 (equal)
     */
    a = "Hello World";
    b = "Hello World";
    IO.println(a.compareTo(b));

    /*
     * Contains
     * - Returns true if this string contains the specified sequence of characters.
     * - Output: true
     */
    a = "Hello World";
    b = "Hello World";
    IO.println(a.contains(b));

    /*
     * Starts With
     * - Tests if this string starts with the specified prefix.
     * - Optional: an offset can be specified to start checking from a specific index.
     * - Output: true
     */
    a = "Hello World";
    b = "Hello";
    IO.println(a.startsWith(b));

    /*
     * Ends With
     * - Tests if this string ends with the specified suffix.
     * - Output: true
     */
    a = "Hello World";
    b = "World";
    IO.println(a.endsWith(b));

    /*
     * Is Blank
     * - Returns true if the string is empty or contains only whitespace codepoints.
     * - Output: true
     */
    x = " ";
    IO.println(x.isBlank());

    /*
     * Is Empty
     * - Returns true if, and only if, length() is 0.
     * - Output: true
     */
    x = "";
    IO.println(x.isEmpty());

    /*
     * Matches
     * - Returns true if this string matches the given regular expression.
     * - This method uses regular expressions (regex) for matching.
     * - Output: true
     */
    x = "Hello World";
    IO.println(x.matches("[a-zA-Z ]*"));

    /*
     * Hash Code
     * - Returns a hash code value for this string, computed from its characters.
     * - Useful for hash-based collections like HashMap or HashSet.
     * - Output: -862545276
     */
    x = "Hello World";
    IO.println(x.hashCode());

    //==================================================================================================================
    // Formatting
    //==================================================================================================================

    /*
     * Formatted
     * - Returns a formatted string using this string as the format template and the supplied arguments.
     * - Works like String.format(...) but called directly on the string instance.
     * - The arguments must match the format specifiers in the string.
     * - Output: Hello, John! You have 3 messages.
     */
    x = "Hello, %s! You have %d messages.";
    IO.println(x.formatted("John", 3));

    //==================================================================================================================
    // Array Conversion
    //==================================================================================================================

    /*
     * To Char Array
     * - Converts this string into a new character array.
     * - Useful for processing individual characters directly.
     * - Output: [A, B, C]
     */
    x = "ABC";
    IO.println(Arrays.toString(x.toCharArray()));

    /*
     * Get Bytes
     * - Encodes this string into a sequence of bytes using the platform's default charset.
     * - An optional charset can be specified for explicit encoding, e.g., getBytes(StandardCharsets.UTF_8).
     * - Useful for I/O operations or byte-level processing.
     * - Output: 72 | 101 | 108 | 108 | 111 | 32 | 87 | 111 | 114 | 108 | 100
     */
    x = "Hello World";
    IO.println(Arrays.toString(x.getBytes()));

    //==================================================================================================================
    // Stream
    //==================================================================================================================

    /*
     * Chars
     * - Returns an IntStream of the characters in this string, where each char is zero-extended to an int.
     * - Useful for processing or mapping characters as their Unicode code points.
     * - Output: 72 | 101 | 108 | 108 | 111 | 32 | 87 | 111 | 114 | 108 | 100
     */
    x = "Hello World";
    IntStream charsStream = x.chars();
    charsStream.forEach(IO::println);

    /*
     * Lines
     * - Returns a Stream of lines extracted from this string, separated by line terminators (\n, \r, \r\n).
     * - Useful for processing multi-line strings line by line.
     * - Output: Hello | World
     */
    x = "Hello\nWorld";
    Stream<String> linesStream = x.lines();
    linesStream.forEach(IO::println);

    //==================================================================================================================
    // Functional Operations
    //==================================================================================================================

    /*
     * Transform
     * - Applies the given function to this string and returns the result.
     * - The function should accept a single String argument and produce a result of any type (R).
     * - Useful for chaining operations on a string in a functional style.
     * - Output: HELLO WORLD
     */
    x = "Hello World";
    IO.println(x.transform(String::toUpperCase));
}