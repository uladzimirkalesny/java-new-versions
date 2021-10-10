public sealed interface Worker permits Developer, Tester, Manager {

    String describeWork();

}

// final provides fully finalized worker implementation that represent last implementation from Worker interface.
final class Developer implements Worker {

    @Override
    public String describeWork() {
        return """
                I am a developer,
                I will try to write code.
                """;
    }

}
