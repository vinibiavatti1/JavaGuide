/*
The main method in Java is the entry point of the application, where the program starts executing.
Key points about the main method:
- Must be named "main" to be recognized by the JVM.
- Must be "public" and "static".
- Must accept a "String[] args" parameter for command-line arguments.
*/
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        IO.println("Hello World");
    }
}

/*
Since Java 25, it is possible to use a simplified top-level main method
without explicitly defining a class, but the traditional form below
remains the standard and is widely used.
*/
void main() {
    IO.println("Hello World");
}