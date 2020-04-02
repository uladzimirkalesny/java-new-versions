package java14;

/**
 * public final class Person extends java.lang.Record {
 *      private final java.lang.String name;
 *      private final int age;
 *      public Person(java.lang.String name, int age)
 *      public java.lang.String toString()
 *      public final int hashCode()
 *      public final boolean equals(java.lang.Object o)
 *      public java.lang.String name()
 *      public int age()
 * }
 * We can implements interfaces
 * We can define any other methods
 * We can declare static constants
 * We can override any methods (hashcode, equals, toString) and so on
 * But we cannot to use extends
 */
public record Person(String name, int age) {
    private static final int DEFAULT_AGE = 28;

    /**
     * Canonical constructor
     * @param name
     * @param age
     */
//    public Person(final String name, final int age) {
//        this.name = name;
//        this.age = age;
//    }


    public Person(final String name) {
        this(name, DEFAULT_AGE);
    }

    /**
     * Compact constructor
     * @param name
     * @param age
     */
    public Person {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age " + age);
        }
    }
}
