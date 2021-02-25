import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

    public HumanPlayer(char token, String name) {
        super(token, name);
    }

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
