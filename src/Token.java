public enum Token {
    HUMAN_PLAYER('r'),
    COMPUTER_PLAYER1('y'),
    COMPUTER_PLAYER2('g');

    public final char label;

    Token(char label) {
        this.label = label;
    }
}
