package backtracking;

import java.util.Arrays;

public class NQueens {
    static int N = 6;

    private boolean isSafe(int[][] board, int x, int y) {
        //System.out.println("safe");
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;

        // check column
        for (int i = 0; i < N; i++) {
            if(board[i][y] == 1) {
                return false;
            }
        }

        // check left upper diagonal
        for (int i = x-1, j = y-1; i >= 0 && j >= 0;) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j--;
        }

        // check right upper diagonal
        for (int i = x-1, j = y+1; i >= 0 && j < N;) {
            if(board[i][j] == 1) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public boolean placeQueens(int[][] board) {
        placeQueensAlgo(board, 0, N);
        //System.out.print("ok");
            printBoard(board);
            return true;
    }

    private boolean placeQueensAlgo(int[][] board, int x, int n) {
        //System.out.println("n = " + n);
        if(n <= 0) {
            //printBoard(board);
            return true;
        } else {
            for (int j = 0; j < N; j++) {
                //System.out.println("h");
                if (isSafe(board, x, j)) {
                    board[x][j] = 1;
                    if(placeQueensAlgo(board, x+1, n-1)) {
                        return true;
                    } else {
                        board[x][j] = 0;
                    }
                } else {

                }
            }
        }
        return false;
    }

    private void printBoard(int[][] board) {
        for (int i= 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int[][] chessBoard = new int[N][N];
        Arrays.stream(chessBoard).forEach(a -> Arrays.fill(a, 0));

        NQueens nQueens = new NQueens();
        nQueens.placeQueens(chessBoard);
    }
}
