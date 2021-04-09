/**
 * A utility class containing methods to detect winning sequences of token
 * on the board.
 */
public class GameUtils {

    char[][] board;
    int boardWidth;
    int boardHeight;

    /**
     * The length of a continuous line a single token type required to win.
     * Passed into the application as a command line argument
     */
    int winStreak;


    /** Used by the diagonal checkers to calculate the col and row boundaries
     * within which a winning streak is possible.
     */
    int offSet;

    /**
     * GameUtils constructor. A utility class containing methods to detect winning sequences of token
     * on the board.
     * @param board the board to check
     * @param winStreak the length of a win sequence
     */
    public GameUtils(char[][] board, int winStreak) {
        this.board = board;
        this.boardWidth = board[0].length;
        this.boardHeight = board.length;
        this.winStreak = winStreak;
        this.offSet = winStreak-1;
    }

    /**
     * A method to check whether the most recent move has resulted in a
     * winning streak of tokens in the horizontal plane.
     * @param player the player whose turn it currently is
     * @return a boolean value representing whether or not a player has won.
     */
    public boolean checkHorizontal(Player player) {
        int count;
        for (int i = 0; i < boardHeight; i++) {
            count = 0;
            for (int j = 0; j < boardWidth; j++) {
                if (board[i][j] == player.getToken()) {
                    count++;
                    if (count >= winStreak) {
                        System.out.println("horizontal win");
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    /**
     * A method to check whether the most recent move has resulted in a
     * winning streak of tokens in the vertical plane.
     * @param player the player whose turn it currently is
     * @return a boolean value representing whether or not a player has won.
     */
    public boolean checkVertical(Player player) {
        int count;
        for(int i = 0; i < boardWidth; i++){
            count = 0;
            for(int j = 0; j < boardHeight; j++){
                if(board[j][i] == player.getToken()){
                    count++;
                    if(count >= winStreak){
                        System.out.println("vertical win");
                        return true;
                    }
                }else{
                    count = 0;
                }
            }
        }
        return false;
    }

    /**
     * A method to check whether the most recent move has resulted in a
     * winning streak of tokens in the ascending diagonal direction (left - right).
     * @param player the player whose turn it currently is
     * @return a boolean value representing whether or not a player has won.
     */
    public boolean checkAscendingDiagonal(Player player) {
        int count;

        // define rows to loop through using offset value
        for (int rowStart = offSet; rowStart < boardHeight; rowStart++) {

            // define cols to loop through using offset value
            for (int colStart = 0; colStart < boardWidth - offSet; colStart++) {
                count = 0;

                // move through ascending diagonal patterns of length winStreak
                for (int row = rowStart, col = colStart, i=0; i < winStreak; row--, col++, i++) {
                    if(board[row][col] == player.getToken()){
                    count++;
                    if(count >= winStreak) {
                        System.out.println("ascending diagonal win");
                        return true;
                    }
                }
                else break;
                }
            }
        }
        return false;
    }

    /**
     * A method to check whether the most recent move has resulted in a
     * winning streak of tokens in the descending diagonal direction (right - left).
     * @param player the player whose turn it currently is
     * @return a boolean value representing whether or not a player has won.
     */
    public boolean checkDescendingDiagonal(Player player) {
        int count;

        // define rows to loop through using offset value
        for (int rowStart = 0; rowStart < boardHeight - offSet; rowStart++) {

            // define cols to loop through using offset value
            for (int colStart = 0; colStart < boardWidth - offSet; colStart++) {
                count = 0;

                // move through descending diagonal patterns of length winStreak
                for (int row = rowStart, col = colStart, i=0; i < winStreak; row++, col++, i++) {
                    if(board[row][col] == player.getToken()){
                    count++;
                    if(count >= winStreak) {
                        System.out.println("descending diagonal win");
                        return true;
                    }
                }
                else break;
                }
            }
        }
        return false;
    }
}
