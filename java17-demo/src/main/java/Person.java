public record Person(String name, Integer age, Mood mood) {

    private static final Integer DEFAULT_AGE = 30;

    public Person(String name) {
        this(name, DEFAULT_AGE, Mood.NOT_BAD);
    }

    public enum Mood {
        NOT_BAD, HAPPY, SAD, OK
    }

}
