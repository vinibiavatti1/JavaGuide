package _09_examples;

import java.util.*;
import java.util.stream.Stream;

public class Tests2 {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Xundas", 32, false, List.of(" Football", "LoL")));
        people.add(new Person("Vini", 31, true, List.of("Java", " Mushrooms")));
        people.add(new Person("Ana", 28, true, List.of("Series", "Repo ")));
        people.add(new Person("Elder", 12, false, List.of("Heavy Dicks", "Feet Pics")));

        // IMPERATIVE ==================================================================================================

        int sum = 0;
        List<String> likes = new ArrayList<>();
        for (Person p : people) {
            if (p.getAge() <= 30) {
                continue;
            }
            if (!p.isMarried()) {
                continue;
            }

            likes.addAll(p.getLikes());
        }
        for (String like : likes) {
            like = like.trim();
            int len = like.length();
            sum += len;
        }
        IO.println(sum);

        // FP ==========================================================================================================

        int sum2 = people.stream()
                .filter(PersonRules::IsOverAge)
                .filter(PersonRules::isMarried)
                .flatMap(PersonRules::getLikes)
                .map(String::trim)
                .mapToInt(String::length)
                .sum();
        IO.println(sum2);
    }
}

class Person {
    private String name;
    private int age;
    private boolean isMarried;
    private List<String> likes;

    public Person(String name, int age, boolean isMarried, List<String> likes) {
        this.name = name;
        this.age = age;
        this.isMarried = isMarried;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married) {
        isMarried = married;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }
}

class PersonRules {
    public static Stream<String> getLikes(Person p) {
        return p.getLikes().stream();
    }

    public static boolean isMarried(Person p) {
        return p.isMarried();
    }

    public static boolean IsOverAge(Person p) {
        return p.getAge() >= 18;
    }

    public static boolean IsNotNull(String name) {
        return name != null;
    }

    public static boolean NameDoesNotContainSpace(String name) {
        return !name.contains(" ");
    }
}