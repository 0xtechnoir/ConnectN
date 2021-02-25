public class GameUtils {

    char[][] board;
    int maxWidth;
    int maxHeight;

    public GameUtils(char[][] board) {
        this.board = board;
        this.maxWidth = board[0].length;
        this.maxHeight = board.length;
    }

    public boolean checkHorizontal(Player player) {
        int count;
        for (int i = 0; i < maxHeight; i++) {
            count = 0;
            for (int j = 0; j < maxWidth; j++) {
                if (board[i][j] == player.getToken()) {
                    count++;
                    if (count >= 4) {
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

    public boolean checkVertical(Player player) {
        int count;
        for(int i = 0; i < maxWidth; i++){
            count = 0;
            for(int j = 0; j < maxHeight; j++){
                if(board[j][i] == player.getToken()){
                    count++;
                    if(count >= 4){
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

    public boolean checkAscendingDiagonal(Player player) {
        int count;
        for (int rowStart = 3; rowStart < maxHeight; rowStart++) {
//            count = 0;
            for (int colStart = 0; colStart < maxWidth - 3; colStart++) {
                count = 0;
                for (int row = rowStart, col = colStart, i=0; i <= 3; row--, col++, i++) {
                    if(board[row][col] == player.getToken()){
                    count++;
                    if(count >= 4) {
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

    public boolean checkDescendingDiagonal(Player player) {
        int count;
        for (int rowStart = 0; rowStart < maxHeight - 3; rowStart++) {
//            count = 0;
            for (int colStart = 0; colStart < maxWidth - 3; colStart++) {
                count = 0;
                for (int row = rowStart, col = colStart, i=0; i <= 3; row++, col++, i++) {
                    if(board[row][col] == player.getToken()){
                    count++;
                    if(count >= 4) {
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
