import javax.swing.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Tests {
    public static void main(String[] args) throws Exception {
        for (Method method : MyTest.class.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                method.invoke(null);
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {}

class MyTest {

    @Test
    public static void test1() {
        IO.println("TEST 1");
    }

    @Test
    public static void test2() {
        IO.println("TEST 2");
    }
}

class Person {
    private String name;
    private transient int age;
}