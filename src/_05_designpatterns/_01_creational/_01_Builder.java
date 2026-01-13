/*

*/
public class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s", this.id, this.name);
    }
}

/*

*/
public class PersonBuilder {
    private int id;
    private String name;

    public PersonBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public PersonBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Person build() {
        return new Person(this.id, this.name);
    }
}

/*

*/
public class PersonDirector {
    private PersonBuilder personBuilder;

    public PersonDirector(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public Person build(int id, String name) {
        return this.personBuilder
                .withId(id)
                .withName(name)
                .build();
    }

    public Person buildUnknown() {
        return this.personBuilder
                .withId(0)
                .withName("Unknown")
                .build();
    }
}

/*
Test
*/
void main() {
    PersonBuilder builder = new PersonBuilder();
    PersonDirector director = new PersonDirector(builder);

    Person p1 = director.build(1, "John");
    Person p2 = director.buildUnknown();

    IO.println(p1); // ID: 1, Name: John
    IO.println(p2); // ID: 0, Name: Unknown
}