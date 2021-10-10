public class Java17Runner {
    public static void main(String[] args) {
        Person uladzimir = new Person("Uladzimir", 29, Person.Mood.OK);
        java17PatternMatchingSayHello(uladzimir);

        Person jack = new Person("Jack");
        futureJavaVersionPatternMatchingSayHello(jack);

        Worker john = new Developer();
        introduceWorker(john);
    }

    private static void java17PatternMatchingSayHello(Object somebody) {
        String message;
        if (somebody instanceof Person asPerson && asPerson.mood() != null) {
            message = switch (asPerson.mood()) {
                case NOT_BAD, HAPPY -> "Hello";
                case SAD -> "What's up?";
                case OK -> {
                    var name = asPerson.name().toUpperCase();
                    yield "HI %s".formatted(name);
                }
            };
        } else {
            message = "Q";
        }
        System.out.println(message);
    }

    private static void futureJavaVersionPatternMatchingSayHello(Object somebody) {
        var message = switch (somebody) {
            case null -> "Go away, nobody";
            case Person asPerson && asPerson.mood() == Person.Mood.NOT_BAD || asPerson.mood() == Person.Mood.HAPPY -> "Hello";
            case Person asPerson && asPerson.mood() == Person.Mood.SAD -> "What's up?";
            case Person asPerson && asPerson.mood() == Person.Mood.OK -> {
                var name = asPerson.name().toUpperCase();
                yield "HI %s".formatted(name);
            }
            default -> "Q";
        };
        System.out.println(message);
    }

    private static void introduceWorker(Worker worker) {
        var answer = switch (worker) {
            case Developer d -> "Write code";
            case Tester t -> "Test code";
            case Manager m -> "Manage code";
        };
        System.out.println(worker.describeWork() + "My responsibilities: " + answer);
    }
}
