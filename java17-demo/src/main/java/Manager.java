// non-sealed we open this class for extending
// if we want to close this class for extending we should to make it as sealed and specify permits or continue with final/record approach.
public non-sealed class Manager implements Worker {
    @Override
    public String describeWork() {
        return "I am asking annoying questions";
    }
}
