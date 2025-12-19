@SuppressWarnings("ConstantConditions")
void main() {
    String x = "Hello World";

    // Length //////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Length
    int length = x.length();

    // String Transformation ///////////////////////////////////////////////////////////////////////////////////////////

    // Concat
    String contactResult = x.concat("!!!");

    // toLowerCase
    String lower1 = x.toLowerCase();
    String lower2 = x.toLowerCase(Locale.US);

    // toUpperCase
    String upper1 = x.toUpperCase();
    String upper2 = x.toUpperCase(Locale.US);

    // Indent
    String indented = x.indent(4);

    // Trim & Strip
    String trimmed = x.trim();
    String stripped = x.strip();

    // Repeat
    String repeated = x.repeat(2);

    // Replace

    // Get Bytes
    byte[] bytes1 = x.getBytes();
    byte[] bytes2 = x.getBytes(StandardCharsets.UTF_8);

    // String Transformation ///////////////////////////////////////////////////////////////////////////////////////////

    // Char At
    char char1 = x.charAt(5);

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

    // Equals
    boolean eq1 = x.equals("hello world");
    boolean eq2 = x.equalsIgnoreCase("hello world");

    // Compare
    int compareResult1 = x.compareTo("hello world");
    int compareResult2 = x.compareToIgnoreCase("hello world");

    // Contains
    boolean contains = x.contains("asd");

    // Content Check
    boolean equals1 = x.contentEquals("Hello World");
    boolean equals2 = x.contentEquals(new StringBuffer("Hello World"));

    // Starts With
    boolean starts1 = x.startsWith("Hello");
    boolean starts2 = x.startsWith("World", 5);

    // Ends With
    boolean endWith = x.endsWith("World");

    // Get Chars
    char[] chars = new char[5];
    x.getChars(0, 10, chars, 0);



    // Index Of (A = 65)
    String x2 = "ABAB";
    int i0 = x2.indexOf(65 );
    int i1 = x2.indexOf(65, 1);
    int i2 = x2.indexOf(65, 1, 3);
    int i3 = x2.indexOf("AB");
    int i4 = x2.indexOf("AB", 1);
    int i5 = x2.indexOf("AB", 1, 3);

    // Last Index Of (A = 65)
    int i6 = x2.lastIndexOf(65);
    int i7 = x2.lastIndexOf(65, 2);
    int i8 = x2.lastIndexOf("AB");
    int i9 = x2.lastIndexOf("AB", 2);

    // Check Blank and Empty
    String x3 = " ";
    boolean isBlank = x3.isBlank();
    boolean isEmpty = x3.isEmpty();

    // Stream
    Stream<String> linesStream = x.lines();


}