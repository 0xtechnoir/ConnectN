import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ComputerPlayer extends Player {

    Random random = new Random();

    public ComputerPlayer(char token, String name) {
        super(token, name);
    }

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
