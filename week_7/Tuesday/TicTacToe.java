public final class TicTacToe extends TwoPlayerBoardGame {
    private char XO = 'X';
    private int row;
    private int col;

    public TicTacToe(Player p1, Player p2) {
        // initialize the board
        // MAX_MOVES: 9
        super(null, 0, p1, p2);
        // for TicTacToe, the board is a 3x3 2D char array
        // you may initliaze every element as ' '
    }

    public String toString() {
        // print the board to the terminal,
        // its format should look like this:
        //  | | 
        // -----
        //  | | 
        // -----
        //  | | 
        return "";
    }


    protected void askForMove() {
        // print some text prompt to the terminal
        // e.g.
        // Student, it's your move and you're Xs.
        // Please choose your move by typing row col where row is 0, 1, or 2 and col is 0, 1, or 2.
    }

    protected void receiveMove() {
        row = console.nextInt();
        col = console.nextInt();
    }

    protected void generateMove() {
        row = Math.abs(random.nextInt()) % 3;
        col = Math.abs(random.nextInt()) % 3;
    }

    protected boolean validMove() {
        // 1. check if the position is outside of the board
        // 2. check if the position has already been occupied by a previous move
        return true;
    }

    protected void applyMove() {
        // simply modify the corresponding eleemnt in 2d array char
        // either 'X' or 'O'
    }

    protected boolean someoneWon() {
        // identity if a certain row, col or diagonal
        // has been all occupied by 'X' or 'O'
        return false;
    }

    protected void celebrateMove() {
        // ask you to print some text promt to the terminal
        // e.g.
        // That was a winning move!
        // Student (X) wins!
    }

    protected void prepareForNextMove() {
        // make use of the super keyword to call prepareForNextMove from parent class
        // change the var XO
        // either from 'X' to 'O', or from 'O' to 'X'
    }
}