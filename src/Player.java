abstract class Player {

    private final char token;
    private final String name;

    public Player(char token, String name) {
        this.token = token;
        this.name = name;
    }

    public char getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public abstract int takeTurn();

}
