/*
String Methods
- This section explains the methods provided by the "String" class to manipulate, inspect, and transform textual data.

Overview
- Strings provide a wide range of methods for searching, comparing, formatting, and converting text.
- All modification methods return new string instances because strings are immutable.
- Supports both simple character-based and Unicode code point–aware operations.

Key Characteristics
- Index-based operations work on UTF-16 code units ("char"), not necessarily on user-perceived characters.
- Immutable nature ensures thread safety and predictable behavior.
- Includes methods such as "length()", "charAt()", "substring()", "equals()", "compareTo()", "contains()", and
  "replace()".

Usage
- Use string methods to inspect content, perform comparisons, or extract substrings.
- Combine multiple methods to transform or validate textual data.
- Be aware of immutability when performing repetitive modifications; consider "StringBuilder" for efficiency.
*/
void main() {
    //==================================================================================================================
    // Length
    //==================================================================================================================

    /*
    Length
    - Returns the length of this string.
    - The length is equal to the number of Unicode code units in the string.
    - Output: 11
    */
    String x = "Hello World";
    IO.println(x.length());

    //==================================================================================================================
    // Character Access
    //==================================================================================================================

    /*
    Char At
    - Returns the char value at the specified index.
    - Output: W
    */
    x = "Hello World";
    IO.println(x.charAt(6));

    //==================================================================================================================
    // Search
    //==================================================================================================================

    /*
    Index Of
    - Returns the index within this string of the first occurrence of the specified character or string.
    - beginIndex – the index to start the search from (included).
    - endIndex – the index to stop the search at (excluded)
    - Output: 2 4
    */
    x = "A B A C";
    int i1 = x.indexOf("B");
    int i2 = x.indexOf("A", 2, 6);
    IO.println(i1 + " " + i2);

    /*
    Index Of (char / int)
    - Returns the index based on a UTF-16 char value.
    - Output: 2 4
    */
    x = "A B A C";
    i1 = x.indexOf(66);       // B
    i2 = x.indexOf(65, 2, 6); // A
    IO.println(i1 + " " + i2);

    /*
    Last Index Of
    - Returns the index within this string of the last occurrence of the specified substring searching backward starting
      at the specified index.
    - fromIndex – the index to start the search from
    - Output: 4 0
    */
    x = "A B A C";
    i1 = x.lastIndexOf("A");
    i2 = x.lastIndexOf("A", 3);
    IO.println(i1 + " " + i2);

    /*
    Last Index Of (char / int)
    - Returns the last index based on a UTF-16 char value.
    - Output: 4 0
    */
    x = "A B A C";
    i1 = x.lastIndexOf(65);    // A
    i2 = x.lastIndexOf(65, 3); // A
    IO.println(i1 + " " + i2);

    //==================================================================================================================
    // Transformation
    //==================================================================================================================

    /*
    Concat
    - Concatenates the specified string to the end of this string.
    - Output: Hello World
    */
    x = "Hello";
    IO.println(x.concat(" World"));

    /*
    Trim
    - Returns a string whose value is this string, with all leading and trailing space removed,
    - where space is defined as any character whose codepoint is less than or equal to 'U+0020' (the space character).
    - Characters: \t, \n, \r
    - Output: Hello World
    */
    x = "  Hello World  ";
    IO.println(x.trim());

    /*
    Strip
    - Returns a string with incidental white space removed
    - Removes any character classified as Unicode Whitespace: Character.isWhitespace(...)
    - Output: Hello World
    */
    x = "  Hello World  ";
    String y1 = x.strip();
    String y2 = x.stripLeading();
    String y3 = x.stripTrailing();
    IO.println(y1); // "Hello World"
    IO.println(y2); // "Hello World  "
    IO.println(y3); // "  Hello World"

    /*
    Strip Indent
    - Returns a with incidental white space removed from the beginning and end of every line.
    - Output: <html> | <body /> | </html>
    */
    x = """
        <html>
            <body />
        </html>
    """;
    IO.println(x.stripIndent());

    /*
    Lower Case
    - Converts all the characters in this String to lower case using the rules of the Locale.
    - Output: hello world / hello world
    */
    x = "Hello World";
    y1 = x.toLowerCase();
    y2 = x.toLowerCase(Locale.US);
    IO.println(y1 + " / " + y2);

    /*
    Upper Case
    - Converts all the characters in this String to upper case using the rules of the Locale.
    - Output: HELLO WORLD / HELLO WORLD
    */
    x = "Hello World";
    y1 = x.toUpperCase();
    y2 = x.toUpperCase(Locale.US);
    IO.println(y1 + " / " + y2);

    /*
    Repeat
    - Returns a string whose value is the concatenation of this string repeated count times.
    - Output: HelloHelloHello
    */
    x = "Hello";
    IO.println(x.repeat(3));

    /*
    Indent
    - Adjusts the indentation of each line of this string based on the value of n, and normalizes line termination
      characters.
    - Output: "    Hello" | "    World"
    */
    x = "Hello\nWorld";
    IO.println(x.indent(4));

    /*
    Translate Escapes
    - Returns a string with escape sequences translated as string literal.
    - Output: U+0009 U+000A
    */
    x = "\t \n";
    IO.println(x.translateEscapes());

    //==================================================================================================================
    // Format
    //==================================================================================================================

    /*
    Formatted
    - Formats using this string as the format string, and the supplied arguments.
    - Output: Hello, John! You have 3 messages.
    */
    x = "Hello, %s! You have %d messages.";
    IO.println(x.formatted("John", 3));

    //==================================================================================================================
    // Substrings
    //==================================================================================================================

    /*
    Substring
    - Returns a string that is a substring of this string.
    - Output: World / Wor
    */
    x = "Hello World";
    y1 = x.substring(6);
    y2 = x.substring(6, 9);
    IO.println(y1 + " / " + y2);

    //==================================================================================================================
    // Replacement
    //==================================================================================================================

    /*
    Replace
    - Returns a string resulting from replacing all occurrences of a character or substring.
    - Output: Hello World / Hello Workd
    */
    x = "Hekko Workd";
    y1 = x.replace('k', 'l');
    y2 = x.replace("kk", "ll");
    IO.println(y1 + " / " + y2);
    
    /*
    Replace All (Regex)
    - Replaces each substring of this string that matches the given regular expression with the given replacement.
    - Output: Hxxxx Wxxxx
    */
    x = "Hello World";
    IO.println(x.replaceAll("[a-z]", "x"));

    /*
    Replace First (Regex)
    - Replaces the first substring of this string that matches the given regular expression with the given replacement.
    - Output: Hxllo World
    */
    x = "Hello World";
    IO.println(x.replaceFirst("[a-z]", "x"));

    //==================================================================================================================
    // Equality and Matching
    //==================================================================================================================

    /*
    Equals
    - Compares this string to the specified object.
    - Output: true
    */
    x = "Hello World";
    IO.println(x.equals("Hello World"));

    /*
    Equals (Ignore Case)
    - Compares this String to another String, ignoring case considerations.
    - Output: true
    */
    x = "Hello World";
    IO.println(x.equalsIgnoreCase("hello world"));

    /*
    Is Blank
    - Returns true if the string is empty or contains only white space codepoints.
    - Output: true
    */
    x = "   ";
    IO.println(x.isBlank());

    /*
    Is Empty
    - Returns true if, and only if, length() is 0.
    - Output: true
    */
    x = "";
    IO.println(x.isEmpty());

    /*
    Contains
    - Returns true if and only if this string contains the specified sequence of char values.
    - Output: true
    */
    x = "Hello World";
    IO.println(x.contains("Wor"));

    /*
    Starts With
    - Tests if this string starts with the specified prefix.
    - We can specify an offse where to begin looking in this string.
    - Output: true true
    */
    x = "Hello World";
    boolean check1 = x.startsWith("Hello");
    boolean check2 = x.startsWith("World", 6);
    IO.println(check1 + " " + check2);

    /*
    Ends With
    - Tests if this string ends with the specified suffix.
    - Output: true
    */
    x = "Hello World";
    IO.println(x.endsWith("World"));

    /*
    Matches
    - Tells if this string matches the given regular expression.
    - Output: true
    */
    x = "Hello World";
    IO.println(x.matches("[a-zA-Z ]*"));

    /*
    Region Matches
    - Tests if two string regions are equal.
    - The code below is comparing: "B C" with "B C".
    - Note: This method operates on UTF-16 char units, not Unicode code points. It is not safe for characters outside
      the BMP (e.g. emojis).
    - Output: true true
    */
    x = "A B C D";
    check1 = x.regionMatches(2, "_ B C _", 2, 3);
    check2 = x.regionMatches(true, 2, "_ b c _", 2, 3); // Ignore Case
    IO.println(check1 + " " + check2);

    //==================================================================================================================
    // Comparison
    //==================================================================================================================

    /*
    Compare
    - Compares two strings lexicographically.
    - The comparison is based on the Unicode value of each character in the strings.
    - Output: 0 (equal)
    */
    x = "Hello World";
    IO.println(x.compareTo("Hello World"));

    /*
    Compare (Ignore Case)
    - Compares two strings lexicographically, ignoring case differences.
    - Output: 0 (equal)
    */
    x = "Hello World";
    IO.println(x.compareToIgnoreCase("hello world"));

    //==================================================================================================================
    // Splitting
    //==================================================================================================================

    /*
    Split
    - Splits this string around matches of the given regular expression.
    - Output: 0: A | 1: B | 2: C
    */
    x = "A,B,C";
    String[] parts = x.split(",");
    for (int i = 0; i < parts.length; i++) {
        IO.println(i + ": " + parts[i]);
    }

    /*
    Split (With Limit)
    - Splits this string around matches of the given regular expression.
    - The limit parameter controls the number of times the pattern is applied and therefore affects the length of the
      resulting array.
    - If limit is zero, the pattern will be applied as many times as possible.
    - Output: 0: A | 1: B | 2: C,D
    */
    x = "A,B,C,D";
    parts = x.split(",", 3);
    for (int i = 0; i < parts.length; i++) {
        IO.println(i + ": " + parts[i]);
    }

    /*
    Split With Delimiters
    - Splits this string around matches of the given regular expression and returns both the strings and the matching
      delimiters.
    - If limit is zero, the pattern will be applied as many times as possible.
    - Output: 0: A | 1: , | 2: B | 3: , | 4: C
    */
    x = "A,B,C";
    parts = x.splitWithDelimiters(",", 0);
    for (int i = 0; i < parts.length; i++) {
        IO.println(i + ": " + parts[i]);
    }

    //==================================================================================================================
    // Unicode and Code Points
    //==================================================================================================================

    /*
    Java String is UTF-16 based.
    - Some characters (like emojis) are represented by TWO char values (surrogate pairs).
    - The code point API allows working with real Unicode characters instead of UTF-16 units.
    */

    /*
    Code Point Count
    - Returns the number of Unicode code points in a given range.
    - Explanation: 😀 is represented by two char values, but a single Unicode code point (U+1F600).
    - Output: length: 4 count: 2
    */
    x = "😀😀";
    i1 = x.length();
    i2 = x.codePointCount(0, x.length());
    IO.println("length: " + i1 + " count: " + i2);

    /*
    Code Point At
    - Returns the character (Unicode code point) at the specified index.
    - Output: 128512
    */
    x = "😀";
    IO.println(x.codePointAt(0));

    /*
    Code Point Before
    - Returns the character (Unicode code point) before the specified index.
    - Output: 128512
    */
    x = "😀!";
    IO.println(x.codePointBefore(2));

    /*
    Offset By Code Points
    - Moves an index by a given number of Unicode code points.
    - Explanation: Each emoji occupies two UTF-16 code units. Moving by 3 code points results in index 6.
    - Output: 6
    */
    x = "😀😀😀";
    IO.println(x.offsetByCodePoints(0, 3));

    //==================================================================================================================
    // Streaming
    //==================================================================================================================

    /*
    Chars
    - Returns a stream of int zero-extending the char values from this sequence.
    - Output: 55357 56832
    */
    x = "😀";
    IntStream charsStream = x.chars();
    charsStream.forEach(IO::println);

    /*
    Code Points
    - Returns a stream of code point values from this sequence.
    - Note that for code points, the cmp below is a single value. Using chars, the character bellow counts as two ints.
    - Output: 128512
    */
    x = "😀";
    IntStream codePointsStream = x.codePoints();
    codePointsStream.forEach(IO::println);

    /*
    Lines
    - Returns a stream of lines extracted from this string, separated by line terminators.
    - Output: Hello | World
    */
    x = "Hello\nWorld";
    Stream<String> linesStream = x.lines();
    linesStream.forEach(IO::println);

    //==================================================================================================================
    // Functional Operations
    //==================================================================================================================

    /*
    Transform
    - This method allows the application of a function to this string.
    - The function should expect a single String argument and produce an R cmp.
    - Output: HELLO WORLD
    */
    x = "Hello World";
    IO.println(x.transform(String::toUpperCase));

    //==================================================================================================================
    // Conversion
    //==================================================================================================================

    /*
    To Char Array
    - Converts this string to a new character array.
    - Output: A | B | C
    */
    x = "ABC";
    char[] chars = x.toCharArray();
    for (char c : chars) IO.println(c);

    /*
    Get Chars
    - Copies characters from this sequence into the given destination array.
    - Output: W | o | r | l | d
    */
    x = "Hello World";
    char[] dst = new char[5];
    x.getChars(6, 11, dst, 0);
    for (char c : dst) IO.println(c);

    /*
    Get Bytes
    - Encodes this String into a sequence of bytes.
    - We can also specify the charset.
    - For more explicit encoding, prefer getBytes(StandardCharsets.UTF_8).
    - Output: 72 | 101 | 108 | 108 | 111 | 32 | 87 | 111 | 114 | 108 | 100
    */
    x = "Hello World";
    byte[] arr = x.getBytes();
    for (byte b : arr) IO.println(b);

    //==================================================================================================================
    // Hashing
    //==================================================================================================================

    /*
    Hash Code
    - Returns a hash code for this string.
    - Output: -862545276
    */
    x = "Hello World";
    IO.println(x.hashCode());

    //==================================================================================================================
    // CharSequence Support
    //==================================================================================================================

    /*
    CharSequence
    - CharSequence is a Java interface implemented by several classes that represent a readable sequence of characters,
      such as String, StringBuilder, StringBuffer, and CharBuffer.
    - The String class provides specific support for working with CharSequence to enable efficient and flexible
      interaction between different text representations.
    - The contentEquals method, for example, allows comparing the character content of a String with any object that
      implements CharSequence, regardless of its concrete type. This makes it possible to compare a String directly with
      instances like StringBuilder or StringBuffer without requiring explicit conversion.
    */

    /*
    Content Equals
    - Compares this string to the specified CharSequence.
    - Output: true
    */
    x = "Hello World";
    IO.println(x.contentEquals(new StringBuffer("Hello World")));

    /*
    Sub Sequence
    - Returns a character sequence that is a subsequence of this sequence.
    - Output: Wor
    */
    x = "Hello World";
    IO.println(x.subSequence(6, 9));

    //==================================================================================================================
    // Static Methods
    //==================================================================================================================

    /*
    Value Of
    - Returns the string representation of the argument.
    */
    y1 = String.valueOf(3.14);
    y2 = String.valueOf(new char[]{'A', 'B', 'C', 'D'});
    y3 = String.valueOf(new char[]{'A', 'B', 'C', 'D'}, 1, 2);
    IO.println(y1); // "3.14"
    IO.println(y2); // "ABCD"
    IO.println(y3); // "BC"

    /*
    Join
    - Returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified
      delimiter.
    */
    y1 = String.join(", ", "A", "B", "C");
    y2 = String.join(", ", new String[] {"A", "B", "C"});
    y3 = String.join(", ", Arrays.asList("A", "B", "C"));
    IO.println(y1); // A, B, C
    IO.println(y2); // A, B, C
    IO.println(y3); // A, B, C

    /*
    Format
    - Returns a formatted string using the specified format string and arguments.
    - An optional Locale can be provided.
    */
    String template = "Hello, %s! You have %d messages.";
    y1 = String.format(template, "John", 3);
    y2 = String.format(Locale.US, template, "John", 3);
    IO.println(y1); // Hello, John! You have 3 messages.
    IO.println(y2); // Hello, John! You have 3 messages.
}