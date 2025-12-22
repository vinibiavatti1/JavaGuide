/*
String Format

String formatting in Java is based on format specifiers, which define how
values are converted and inserted into a formatted string. The syntax of
a format specifier is:

%[arg$][flags][width][.precision]conversion

Placeholders:
arg$:       (optional) Specifies the index of the argument to use (1-based). Useful for reordering arguments.
flags:      (optional) Modify the formatting behavior, such as alignment, padding, sign display, or alternate forms.
width:      (optional) Sets the minimum number of characters to be written. Padding is applied if necessary.
.precision: (optional) Controls the number of digits or characters to display, depending on the conversion type.
conversion: (required) Defines the type of data to format (e.g., s for strings, d for integers, f for floating-point).

Flags:
"-": Left-justifies the output within the given width.
"#": Uses an alternate format (e.g., adds prefix for hex/octal or forces decimal point for floating-point values).
"+": Forces a sign (+ or -) to be displayed for numeric values.
" ": Prefixes positive numbers with a leading space if no sign is shown.
"0": Pads the output with leading zeros instead of spaces.
",": Uses locale-specific grouping separators (e.g., thousands separator).
"(": Encloses negative numeric values in parentheses instead of using a minus sign.

Conversion
"%": Displays a literal '%' character in the output.
"n": Inserts a platform-specific line separator.
"s": Formats a string. Calls toString() on the argument if it is not a string.
"S": Formats a string, converting it to uppercase.
"c": Formats a single character.
"C": Formats a single character, converting it to uppercase.
"d": Formats a decimal integer.
"o": Formats an integer as octal.
"x": Formats an integer as hexadecimal (lowercase).
"X": Formats an integer as hexadecimal (uppercase).
"e": Formats a floating-point number in scientific notation (lowercase 'e').
"E": Formats a floating-point number in scientific notation (uppercase 'E').
"f": Formats a floating-point number in standard decimal notation.
"g": Uses 'f' or 'e' style formatting based on the value (lowercase).
"G": Uses 'F' or 'E' style formatting based on the value (uppercase).
"a": Formats a floating-point number in hexadecimal scientific notation (lowercase).
"A": Formats a floating-point number in hexadecimal scientific notation (uppercase).
"b": Formats a boolean value as "true" or "false".
"B": Formats a boolean value as "TRUE" or "FALSE".
"h": Formats the hash code of the argument (via Integer.toHexString(arg.hashCode())).
"H": Formats the hash code in uppercase hexadecimal.
"t": Formats date/time values according to the specified suffix (e.g., tY, tm, td, tH, tM, tS).
"T": Formats date/time values according to the specified suffix (e.g., TY, TM, TD, TH, TM, TS).
*/
void main() {
    /*
    Conversion Example
    Defines the type of data to format (e.g., s for strings, d for integers, f for floating-point).
    Format: %conversion
    Output: A A true 1 3,140000
    */
    String format = "%s %c %b %d %f";
    String result = String.format(format, "A", 'A', true, 1, 3.14);
    IO.println(result);

    /*
    Argument Index Example
    Specifies the index of the argument to use (1-based). Useful for reordering arguments.
    Format: %[arg$]conversion
    Output: B A
    */
    format = "%2$s %1$s";
    result = String.format(format, "A", "B");
    IO.println(result);

    /*
    Flag Example
    Modify the formatting behavior, such as alignment, padding, sign display, or alternate forms.
    Format: %[flags]conversion
    Output: +1
    */
    format = "%+d";
    result = String.format(format, 1);
    IO.println(result);

    /*
    Width Example
    Sets the minimum number of characters to be written. Padding is applied if necessary.
    Format: [width]conversion
    Output: "  1"
    */
    format = "%03d";
    result = String.format(format, 1);
    IO.println(result);

    /*
    Precision Example
    Controls the number of digits or characters to display, depending on the conversion type.
    Format: %[.precision]conversion
    Output: 3,14
    */
    format = "%.2f";
    result = String.format(format, 3.14);
    IO.println(result);

    /*
    Complete Example
    An example case using all placeholders.
    Format: %[arg$][flags][width][.precision]conversion
    Output: 004,160 003,140
    */
    format = "%2$07.3f %1$07.3f";
    result = String.format(format, 3.14, 4.16);
    IO.println(result);
}