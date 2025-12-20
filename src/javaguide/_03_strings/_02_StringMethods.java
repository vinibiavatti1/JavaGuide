/*
String provides a rich set of methods for inspecting, transforming,
searching, comparing, and converting textual data.

Key characteristics:
- Strings are immutable: all modification operations return a new instance.
- Index-based operations work on UTF-16 code units (char), not on user-perceived characters.
- Unicode-aware operations are provided via code point–based methods.

Method categories covered in this document include:
- Length
- Character Access
- Index
- Transformation
- Equality
- Compare
- Split
- Encoding
*/
@SuppressWarnings("ConstantConditions")
void main() {
    // Length //////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Length
    Returns the length of this string.
    The length is equal to the number of Unicode code units in the string.
    Output: 11
    */
    String x = "Hello World";
    int length = x.length();
    IO.println(length);

    // Character Access ////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Char At
    Returns the char value at the specified index.
    Output: W
    */
    char ch = x.charAt(6);
    IO.println(ch);

    // Index ///////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    Index Of (Unicode)
    Returns the index based on a character Unicode.
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
    Last Index Of (Unicode)
    Returns the index based on a character Unicode.
    Output: 4 0
    */
    x = "A B A C";
    i1 = x.lastIndexOf(65);    // A
    i2 = x.lastIndexOf(65, 3); // A
    IO.println(i1 + " " + i2);

    // Transformation //////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Contact
    Concatenates the specified string to the end of this string.
    Output: Hello World
    */
    x = "Hello";
    String y = x.concat(" World");
    IO.println(y);

    /*
    Lower Case
    Converts all the characters in this String to lower case using the rules of the Locale.
    Output: hello world / hello world
    */
    x = "Hello World";
    String y1 = x.toLowerCase();
    String y2 = x.toLowerCase(Locale.US);
    IO.println(y1 + " / " + y2);

    /*
    Upper Case
    Converts all the characters in this String to upper case using the rules of the Locale.
    Output: HELLO WORLD / HELLO WORLD
    */
    x = "Hello World";
    y1 = x.toLowerCase();
    y2 = x.toLowerCase(Locale.US);
    IO.println(y1 + " / " + y2);

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
    Returns a string whose value is this string, with all leading and trailing white space removed.
    Removes any character classified as Unicode Whitespace: Character.isWhitespace(...)
    Output: Hello World
    */
    x = "  Hello World  ";
    y = x.strip();
    IO.println(y);

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

    // Substrings //////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Substring
    Returns a string that is a substring of this string.
    Output: World / Wor
    */
    x = "Hello World";
    y1 = x.substring(6);
    y2 = x.substring(6, 9);
    IO.println(y1 + " / " + y2);

    // Replacement /////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Replace
    Returns a string resulting from replacing ALL occurrences of oldChar in this string with newChar.
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

    // Equality ////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    // Compare /////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    // Split ///////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    // Encoding ////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Get Bytes
    Encodes this String into a sequence of bytes.
    We can also specify the charset.
    Output: 72 101 108 108 111 32 87 111 114 108 100
    */
    x = "Hello World";
    byte[] arr = x.getBytes();
    for (byte b : arr) {
        IO.print(b + " ");
    }
    IO.println();







    //x.regionMatches()




    // Char Sequence ///////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    Content Equals
    Compares this string to the specified CharSequence.
    The result is true if and only if this String represents the same sequence of char values as the specified sequence.

    */
    check = x.contentEquals("Hello World");

    /*
    Content Equals (String Buffer)
    */
    check = x.contentEquals(new StringBuffer("Hello World"));

    /*
    Sub Sequence
    Returns a character sequence that is a subsequence of this sequence.
    NOTE: A CharSequence is a readable sequence of char values.
    Output: Wor
    */
    x = "Hello World";
    CharSequence seq = x.subSequence(6, 9);
    IO.println(seq);





    // /////////////////////////

    // Chars Stream
    IntStream charStream = x.chars();

    // Code Points
    String emoji = "😀";
    int codepoint1 = x.codePointAt(0);
    int codepoint2 = x.codePointBefore(1);
    int codepoint3 = x.codePointCount(0, 5);

    // Code Points Stream
    IntStream codePointsStream = x.codePoints();

    // Offset by code points
    int offset = x.offsetByCodePoints(0, 5);











    // Get Chars
    char[] chars = new char[5];
    x.getChars(0, 10, chars, 0);







    // Stream
    Stream<String> linesStream = x.lines();

    // Match (Regex)
    boolean match1 = x.matches("^[a-zA-Z ]*$");

    // Region Matches
    boolean match2 = x.regionMatches(6, "Hi World", 3, 5);
    boolean match3 = x.regionMatches(true, 6, "Hi World", 3, 5); // For code points




}