import java14.Person;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        final Person uladzimir = new Person("Uladzimir", 28);
        System.out.println(uladzimir.getClass().isRecord()); // true
        System.out.println(Arrays.toString(uladzimir.getClass().getRecordComponents())); // [java.lang.String name, int age]
        System.out.println(uladzimir);

        final Person nullablePerson = new Person(null, 24);
        System.out.println(nullablePerson.name().isBlank()); // nullablePerson.name() -> NPE
        // If you want to defend yourself with NPE you can add into
        // "Edit Configuration|VM Options" key -> -XX:+ShowCodeDetailsInExceptionMessages
        // Cannot invoke "String.isBlank()" because the return value of "java14.Person.name()" is null
        // Why we dont use that features by default in the production profile?
        // Security(message with internal code)!
        // Performance (collection Info)!
        // Compatibility
    }
}
