public enum Token {
    HUMAN_PLAYER('x'),
    COMPUTER_PLAYER1('o'),
    COMPUTER_PLAYER2('$');

    public final char label;

    Token(char label) {
        this.label = label;
    }
}
