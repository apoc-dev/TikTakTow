public class TikTakTow {

    //global vars
    int[][] board;

    // prepareGame : init board
    public void prepareGame(){
        this.board = new int[][]
                {{0,0,0},
                {0,0,0},
                {0,0,0}};
    }

    public int[][] getBoard(){
        return this.board;
    }

    // isValid : returns a bool when the placement is valid
    private boolean isValid(int row, int col){

        if(board[row][col] != 0){
            return false;
        }

        return true;
    }


    // placeTTT : calls isValid return true if placed
    public boolean placeTTT(int row, int col, int playerSymbol){

        if (isValid(row, col)){
            board[row][col] = playerSymbol;
            return true;
        }

        return false;
    }

    // checkWin : returns int 0, 1, 2, 3 (0=notfinished, 1=playerone, 2=playertwo, 3=tie)
    public int checkWin() {

        // check horizontal
        for (int row = 0; row < board.length; row++) {

            boolean isFirstElementNull = board[row][0] == 0;
            boolean flag = true;

            for (int col = 0; col < board.length; col++) {

                if (isFirstElementNull) {
                    flag = false;
                } else {

                    if (board[row][0] != board[row][col]) {
                        flag = false;
                    }
                }
            }
            if (flag){
                return board[row][0];
            }
        }

        // check vertical
        for (int col = 0; col < board.length; col++) {

            boolean isFirstElementNull = board[0][col] == 0;
            boolean flag = true;

            for (int row = 0; row < board.length; row++) {

                if (isFirstElementNull) {
                    flag = false;
                } else {

                    if (board[0][col] != board[row][col]) {
                        flag = false;
                    }
                }
            }
            if (flag){
                return board[0][col];
            }
        }

        // check diagonal 1
        boolean diagonal1 = true;
        for (int i = 0; i < board.length; i++) {

            boolean isFirstElementNull = board[0][0] == 0;

            if (isFirstElementNull) {
                diagonal1 = false;
            } else {

                if (board[0][0] != board[i][i]) {
                    diagonal1 = false;
                }
            }
        }
        if (diagonal1){
            return board[0][0];
        }

        boolean diagonal2 = true;
        // check diagonal 2
        for (int i = 0,j = board.length-1; i < board.length; i++,j--) {

            boolean isFirstElementNull = board[0][board.length-1] == 0;

            if (isFirstElementNull) {
                diagonal2 = false;
            } else {

                if (board[0][2] != board[i][j]) {
                    diagonal2 = false;
                }
            }
        }

        if (diagonal2){
            return board[0][2];
        }


        boolean tie = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0){
                    tie = false;
                }
            }
        }
        if (tie){
            return 3;
        }
        return 0;
    }


    // printBoard : prints game board
    public void printBoard(){
        System.out.println();
        for (int[] row: board) {
            System.out.print("|");
            for (int col = 0; col < row.length; col++) {
                if(row[col] == 0){
                    System.out.print(" ");
                }else {
                    if(row[col] == 1){
                        System.out.print("X");
                    }
                    if(row[col] == 2){
                        System.out.print("O");
                    }
                }
                System.out.print("|");
                    
            }
            System.out.println();
        }
        System.out.println();
    }
}
