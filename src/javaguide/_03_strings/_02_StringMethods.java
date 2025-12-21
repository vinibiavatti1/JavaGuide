/*
String provides a rich set of methods for inspecting, transforming,
searching, comparing, and converting textual data.

Key characteristics:
- Strings are immutable: all modification operations return a new instance.
- Index-based operations work on UTF-16 code units (char), not on user-perceived characters.
- Unicode-aware operations are provided via code point–based methods.

Index
- Length
  - length()
- Character Access
  - charAt()
- Search
  - indexOf()
  - lastIndexOf()
- Transformation
  - concat()
  - trim()
  - strip()
  - stripLeading()
  - stripTrailing()
  - stripIndent()
  - toLowerCase()
  - toUpperCase()
  - repeat()
  - indent()
  - translateEscapes()
- Substrings
  - substring()
- Replacement
  - replace()
  - replaceAll()
  - replaceFirst()
- Equality and Matching
  - equals()
  - equalsIgnoreCase()
  - isBlank()
  - isEmpty()
  - contains()
  - startsWith()
  - endsWith()
  - matches()
  - regionMatches()
- Comparison
  - compareTo()
  - compareToIgnoreCase()
- Splitting
  - split()
  - splitWithDelimiters()
- Unicode and Code Points
  - codePointCount()
  - codePointAt()
  - codePointBefore()
  - offsetByCodePoints()
- Streaming
  - chars()
  - lines()
- Functional Operations
  - transform()
- Conversion
  - toCharArray()
  - getChars()
  - getBytes()
- CharSequence Support
  - contentEquals()
  - subSequence()
*/
@SuppressWarnings("ConstantConditions")
void main() {
    //==================================================================================================================
    // Length
    //==================================================================================================================

    /*
    Length
    Returns the length of this string.
    The length is equal to the number of Unicode code units in the string.
    Output: 11
    */
    String x = "Hello World";
    int length = x.length();
    IO.println(length);

    //==================================================================================================================
    // Character Access
    //==================================================================================================================

    /*
    Char At
    Returns the char value at the specified index.
    Output: W
    */
    char ch = x.charAt(6);
    IO.println(ch);

    //==================================================================================================================
    // Search
    //==================================================================================================================

    /*
    Index Of
    Returns the index within this string of the first occurrence of the specified character or string.
    beginIndex – the index to start the search from (included).
    endIndex – the index to stop the search at (excluded)
    Output: 2 4
    */
    x = "A B A C";
    int i1 = x.indexOf("B");
    int i2 = x.indexOf("A", 2, 6);
    IO.println(i1 + " " + i2);

    /*
    Index Of (char / int)
    Returns the index based on a UTF-16 char value.
    Output: 2 4
    */
    x = "A B A C";
    i1 = x.indexOf(66);       // B
    i2 = x.indexOf(65, 2, 6); // A
    IO.println(i1 + " " + i2);

    /*
    Last Index Of
    Returns the index within this string of the last occurrence of the specified substring searching backward starting
    at the specified index.
    fromIndex – the index to start the search from
    Output: 4 0
    */
    x = "A B A C";
    i1 = x.lastIndexOf("A");
    i2 = x.lastIndexOf("A", 3);
    IO.println(i1 + " " + i2);

    /*
    Last Index Of (char / int)
    Returns the last index based on a UTF-16 char value.
    Output: 4 0
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
    Concatenates the specified string to the end of this string.
    Output: Hello World
    */
    x = "Hello";
    String y = x.concat(" World");
    IO.println(y);

    /*
    Trim
    Returns a string whose value is this string, with all leading and trailing space removed,
    where space is defined as any character whose codepoint is less than or equal to 'U+0020'
    (the space character).
    Characters: \t, \n, \r
    Output: Hello World
    */
    x = "  Hello World  ";
    y = x.trim();
    IO.println(y);

    /*
    Strip
    Returns a string with incidental white space removed
    Removes any character classified as Unicode Whitespace: Character.isWhitespace(...)
    Output: Hello World
    */
    x = "  Hello World  ";
    y = x.strip();
    String y1 = x.stripLeading();
    String y2 = x.stripTrailing();
    IO.println(y);  // "Hello World"
    IO.println(y1); // "Hello World  "
    IO.println(y2); // "  Hello World"

    /*
    Strip Indent
    Returns a with incidental white space removed from the beginning and end of every line.
    Output:
    <html>
    <body />
    </html>
    */
    x = """
        <html>
            <body />
        </html>
    """;
    y = x.stripIndent();
    IO.println(y);

    /*
    Lower Case
    Converts all the characters in this String to lower case using the rules of the Locale.
    Output: hello world / hello world
    */
    x = "Hello World";
    y1 = x.toLowerCase();
    y2 = x.toLowerCase(Locale.US);
    IO.println(y1 + " / " + y2);

    /*
    Upper Case
    Converts all the characters in this String to upper case using the rules of the Locale.
    Output: HELLO WORLD / HELLO WORLD
    */
    x = "Hello World";
    y1 = x.toUpperCase();
    y2 = x.toUpperCase(Locale.US);
    IO.println(y1 + " / " + y2);

    /*
    Repeat
    Returns a string whose value is the concatenation of this string repeated count times.
    Output: HelloHelloHello
    */
    x = "Hello";
    y = x.repeat(3);
    IO.println(y);

    /*
    Indent
    Adjusts the indentation of each line of this string based on the value of n,
    and normalizes line termination characters.
    Output:
        Hello
        World
    */
    x = "Hello\nWorld";
    y = x.indent(4);
    IO.println(y);

    /*
    Translate Escapes
    Returns a string with escape sequences translated as string literal.
    Output: U+0009 U+000A
    */
    x = "\t \n";
    y = x.translateEscapes();
    IO.println(y);

    //==================================================================================================================
    // Substrings
    //==================================================================================================================

    /*
    Substring
    Returns a string that is a substring of this string.
    Output: World / Wor
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
    Returns a string resulting from replacing all occurrences of a character or substring.
    Output: Hello World / Hello Workd
    */
    x = "Hekko Workd";
    y1 = x.replace('k', 'l');
    y2 = x.replace("kk", "ll");
    IO.println(y1 + " / " + y2);

    /*
    Replace All (Regex)
    Replaces each substring of this string that matches the given regular expression with the given replacement.
    Output: Hxxxx Wxxxx
    */
    x = "Hello World";
    y = x.replaceAll("[a-z]", "x");
    IO.println(y);

    /*
    Replace First (Regex)
    Replaces the first substring of this string that matches the given regular expression with the given replacement.
    Output: Hxllo World
    */
    x = "Hello World";
    y = x.replaceFirst("[a-z]", "x");
    IO.println(y);

    //==================================================================================================================
    // Equality and Matching
    //==================================================================================================================

    /*
    Equals
    Compares this string to the specified object.
    Output: true
    */
    x = "Hello World";
    boolean check = x.equals("Hello World");
    IO.println(check);

    /*
    Equals (Ignore Case)
    Compares this String to another String, ignoring case considerations.
    Output: true
    */
    x = "Hello World";
    check = x.equalsIgnoreCase("hello world");
    IO.println(check);

    /*
    Is Blank
    Returns true if the string is empty or contains only white space codepoints.
    Output: true
    */
    x = "   ";
    check = x.isBlank();
    IO.println(check);

    /*
    Is Empty
    Returns true if, and only if, length() is 0.
    Output: true
    */
    x = "";
    check = x.isEmpty();
    IO.println(check);

    /*
    Contains
    Returns true if and only if this string contains the specified sequence of char values.
    Output: true
    */
    x = "Hello World";
    check = x.contains("Wor");
    IO.println(check);

    /*
    Starts With
    Tests if this string starts with the specified prefix.
    We can specify an offse where to begin looking in this string.
    Output: true true
    */
    x = "Hello World";
    boolean check1 = x.startsWith("Hello");
    boolean check2 = x.startsWith("World", 6);
    IO.println(check1 + " " + check2);

    /*
    Ends With
    Tests if this string ends with the specified suffix.
    Output: true
    */
    x = "Hello World";
    check = x.endsWith("World");
    IO.println(check);

    /*
    Matches
    Tells if this string matches the given regular expression.
    Output: true
    */
    x = "Hello World";
    check = x.matches("[a-zA-Z ]*");
    IO.println(check);

    /*
    Region Matches
    Tests if two string regions are equal.
    The code below is comparing: "B C" with "B C"
    Note: This method operates on UTF-16 char units, not Unicode code points. It is not safe for characters outside
    the BMP (e.g. emojis).
    Output: true true
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
    Compares two strings lexicographically.
    The comparison is based on the Unicode value of each character in the strings.
    Output: 0
    */
    x = "Hello World";
    int result = x.compareTo("Hello World");
    IO.println(result);

    /*
    Compare (Ignore Case)
    Compares two strings lexicographically, ignoring case differences.
    Output: 0
    */
    x = "Hello World";
    result = x.compareToIgnoreCase("hello world");
    IO.println(result);

    //==================================================================================================================
    // Splitting
    //==================================================================================================================

    /*
    Split
    Splits this string around matches of the given regular expression.
    Output: 0: A | 1: B | 2: C
    */
    x = "A,B,C";
    String[] parts = x.split(",");
    for (int i = 0; i < parts.length; i++) {
        IO.println(i + ": " + parts[i]);
    }

    /*
    Split (With Limit)
    Splits this string around matches of the given regular expression.
    The limit parameter controls the number of times the pattern is applied and therefore affects the length of the
    resulting array.
    If limit is zero, the pattern will be applied as many times as possible.
    Output: 0: A | 1: B | 2: C,D
    */
    x = "A,B,C,D";
    parts = x.split(",", 3);
    for (int i = 0; i < parts.length; i++) {
        IO.println(i + ": " + parts[i]);
    }

    /*
    Split With Delimiters
    Splits this string around matches of the given regular expression and returns both the strings and the matching
    delimiters.
    If limit is zero, the pattern will be applied as many times as possible.
    Output: 0: A | 1: , | 2: B | 3: , | 4: C
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
    Some characters (like emojis) are represented by TWO char values (surrogate pairs).
    The code point API allows working with real Unicode characters instead of UTF-16 units.
    */

    /*
    Code Point Count
    Returns the number of Unicode code points in a given range.
    Explanation: 😀 is represented by two char values, but a single Unicode code point (U+1F600).
    Output: length: 4 count: 2
    */
    x = "😀😀";
    i1 = x.length();
    i2 = x.codePointCount(0, x.length());
    IO.println("length: " + i1 + " count: " + i2);

    /*
    Code Point At
    Returns the character (Unicode code point) at the specified index.
    Output: 128512
    */
    x = "😀";
    i1 = x.codePointAt(0);
    IO.println(i1);

    /*
    Code Point Before
    Returns the character (Unicode code point) before the specified index.
    Output: 128512
    */
    x = "😀!";
    i1 = x.codePointBefore(2);
    IO.println(i1);

    /*
    Offset By Code Points
    Moves an index by a given number of Unicode code points.
    Explanation: Each emoji occupies two UTF-16 code units. Moving by 3 code points results in index 6.
    Output: 6
    */
    x = "😀😀😀";
    i1 = x.offsetByCodePoints(0, 3);
    IO.println(i1);

    //==================================================================================================================
    // Streaming
    //==================================================================================================================

    /*
    Chars
    Returns a stream of int zero-extending the char values from this sequence.
    Output: 55357 56832
    */
    x = "😀";
    IntStream charsStream = x.chars();
    charsStream.forEach(IO::println);

    /*
    Code Points
    Returns a stream of code point values from this sequence.
    Note that for code points, the result below is a single value. Using chars, the character bellow counts as two ints.
    Output: 128512
    */
    x = "😀";
    IntStream codePointsStream = x.codePoints();
    codePointsStream.forEach(IO::println);

    /*
    Lines
    Returns a stream of lines extracted from this string, separated by line terminators.
    Output: Hello | World
    */
    x = "Hello\nWorld";
    Stream<String> linesStream = x.lines();
    linesStream.forEach(IO::println);

    //==================================================================================================================
    // Functional Operations
    //==================================================================================================================

    /*
    Transform
    This method allows the application of a function to this string.
    The function should expect a single String argument and produce an R result.
    Output: HELLO WORLD
    */
    x = "Hello World";
    y = x.transform(String::toUpperCase);
    IO.println(y);

    //==================================================================================================================
    // Conversion
    //==================================================================================================================

    /*
    To Char Array
    Converts this string to a new character array.
    Output: 0: A | 1: B | 2: C
    */
    x = "ABC";
    char[] chars = x.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        IO.println(i + ": " + chars[i]);
    }

    /*
    Get Chars
    Copies characters from this sequence into the given destination array.
    Output: 0: W | 1: o | 2: r | 3: l | 4: d
    */
    x = "Hello World";
    char[] dst = new char[5];
    x.getChars(6, 11, dst, 0);
    for (int i = 0; i < dst.length; i++) {
        IO.println(i + ": " + dst[i]);
    }

    /*
    Get Bytes
    Encodes this String into a sequence of bytes.
    We can also specify the charset.
    For more explicit encoding, prefer getBytes(StandardCharsets.UTF_8).
    Output: 72 101 108 108 111 32 87 111 114 108 100
    */
    x = "Hello World";
    byte[] arr = x.getBytes();
    for (byte b : arr) {
        IO.print(b + " ");
    }
    IO.println();

    //==================================================================================================================
    // CharSequence Support
    //==================================================================================================================

    /*
    CharSequence is a Java interface implemented by several classes that represent a readable sequence of characters,
    such as String, StringBuilder, StringBuffer, and CharBuffer.
    The String class provides specific support for working with CharSequence to enable efficient and flexible
    interaction between different text representations.
    The contentEquals method, for example, allows comparing the character content of a String with any object that
    implements CharSequence, regardless of its concrete type. This makes it possible to compare a String directly with
    instances like StringBuilder or StringBuffer without requiring explicit conversion.
    */

    /*
    Content Equals
    Compares this string to the specified CharSequence.
    Output: true
    */
    x = "Hello World";
    check = x.contentEquals(new StringBuffer("Hello World"));
    IO.println(check);

    /*
    Sub Sequence
    Returns a character sequence that is a subsequence of this sequence.
    Output: Wor
    */
    x = "Hello World";
    CharSequence seq = x.subSequence(6, 9);
    IO.println(seq);
}