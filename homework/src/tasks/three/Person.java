package tasks.three;

/**
 * Created by AMakas on 21.01.2017.
 */
public class Person {
    private String surName;
    private String name;


    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public Person(String surName, String name) {
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surName='" + surName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static Person Transform(String str) {
        Person person = null;
        try {
            String[] split = str.split("\t");
            if (split.length == 2) {
                person = new Person(split[0], split[1]);
            }
        } catch (Exception  e) {
            person = null;
        }

        return person;
    }
}
