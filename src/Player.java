abstract class Player {

    private final Token token;
    private final String name;

    /**
     * Player class constructor
     * @param token the token value of the player
     * @param name
     */
    public Player(Token token, String name) {
        this.token = token;
        this.name = name;
    }

    /**
     * Public accessor method for a players token value
     * @return the players token char label
     */
    public char getToken() {
        return token.label;
    }

    /**
     * Public accessor method for a players name value
     * @return the players string name value
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method for taking a turn. Implementation to be provided by subclasses.
     * @return the col number to place token
     */
    public abstract int takeTurn();

}
