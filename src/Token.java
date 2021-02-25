public enum Token {
    HUMAN_PLAYER('r'),
    COMPUTER_PLAYER('y');

    public final char label;

    Token(char label) {
        this.label = label;
    }
}
