import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A class extending the abstract Player class. Provides implementation details to takeTurn abstract method.
 * HumanPlayer objects will accept input from the command line to allow players to specify a column.
 */
public class HumanPlayer extends Player {

    /**
     * HumanPlayer constructor
     * @param token the token value assigned to the player
     * @param name the name of the player
     */
    public HumanPlayer(Token token, String name) {
        super(token, name);
    }

    /**
     * Accepts command line input from the user
     * @return the chosen column
     */
    @Override
    public int takeTurn() {
        int move = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        try {
            move = Integer.parseInt(input.readLine());

            // if move is not within the bounds of the board
            // throw an exception up the stack to the calling method
            if (move < 1 || move > 7) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
        catch(IOException e){
            System.out.println(e);
            System.out.println("An I/O error occurred");
        }
        return move;
    }

}
