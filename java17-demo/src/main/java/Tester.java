public record Tester(String type) implements Worker {
    @Override
    public String describeWork() {
        return "I tested everything %s".formatted(type);
    }
}
