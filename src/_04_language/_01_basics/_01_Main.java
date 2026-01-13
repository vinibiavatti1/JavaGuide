/*
Main
- The main method in Java is the entry point of the application, where the program starts executing.

Rules:
- Must be named "main" to be recognized by the JVM.
- Must be "public" and "static".
- Must accept a "String[] args" parameter for command-line arguments.

Parameter (String[] args)
- The main method in Java has a parameter "String[] args", which allows the program to receive input from the command
  line when it is executed.
- For example, if the program is executed with "java -jar program.jar a b c", the arguments "a", "b", and "c" will be
  present in the args parameter.
*/
public class Main {
    public static void main(String[] args) {
        IO.println("Hello World"); // Output: Hello World
    }
}

/*
Simplified Main
- Since Java 25, it is possible to use a simplified top-level main method without explicitly defining a class.
*/
void main() {
    IO.println("Hello World"); // Output: Hello World
}