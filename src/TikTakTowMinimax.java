public class TikTakTowMinimax {

    TikTakTow game;

    TikTakTowMinimax(TikTakTow game){
        this.game = game;
    }


    public int[] bestMove(int[][] board){
        int[] bestMove = new int[2];
        int bestScore = -Integer.MAX_VALUE;

        for (int i = 0; i < game.getBoard().length; i++) {

            for (int j = 0; j < game.getBoard().length; j++) {

                if (board[i][j] == 0){
                    board[i][j] = 2;
                    int score = miniMax(board, false);
                    board[i][j] = 0;
                
                    if (score > bestScore){
                        bestScore = score;
                        bestMove = new int[] {i,j};
                    }
                }
            }
        }
        return bestMove;
    }

    private int miniMax(int[][] board, boolean isMaximizing){
        int result = game.checkWin();
        if (result != 0 ){
            if(result == 1){
                return -1;
            }if (result == 2) {
                return 1;
            }else {
                return 0;
            }
        }

        if(isMaximizing){
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < game.getBoard().length; i++) {

                for (int j = 0; j < game.getBoard().length; j++) {
    
                    if (board[i][j] == 0){
                        board[i][j] = 2;
                        int score = miniMax(board, false);
                        board[i][j] = 0;
                    
                        if (score > bestScore){
                            bestScore = score;
                            
                        }
                    }
                }
            }
            return bestScore;
        }else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < game.getBoard().length; i++) {

                for (int j = 0; j < game.getBoard().length; j++) {
    
                    if (board[i][j] == 0){
                        board[i][j] = 1;
                        int score = miniMax(board, true);
                        board[i][j] = 0;
                    
                        if (score < bestScore){
                            bestScore = score;
                            
                        }
                    }
                }
            }
            return bestScore;
        }
        

        
    }
    

}
