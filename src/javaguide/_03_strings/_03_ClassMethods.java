/*
The String class represents immutable sequences of characters and also provides
a rich set of static utility methods for creating, formatting, joining,
and converting textual data.
*/
void main () {
    /*
    Value Of
    Returns the string representation of the argument.
    */
    String y1 = String.valueOf(1);
    String y2 = String.valueOf(true);
    String y3 = String.valueOf(3.14);
    String y4 = String.valueOf(new char[]{'A', 'B', 'C', 'D'});
    String y5 = String.valueOf(new char[]{'A', 'B', 'C', 'D'}, 1, 2);
    IO.println(y1); // "1"
    IO.println(y2); // "true"
    IO.println(y3); // "3.14"
    IO.println(y4); // "ABCD"
    IO.println(y5); // "BC"

    /*
    Join
    Returns a new String composed of copies of the CharSequence elements joined together with a copy of the specified
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
    Returns a formatted string using the specified format string and arguments.
    An optional Locale can be provided.
    */
    String template = "Hello, %s! You have %d messages.";
    y1 = String.format(template, "John", 3);
    y2 = String.format(Locale.US, template, "John", 3);
    IO.println(y1); // Hello, John! You have 3 messages.
    IO.println(y2); // Hello, John! You have 3 messages.
}