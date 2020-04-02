import java14.Person;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        final Person uladzimir = new Person("Uladzimir", 28);
        System.out.println(uladzimir.getClass().isRecord()); // true
        System.out.println(Arrays.toString(uladzimir.getClass().getRecordComponents())); // [java.lang.String name, int age]
        System.out.println(uladzimir);
    }
}
