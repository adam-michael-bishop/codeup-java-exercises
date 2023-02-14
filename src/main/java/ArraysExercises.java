import java.util.Arrays;

public class ArraysExercises {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        Person[] people = new Person[3];
        people[0] = new Person("Bob");
        people[1] = new Person("Joe");
        people[2] = new Person("Sue");

        for (Person person : people) {
            System.out.println(person.getName());
        }
        
        people = addPerson(people, new Person("Steve"));

        for (Person person : people) {
            System.out.println(person.getName());
        }
    }

    private static Person[] addPerson(Person[] people, Person person) {
        Person[] newPeople = Arrays.copyOf(people, people.length + 1);
        newPeople[newPeople.length - 1] = person;
        return newPeople;
    }
}
