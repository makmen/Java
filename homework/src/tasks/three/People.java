package tasks.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by AMakas on 21.01.2017.
 */
public class People {

    private ArrayList<Person> listPeople;

    public ArrayList<Person> getListPeople() {
        return listPeople;
    }

    public People(ArrayList<String> all) {
        listPeople = new ArrayList<>();
        Person person;
        for (String item: all) {
            person = Person.Transform(item);
            if (person != null) {
                listPeople.add(person);
            }
        }
    }

    public void sortByName() {
        Collections.sort(listPeople, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void sortBySurname() {
        Collections.sort(listPeople, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                return o1.getSurName().compareTo(o2.getSurName());
            }
        });
    }

}
