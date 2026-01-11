/*
(falar sobre retention)
(falar sobre value)
*/
public @interface MyAnnotation {
    String value();            // Special field
    String notes() default ""; // ...
}

@MyAnnotation("Hello World")
public class MyClass {

}

void main() {

}