import java.util.Scanner;

public class TikTakTowPlay {

    public static void main(String[] args) {
        boolean single = true;
        TikTakTowPlay play = new TikTakTowPlay();

        if (single){
            play.playGameSingleplayer();
        }else {
            play.playGameMultiplayer();
        }

    }

    // playGame : user input - ai input with callAI(), while loop
    private void playGameSingleplayer(){


        TikTakTow game = new TikTakTow();
        game.prepareGame();
        TikTakTowMinimax ai = new TikTakTowMinimax(game);

        boolean notFinished = true;

        while (notFinished){

            //player move
            boolean playerplaced = false;
            int[] input = getInput();

            int row = input[0];
            int col = input[1];

            if(game.placeTTT(row, col, 1)){
                
                playerplaced = true;
                
                int result = game.checkWin();
                if (result != 0) {
                    if (result == 3) {
                        System.out.println();
                        System.out.println("Game is a tie");
                    } else {
                        System.out.println();
                        System.out.println("Game won by " + result);
                    }

                    notFinished = false;
                }
                
            }


            //ai move
            if (playerplaced){
                int[] aiInput = ai.bestMove(game.getBoard());
                int aiRow = aiInput[0];
                int aiCol = aiInput[1];
    
                if(game.placeTTT(aiRow, aiCol, 2)){
                    
                    int result = game.checkWin();
                    if (result != 0) {
                        if (result == 3) {
                            System.out.println();
                            System.out.println("Game is a tie");
                        } else {
                            System.out.println();
                            System.out.println("Game won by " + result);
                        }
                        notFinished = false;
                    }
                }
                game.printBoard();
            }
        }
    }

    private void playGameMultiplayer(){


        TikTakTow game = new TikTakTow();
        game.prepareGame();

        boolean notFinished = true;

        int playersymbol = 1;

        while (notFinished){

            int[] input = getInput();

            int row = input[0];
            int col = input[1];

            
            if(game.placeTTT(row, col, playersymbol)){
                game.printBoard();
                
                int result = game.checkWin();
                if(result != 0){
                    System.out.println();
                    System.out.println("Game won by " +  result);
                    notFinished = false;
                }

                if(playersymbol == 1){
                    playersymbol = 2;
                }else {
                    playersymbol = 1;
                }
            }    
        }
    }

    private int[] getInput(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("X: ");
        int row = scanner.nextInt();
        System.out.print("Y: ");
        int col = scanner.nextInt();
        return new int[] {row, col};
    }
}
