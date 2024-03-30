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
        if(board[row][col] == ' ')
            return true;
        else
            return false;
    }

    // Make a move
    public void swichplayer() {
        //board[row][col] = currentPlayer;
        // Switch player
        if (currentPlayer == 'X') {
            currentPlayer = 'O'; // If current player is 'X', switch to 'O'
        } else {
            currentPlayer = 'X'; // If current player is 'O', switch to 'X'
        }
    }

    // Check for a win
    public boolean checkWin() {
        // rows, columns
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

    public void gamePlay(){
        while(isBoardFull() != true || checkWin() != true){
            System.out.println("Player " + currentPlayer + "'s turn.");
            System.out.print("Enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (isValidMove(row,col)) {
                board[row][col] = currentPlayer;
                if (checkWin()) {
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }
                else if (isBoardFull()) {
                    System.out.println("It's a draw!");
                    break;
                }
                else {
                    swichplayer();
                }

            }else{
                System.out.println("Invalid move. Try again.");
            }

            System.out.println("Current board:");
            printBoard();
        }
    }

}
