/*
Constants are variables whose value cannot be changed once assigned.
In Java, constants are declared using the "final" keyword.
*/
@SuppressWarnings("all")
void main() {
    /*
    Declaring a constant integer.
    By convention, constant names are written in uppercase letters with underscores.
    Output: Max users: 100
    */
    final int MAX_USERS = 100;
    IO.println("Max users: " + MAX_USERS);

    /*
    Declaring a constant string.
    Output: Application name: JavaGuide
    */
    final String APP_NAME = "JavaGuide";
    IO.println("Application name: " + APP_NAME);

    /*
    Attempting to change a constant value will cause a compilation error.
    Uncommenting the following line will fail:
    Output: Cannot assign a value to final variable 'MAX_USERS'
    */
    // MAX_USERS = 200;

    /*
    Constants can also be of other types (double, boolean, etc.).
    Output: PI: 3.14159, Active: true
    */
    final double PI = 3.14159;
    final boolean IS_ACTIVE = true;
    IO.println("PI: " + PI + ", Active: " + IS_ACTIVE);
}