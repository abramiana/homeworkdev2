import java.util.Scanner;

public class TicTacToeGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGameBoard gameBoard = new TicTacToeGameBoard();
        System.out.println("Welcome to the game Crosswords!");
        System.out.println("Enter the number you want to put 'X' in the console");
        while (true) {
            gameBoard.displayBoard();
            gameBoard.clearBoard();
            gameBoard.makePlayerMove(scanner);
            if (gameBoard.isGameEnded()) {
                gameBoard.displayBoard();
                gameBoard.announceResult();
                break;
            }
            gameBoard.makeComputerMove();
            if (gameBoard.isGameEnded()) {
                gameBoard.displayBoard();
                gameBoard.announceResult();
                break;
            }
        }
        scanner.close();
    }
}