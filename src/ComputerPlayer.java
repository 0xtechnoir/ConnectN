import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * A class extending the abstract Player class. Provides implementation details to takeTurn abstract method.
 * ComputerPlayer objects will randomly place tokens in one of the 7 columns.
 */
public class ComputerPlayer extends Player {

    Random random = new Random();

    /**
     * ComputerPlayer constructor
     * @param token the token value assigned to the player
     * @param name the name of the player
     */
    public ComputerPlayer(Token token, String name) {
        super(token, name);
    }

    /**
     * Randomly generates a column number between 1 and 7 (inclusive)
     * @return the random column number
     */
    @Override
    public int takeTurn() {

        // add a short delay to enhance the user experience for the human player
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextInt(7)+1;
    }

}
