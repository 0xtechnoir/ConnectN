import java.util.List;

public class Board {

    private final char[][] board;
    private final int numCols;
    private final int numRows;

    public Board(){
        this.board = new char[6][7];
        this.numCols = board[0].length;
        this.numRows = board.length;
    }

    public String printBoard(){

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numRows; i++){ // 0 to 5
            for(int j = 0; j < numCols; j++){
                if(board[i][j] == 'r'){
                    sb.append("| r ");
                }
                else if(board[i][j] == 'y'){
                    sb.append("| y ");
                }
                else{
                    sb.append("|   ");
                }
            }
            sb.append("|\n");
        }
        sb.append("  1   2   3   4   5   6   7\n");

        return sb.toString();
    }

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

    public boolean hasPlayerWon(Player player) {

        GameUtils checker = new GameUtils(board);

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

    public Player switchPlayer(Player currentPlayer, List<Player> players) {

        Player nextPlayer;

        if (currentPlayer.equals(players.get(0))) {
            nextPlayer = players.get(1);
        } else {
            nextPlayer = players.get(0);
        }

        return nextPlayer;
    }
}
