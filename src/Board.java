import java.util.List;

/**
 * A class to create and maintain the state of the game board
 */
public class Board {

    private final char[][] board;
    private final int numCols;
    private final int numRows;
    private final int winStreak;

    /**
     * The Board class constructor
     * @param winStreak the length of a winning sequence of tokens.
     */
    public Board(int winStreak){
        this.board = new char[6][7];
        this.numCols = board[0].length;
        this.numRows = board.length;
        this.winStreak = winStreak;
    }

    /**
     * Returns the current state of the board as a string for the calling method to print
     * @return the string to print
     */
    public String returnPrintableBoard(){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){

                // if value at array index is not the default char '\u0000 print the value held at the index.
                if (board[i][j] != '\u0000') {
                    sb.append("| ").append(board[i][j]).append(" ");
                } else {
                    sb.append("|   ");
                }
            }
            sb.append("|\n");
        }
        sb.append("  1   2   3   4   5   6   7\n");
        return sb.toString();
    }

    /**
     * Method to place a player token in a specified column on the board.
     * Tokens will be placed in the first available row within the column.
     * If a token is successfully placed the method returns true. If the
     * column is full the method returns false.
     * @param player the player whose turn it currently is
     * @param position the column in which to place the token.
     * @return the result of the token placing.
     */
    public boolean placeToken(Player player, int position){

        boolean placed = false;

        int row = numRows-1;

        while(!placed) {

            if(row < 0) {
                break;
            }

            if (board[row][position-1] == '\u0000') {
                board[row][position-1] = player.getToken();
                placed = true;
            }

            row--;
        }
        return placed;
    }

    /**
     * A method to determine whether a player has won the game.
     * Instantiates a new GameUtils object and calls its methods to check for winning streaks
     * in the horizontal and vertical planes, as well as ascending and descending diagonal directions.
     * @param player the player who's turn is currently is
     * @return boolean value telling whether the player has won or not.
     */
    public boolean hasPlayerWon(Player player) {

        GameUtils checker = new GameUtils(board, winStreak);

        if (checker.checkHorizontal(player)) {
            return true;
        }

        if (checker.checkVertical(player)) {
            return true;
        }

        if (checker.checkAscendingDiagonal(player)) {
            return true;
        }

        if (checker.checkDescendingDiagonal(player)) {
            return true;
        }

        return false;
    }

    /**
     * A method to switch the current player to the next player.
     * @param currentPlayer the player whose turn it currently is
     * @param players list object containing all players
     * @return the next player as a Player object
     */
    public Player switchPlayer(Player currentPlayer, List<Player> players) {

        Player nextPlayer;

        if (currentPlayer.equals(players.get(0))) {
            nextPlayer = players.get(1);
        } else if (currentPlayer.equals(players.get(1))) {
            nextPlayer = players.get(2);
        } else {
            nextPlayer = players.get(0);
        }

        return nextPlayer;
    }

    /**
     * Method to check whether there are any spaces left to place a token
     * on the board
     * @return boolean value showing whether there are spaces available
     */
    public boolean isBoardFull() {

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {

                // if value at array index is equal to the default char '\u0000' the board is not full
                if (board[i][j] == '\u0000') {
                    return false;
                }
            }
        }

        return true;
    }

}
