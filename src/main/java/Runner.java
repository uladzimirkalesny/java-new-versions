import java14.Person;

import java.util.Arrays;
import java.util.Locale;

import static java14.Person.Mood.BAD;
import static java14.Person.Mood.WOW;

public class Runner {
    //language=SQL
    private static final String SQL = "select * from table where id > 2";
    private static final String MESSAGE_PATTERN = """
            Good Morning mr. %s
            You old pattern here
            add something new
        """;

    public static void main(String[] args) {
        final Person uladzimir = new Person("Uladzimir", 28, WOW);
        System.out.println(uladzimir.getClass().isRecord()); // true
        System.out.println(Arrays.toString(uladzimir.getClass().getRecordComponents())); // [java.lang.String name, int age]
        System.out.println(uladzimir);

        sayHello(uladzimir);
        sayHello("Davy Jones");

        final Person nullablePerson = new Person(null, 24, BAD);
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
     *
     * @param somebody
     */
    private static void sayHello(final Object somebody) {
        final String message;
        // Look at the new instanceof and declaration
        if (somebody instanceof Person person && person.mood() != null) {
            message = switch (person.mood()) {
                case BAD -> "Hi, bro!";
                case SAD -> "Good, boy";
                case HAPPY, OK -> "Yo!";
                case WOW -> {
                    final String name = person.name().toUpperCase(Locale.ENGLISH);
                    yield MESSAGE_PATTERN.formatted(name);
                }
            };
        } else {
            message = somebody.toString();
        }
        System.out.println(message);
    }

    /*
     * -XX:+UseConcMarkSweepGC was removed from java 14
     * -XX:+UseParallelGC was deprecated from java 14
     * -XX:+UseParallelOldGC was deprecated from java 14
     * -XX:+UnlockExperimentalVMOptions -XX:+UseZGC new GC from java 11, but java 14 gave us windows and macOS support
     */
}
