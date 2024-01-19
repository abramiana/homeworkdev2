import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGameBoard {
    private final char[] board;
    private boolean boxEmpty = false;

    public TicTacToeGameBoard() {
        this.board = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        this.boxEmpty = false;
    }

    /**
     * Цей Метод відповідає за вивід стану гри (дошки) на консоль.  Після цього виводить саму дошку з поточним станом гри, де кожна
     * клітина відображається символом 'X', 'O' або номером клітини для введення.
     */
    public void displayBoard() {
        System.out.println();
        for (int i = 6; i >= 0; i -= 3) {
            System.out.println(" " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " ");
            if (i > 0) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    /**
     * цей метод очищає поля
     */
    public void clearBoard() {
        if (!boxEmpty) {
            Arrays.fill(board, ' ');
            boxEmpty = true;
        }
    }

    /**
     * Цей метод записує хід юзера по дефолту юзер ходить Х
     */
    public void makePlayerMove(Scanner scanner) {
        while (true) {
            System.out.println("Enter box number to select:");
            int input = scanner.nextInt();
            if (isValidMove(input)) {
                board[input - 1] = 'X';
                break;
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    /**
     * Хід комп'ютера
     */
    public void makeComputerMove() {
        while (true) {
            int rand = (int) (Math.random() * 9);
            if (board[rand] != 'X' && board[rand] != 'O') {
                board[rand] = 'O';
                break;
            }
        }
    }

    /**
     * Цей метод призначений для перевірки закінчення гри в Хрестики-Нолики.
     */
    public boolean isGameEnded() {
        return isWinner('X') || isWinner('O') || isBoardFull();
    }

    /**
     * Цей метод виводить результат гри в Хрестики-Нолики на консоль залежно від того, який гравець переміг або чи є
     * нічия
     */
    public void announceResult() {
        if (isWinner('X')) {
            System.out.println("You won the game!\nCreated by Abramian Artur. Thanks for playing!");
        } else if (isWinner('O')) {
            System.out.println("You lost the game!\nCreated by Abramian Artur. Thanks for playing!");
        } else {
            System.out.println("It's a draw!\nCreated by Abramian Artur. Thanks for playing!");
        }
    }

    private boolean isValidMove(int input) {
        return input > 0 && input < 10 && board[input - 1] != 'X' && board[input - 1] != 'O';
    }

    /**
     * Цей метод перевіряє, чи гравець з символом symbol переміг у грі.
     */
    private boolean isWinner(char symbol) {
        for (int[] combination : Cominations.COMBINATION) {
            if (areAllEqual(board[combination[0]], board[combination[1]], board[combination[2]], symbol)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Цей метод areAllEqual приймає символ symbol і набір символів values. Він перевіряє, чи всі значення в наборі
     * рівні заданому символу symbol
     */
    private boolean areAllEqual(char symbol, char... values) {
        for (char value : values) {
            if (value != symbol) {
                return false;
            }
        }
        return true;
    }

    /**
     * Цей метод isBoardFull перевіряє, чи дошка заповнена, тобто чи всі клітини (бокси) дошки мають значення
     * 'X' або 'O'. Якщо хоча б одна клітина не має значення 'X' або 'O', метод повертає false, що означає, що дошка
     * ще не заповнена повністю. Якщо всі клітини мають значення 'X' або 'O', метод повертає true, що вказує на те, що
     * дошка повністю заповнена.
     */
    private boolean isBoardFull() {
        for (char box : board) {
            if (box != 'X' && box != 'O') {
                return false;
            }
        }
        return true;
    }
}
