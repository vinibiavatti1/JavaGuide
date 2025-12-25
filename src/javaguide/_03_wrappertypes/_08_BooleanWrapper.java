/*
The Boolean type is a wrapper (reference) type in Java.
It represents a logical value, which can be either true or false.

Unlike the primitive boolean, Boolean is an object and can be used in contexts that
require reference types, such as collections, generics, and APIs that operate
on objects.

Notes:
- Use Boolean when an object representation is required (e.g. List<Boolean>, Map keys).
- Supports null, which can be useful to represent the absence of a value.
- Provides utility methods such as valueOf(), parseBoolean(), and compare().
- Autoboxing allows transparent conversion between boolean and Boolean.
- Boolean does not have a numeric range, as it only represents true or false.
- Additional memory and performance overhead exists compared to primitive boolean.
*/
@SuppressWarnings("all")
void main() {
    //==================================================================================================================
    // Boolean Instance
    //==================================================================================================================

    /*
    Declaring
    To declare an instance of this wrapper data type, we can use the "valueOf" function.
    Output: 3.14
    */
    Boolean w = Boolean.valueOf(true);
    IO.println(w);

    /*
    Value
    Returns the value of this Boolean as the specified data type.
    Output: true
    */
    w = Boolean.valueOf(true);
    boolean b = w.booleanValue();
    IO.println(b);

    /*
    Equals
    Compares this object to the specified object.
    NOTE: Wrapper types should be compared using the equals() method rather than the '==' operator.
    Output: true
    */
    Boolean w1 = Boolean.valueOf(true);
    Boolean w2 = Boolean.valueOf(true);
    boolean eq = w1.equals(w2);
    IO.println(eq);

    /*
    Compare To
    Compares two Boolean objects numerically (true > false)
    Output: 0 (equal)
    */
    w1 = Boolean.valueOf(true);
    w2 = Boolean.valueOf(true);
    int cmp = w1.compareTo(w2);
    IO.println(cmp);

    /*
    Hash Code
    Returns a hash code for a boolean value;
    Output: 1231
    */
    w = Boolean.valueOf(true);
    int i = w.hashCode();
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified boolean.
    Output: true
    */
    w = Boolean.valueOf(true);
    String str = w.toString();
    IO.println(str);

    //==================================================================================================================
    // Boolean Class
    //==================================================================================================================

    /*
    Fields
    The fields below are available in the wrapper class.
    */
    IO.println(Boolean.FALSE); // new Boolean(false);
    IO.println(Boolean.TRUE);  // new Boolean(true);
    IO.println(Boolean.TYPE);  // boolean

    /*
    Value Of
    Returns a Boolean object holding the value given by the specified argument.
    We can determine the base of the number using the radix parameter.
    */
    w = Boolean.valueOf("true");
    IO.println(w); // true

    /*
    Parse Int
    Parses the string argument as a signed decimal double.
    We can determine the base of the number using the radix parameter.
    */
    b = Boolean.parseBoolean("true");
    IO.println(b); // true

    /*
    Compare
    Compares two double values numerically.
    Output: 0 (equal)
    */
    boolean b1 = true;
    boolean b2 = true;
    cmp = Boolean.compare(b1, b2);
    IO.println(cmp);

    /*
    Get Boolean
    Determines the boolean value of the system property with the specified name.
    Shortcut for: System.getProperty(...) + Boolean parsing
    Output: true
    */
    System.setProperty("property", "true");
    b = Boolean.getBoolean("property");
    IO.println(b);

    /*
    Logical AND
    Returns the result of applying the logical AND operator to the specified boolean operands.
    Output: false
    */
    b = Boolean.logicalAnd(true, false);
    IO.println(b);

    /*
    Logical OR
    Returns the result of applying the logical OR operator to the specified boolean operands.
    Output: true
    */
    b = Boolean.logicalOr(true, false);
    IO.println(b);

    /*
    Logical XOR
    Returns the result of applying the logical XOR operator to the specified boolean operands.
    Output: true
    */
    b = Boolean.logicalXor(true, false);
    IO.println(b);

    /*
    Hash Code
    Returns a hash code for a int value;
    Output: 1231
    */
    i = Boolean.hashCode(true);
    IO.println(i);

    /*
    To String
    Returns a new String object representing the specified int.
    Output: true
    */
    str = Boolean.toString(true);
    IO.println(str);
}