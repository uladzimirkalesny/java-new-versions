import java14.Person;

import java.util.Arrays;
import java.util.Locale;

public class Runner {
    public static void main(String[] args) {
        final Person uladzimir = new Person("Uladzimir", 28, Person.Mood.HAPPY);
        System.out.println(uladzimir.getClass().isRecord()); // true
        System.out.println(Arrays.toString(uladzimir.getClass().getRecordComponents())); // [java.lang.String name, int age]
        System.out.println(uladzimir);

        sayHello(uladzimir);

        final Person nullablePerson = new Person(null, 24, Person.Mood.BAD);
        System.out.println(nullablePerson.name().isBlank()); // nullablePerson.name() -> NPE
        // If you want to defend yourself with NPE you can add into
        // "Edit Configuration|VM Options" key -> -XX:+ShowCodeDetailsInExceptionMessages
        // Cannot invoke "String.isBlank()" because the return value of "java14.Person.name()" is null
        // Why we dont use that features by default in the production profile?
        // Security(message with internal code)!
        // Performance (collection Info)!
        // Compatibility
    }

    /**
     * New switch expression
     * @param person
     */
    private static void sayHello(final Person person) {
        final String message = switch (person.mood()) {
            case BAD -> "Hi, bro!";
            case SAD -> "Good, boy";
            case HAPPY, OK -> "Yo!";
            case WOW -> {
                final String name = person.name().toUpperCase(Locale.ENGLISH);
                yield "Hi, " + name;
            }
        };
        System.out.println(message);
    }
}
