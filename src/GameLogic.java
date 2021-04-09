import java.util.ArrayList;

/**
 * A class defining the logic of a ConnectN game.
 */
public class GameLogic {

    private final int winStreak;
    private final Board board;

    /**
     * The GameLogic constructor
     * @param winStreak the length of a win streak
     */
    public GameLogic(int winStreak) {
        board = new Board(winStreak);
        this.winStreak = winStreak;
    }

    /**
     * A method to start a game.
     */
    public void playGame(){
        System.out.println("Welcome to Connect " + winStreak);
        System.out.println("There are 3 players: r, y and g");
        System.out.println("Player 1 is r, Player 2 is y and Player 3 is g");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting " + winStreak +  " counters in a row - vertically, horizontally or diagonally\n");

        ArrayList<Player> players = createPlayers();
        Player currentPlayer = null;

        while(true){

            if (currentPlayer == null) {
                currentPlayer = players.get(0);
            }

            // check if board is full
            if (board.isBoardFull()) {
                System.out.println("No more spaces left - It's a draw");
                System.out.println(board.returnPrintableBoard());
                break;
            }

            System.out.println(currentPlayer.getName() + " it is your turn.");
            System.out.println(board.returnPrintableBoard());
            int col = 0;
            boolean inputIsValid = false;

            while(!inputIsValid) {
                try {
                    col = currentPlayer.takeTurn();
                    inputIsValid = true;
                } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Please make sure you enter a number between 1 and 7");
                    System.out.println("Try again " + currentPlayer.getName());
                    System.out.println(board.returnPrintableBoard());
                }
            }

            boolean placed = board.placeToken(currentPlayer,col);

            if (placed) {

                if(board.hasPlayerWon(currentPlayer)) {
                    System.out.println("Congratulations " + currentPlayer.getName() + ". You Have Won!!!");
                    System.out.println(board.returnPrintableBoard());
                    break;
                }
                currentPlayer = board.switchPlayer(currentPlayer, players);

            } else {
                System.out.println("Column " + col + " is full: please try a different column");
            }
        }
    }

    /**
     * A method to create a list of players
     * @return the list of players
     */
    public ArrayList<Player> createPlayers() {

        Player player1 = new HumanPlayer(Token.HUMAN_PLAYER, "Human Player");
        Player player2 = new ComputerPlayer(Token.COMPUTER_PLAYER1, "Computer Player 1");
        Player player3 = new ComputerPlayer(Token.COMPUTER_PLAYER2, "Computer Player 2");

        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);

        return players;
    }
}
