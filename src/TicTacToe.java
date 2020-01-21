import java.util.Arrays;

public class TicTacToe {
    protected char[] board;
    protected char userMarker;
    protected char compMarker;
    protected char winner;
    protected char currentMarker;

    public TicTacToe(char playerToken, char compToken) {
        this.userMarker = playerToken;
        this.compMarker = compToken;
        winner = '-';
        this.board = setBoard();
        this.currentMarker = userMarker;
    }

    public static char[] setBoard() {
        char[] board = new char[9];
        // Fill the board with '-'
        Arrays.fill(board, '-');
        System.out.println(board);
        return board;
    }
    public boolean playTurn(int spot) {
        boolean isValid = withinRange(spot) && !spotTaken(spot);
        if (isValid) {
            board[spot-1] = currentMarker;
            currentMarker = (currentMarker == userMarker) ? compMarker : userMarker;
        }
        return isValid;
    }
    // checking if the spot choice is within range
    public boolean withinRange(int spot) {
        return spot > 0 && spot <= 9;
    }

    // checking if spot is taken - returns true if spot is taken. else false
    public boolean spotTaken(int spot) {
        return board[spot-1] != '-';
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if(i % 3 == 0 && i != 0) {
                System.out.print(" | ");
                System.out.println();
                System.out.println(" -------------");
            }
            System.out.print(" | " + board[i]);
            if(i == 8) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
    public static void printIndexBoard() {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            if(i % 3 == 0 && i != 0) {
                System.out.print(" | ");
                System.out.println();
                System.out.println(" -------------");
            }
            System.out.print(" | " + (i+1));
            if(i == 8) {
                System.out.print(" | ");
            }
        }
        System.out.println();
    }
    // Checks if someone has won.
    public boolean isWon() {
        boolean diagonalsAndMid = (rightDi() || leftDi() || middleRow() || secondCol()) && board[4] != '-';
        boolean topAndFirst = (topRow() || firstCol()) && board[0] != '-';
        boolean bottomAndThird = (bottomRow() || thirdCol()) && board[8] != '-';
        if (diagonalsAndMid) {
            this.winner = board[4];
        } else if (topAndFirst) {
            this.winner = board[0];
        } else if (bottomAndThird) {
            this.winner = board[8];
        }
        return diagonalsAndMid || topAndFirst || bottomAndThird;
    }
    public boolean topRow() {
        return board[0] == board[1] && board[1] == board[2];
    }
    public boolean middleRow() {
        return board[3] == board[4] && board[4] == board[5];
    }
    public boolean bottomRow() {
        return board[6] == board[7] && board[7] == board[8];
    }
    // Checking diagonals for a win.
    public boolean rightDi() {
        return board[0] == board[4] && board[4] == board[8];
    }
    public boolean leftDi() {
        return board[2] == board[4] && board[4] == board[6];
    }
    // Checking columns for a win.
    public boolean firstCol() {
        return board[0] == board[3] && board[3] == board[6];
    }
    public boolean secondCol() {
        return board[1] == board[4] && board[4] == board[7];
    }
    public boolean thirdCol() {
        return board[2] == board[5] && board[5] == board[8];
    }

    // Check if the board is filled
    public boolean isFilled() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
            return true;
    }
    public String gameOver() {
        boolean didSomeoneWin = isWon();
        if (didSomeoneWin) {
            return "We have a winner! The winner is " + this.winner + ".";
        } else if (isFilled()) {
            return "Draw! Game over!";
        } else {
            return "notOver";
        }
    }
}
