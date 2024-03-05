import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public final class TicTacToeGUI {
    public static void main(String[] args) {
        TicTacToeGUI t = new TicTacToeGUI();
    }

    private State state;
    private GUI gui;

    private void startNewGame() {
        if (gui != null) {
            gui.dispose();
        }
        state = new State();
        gui = new GUI();
    }

    // step 1. define our custom default constructor for TicTacToeGUI
    // we can simply call teh startNewGame in this default constructor
    // so that data members will be initialzed
    
    // State manages the logic part of this game
    private class State {
        private char XO = 'X';

        private void prepareForNextMove() {
            XO = (XO == 'X') ? 'O' : 'X';
        }

        private final char[][] board = new char[][] { { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' } };

        private void applyMove(int row, int col) {
            board[row][col] = XO;
        }

        private boolean someoneWon() {
            if (' ' != board[0][0] && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
                return true;
            }
            if (' ' != board[1][0] && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
                return true;
            }
            if (' ' != board[2][0] && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
                return true;
            }

            if (' ' != board[0][0] && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
                return true;
            }
            if (' ' != board[0][1] && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
                return true;
            }
            if (' ' != board[0][2] && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
                return true;
            }

            if (' ' != board[0][0] && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                return true;
            }
            if (' ' != board[0][2] && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
                return true;
            }

            return false;
        }

        private boolean boardFull() {
            return board[0][0] != ' ' && board[0][1] != ' ' && board[0][2] != ' ' &&
                    board[1][0] != ' ' && board[1][1] != ' ' && board[1][2] != ' ' &&
                    board[2][0] != ' ' && board[2][1] != ' ' && board[2][2] != ' ';
        }
    }

    // GUI is reponsible for the user interaction
    // step 2. provide a default constructor for class GUI
    // important parts
    // a. GUI is a subclass of JFrame, in the default contructor
    // set the basic setting for JFrame, e.g. setSize, setTitle, setDefaultCloseOperation and so on
    // b. make use to Grid layout for JFrame/JPanel, 3x3 grid
    // c. need to add 9 custom buttons (Tile) in total for this grid, inital text part ""

    // step 3. implement our custom button (Tile)
    // a. provde a row and col data member for Tile so that we can know which button we are clicking
    // b. provide a action listener for it
    // b1. implement our custom action listener, override the actionPerformed method
    // b2. tell what is the source button of this event (getSource())
    // b3. check if this button has been occupied by a previous move
    // b4. if occupied, show up a dialog telling user about this
    // b5. if not occupied, change the text part to be 'X' or 'O' by using setText() Method
    // b6. call processValidMove method to hanld status
    
    // step 4. change the status as well, this part should be implemented in processValidMove
    // if it's a draw, show up a dialog, start a new game
    // if someone wins, also show up a dialog, start a new game
    // if the game is not finished, prepare for the next move
    private class GUI extends JFrame {
        private class Tile extends JButton{
        }
    }

    private void processValidMove(int row, int col) {
    }
}