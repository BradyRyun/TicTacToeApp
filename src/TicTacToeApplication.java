import java.util.Scanner;

public class TicTacToeApplication {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        // Allow for continuous games
        boolean doYouWantToPlay = true;
        while (doYouWantToPlay) {
            System.out.println("Welcome to Tic Tac Toe!");
            System.out.println("You will be playing against a computer that will.");
            System.out.println("Are you ready to play?");
            System.out.println("Please select which character you'd like to play as?");
            // Initializing the variables with random variables.
            char playerToken = sc.next().toLowerCase().charAt(0);
            System.out.println("Now select a token for the computer to use");
            char compToken = sc.next().toLowerCase().charAt(0);
            System.out.println("Let's play!");
            TicTacToe game = new TicTacToe(playerToken, compToken);
            AI ai = new AI();


            System.out.println("To play, enter a number and your marker will be set in place.\n" +
                    "The numbers go from 1-9 from left to right. Let's see what happens this round!");
            // Setting up the game.
            TicTacToe.printIndexBoard();
            System.out.println();
            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    // User turn
                    System.out.println("It's your turn! Enter a spot for your marker");
                    int spot = sc.nextInt();
                    while (!game.playTurn(spot)) {
                        System.out.println("Try again " + spot + " is already taken or is invalid.");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");

                } else {
                    // AI Turn
                    System.out.println("It's my turn!");
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked" + aiSpot);
                }
                game.printBoard();
            }

            System.out.println(game.gameOver());
            System.out.println("Do you want to play again? (Enter Y to play again or any other character to stop)");
            char response = sc.next().toLowerCase().charAt(0);
            doYouWantToPlay = (response == 'y');
            System.out.println();

        }
    }
}
