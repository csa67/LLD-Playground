package tictactoe;

import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    Game(Player player1, Player player2, int boardSize) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board(boardSize);
        this.currentPlayer = player1;
    }

    void play(){
        board.printBoard();

        while(!board.isFull()){
            System.out.println("Player " + currentPlayer.getName() + "'s turn'");
            int row = getValidInput("Enter row num (0-2)");
            int col = getValidInput("Enter col num (0-2)");

            try {
                // Only make the move if it's valid
                if(board.makeMove(row, col, currentPlayer)) {
                    board.printBoard();
                    if(board.checkWinner(row, col)){
                        System.out.println("Player " + currentPlayer.getName() + " wins!");
                        break;
                    } else {
                        switchPlayer();
                    }
                } // If move is invalid, the same player gets another turn.
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void switchPlayer(){
        if(currentPlayer == player1){ currentPlayer = player2; } else{ currentPlayer = player1; }
    }

    private int getValidInput(String message) {
        Scanner scanner = new Scanner(System.in);
        int input;

        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }
}
