import java.util.Scanner;

public class layout {
    private char[][] board = new char[3][3];
    Scanner sc = new Scanner(System.in);
    char currentPlayer;

    public layout() {
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        if (board[row][col] == ' ')
            return true;
        else
            return false;
    }

    // Make a move
    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    // Check for a win
    public boolean checkWin() {
        // Rows, columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true; // Row win
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true; // Column win
            }
        }
        // Diagonal win
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true;
        }
        return false;
    }

    // Check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Minimax algorithm
    private int minimax(char player) {
        if (checkWin()) {
            if (player == 'O')
                return 1;
            else
                return -1;
        } else if (isBoardFull()) {
            return 0;
        }

        if (player == 'O') {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = player;
                        bestScore = Math.max(bestScore, minimax('X'));
                        board[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = player;
                        bestScore = Math.min(bestScore, minimax('O'));
                        board[i][j] = ' ';
                    }
                }
            }
            return bestScore;
        }
    }

    // Find the best move for the computer
    private int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] move = new int[2];
        move[0] = -1;
        move[1] = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    int score = minimax('X');
                    board[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        move[0] = i;
                        move[1] = j;
                    }
                }
            }
        }
        return move;
    }

    // Computer makes a move
    public void computerMove() {
        int[] move = findBestMove();
        board[move[0]][move[1]] = 'O';
    }

    // Game play
    public void gamePlay() {
        while (isBoardFull() != true || checkWin() != true) {
            System.out.println("Player " + currentPlayer + "'s turn.");

            if (currentPlayer == 'X') {
                System.out.print("Enter row and column (0-2): ");
                int row = sc.nextInt();
                int col = sc.nextInt();
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;
                } else {
                    System.out.println("Invalid move. Try again.");
                    continue;
                }
            } else {
                computerMove();
            }

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            } else {
                switchPlayer();
            }

            System.out.println("Current board:");
            printBoard();
        }
    }

    public static void main(String[] args) {
        layout game = new layout();
        System.out.println("Welcome to Tic Tac Toe!");
        game.gamePlay();
    }
}
