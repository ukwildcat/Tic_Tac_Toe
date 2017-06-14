package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    private char[][] board;

    public TicTacToe() {
        board = new char[3][3];

        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String s = "" + count++;
                board[i][j] = s.charAt(0);
            }
        }
    }

    public boolean move(int row, int col, char symbol) {

        if (row < 0 || row > 2 || col < 0 || col > 2
                || (symbol != 'X' && symbol != 'O')) {
            return false;
        }

        if (Character.isDigit(board[row][col])) { // if this isn't an X or O...
            System.out.println("DEBUG: Character.isDigit(" + board[row][col] + ")is true");
            board[row][col] = symbol;
            return true;
        } else {
            return false;
            
        }

    }

    public boolean move(int square, char symbol) {
        // figure out row and col
        // square = 1, 4, 7 => col = 0
        // square = 2, 5, 8 => col = 1
        // square = 3, 6, 9 => col = 2
        int row = (square - 1) / 3;
        int col = (square - 1) % 3;
        return move(row, col, symbol);
    }

    public boolean isGameOver() {
        // horizontal tic-tac-toe
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // vertical
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        // upper left to lower right
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        // upper right to lower left
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
    
    


    public Boolean isTie() {
        // tie (board is full)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                  
                }
                {
                    System.out.println("The game is a tie");
                    return true;
                }
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Boolean isValid = false;
        TicTacToe game = new TicTacToe();

        System.out.print("What is your name? ");
        String name = input.nextLine();

        HumanPlayer hp = new HumanPlayer(name, 'O');
        ComputerPlayer cp = new ComputerPlayer("Eve", 'X');

        while (!game.isGameOver() || (!game.isTie())) {

            game.display();
            hp.move(game);
            cp.move(game);

        }
        game.display();
        
    }

}
