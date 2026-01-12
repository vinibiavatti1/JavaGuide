@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Order {
    int value();
}

public static class Test {
    @Order(2)
    public static void testX () {
        IO.println("Testing X...");
    }

    @Order(3)
    public static void testY () {
        IO.println("Testing Y...");
    }

    @Order(1)
    public static void testZ () {
        IO.println("Testing Z...");
    }
}

public class MethodOrderComparator implements Comparator<Method> {
    @Override
    public int compare(Method o1, Method o2) {
        return Integer.compare(o1.getAnnotation(Order.class).value(), o2.getAnnotation(Order.class).value());
    }
}

void main() throws Exception {
    List<Method> methods = Arrays.stream(Test.class.getDeclaredMethods())
            .filter(x -> x.isAnnotationPresent(Order.class))
            .sorted(new MethodOrderComparator())
            .toList();
    for (Method method : methods) {
        method.invoke(null);
    }
}