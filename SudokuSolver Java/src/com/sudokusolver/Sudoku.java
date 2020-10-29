package com.sudokusolver;

// sudoku class
public class Sudoku {

    // Size of a sudoku is 9x9 matrix
    final public static int SIZE = 9;
    final public static int EMPTY = 0;
    private int[][] board;

    // Class constructor
    public Sudoku(int[][] board) {

        this.board = new int[SIZE][SIZE];

        // for loop put each value into board
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.board[i][j] = board[i][j];
            }
        }
    }

    // display sudoku method
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("[" + board[i][j] + "]");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // check if safe to put number in row (number 'x' already in a row)
    private boolean isSafeRow(int rowNumber, int x) {

        // for loop to cheack each row
        for (int i = 0; i < SIZE; i++) {
            if (board[rowNumber][i] == x) {
                return false;
            }
        }
        return true;
    }

    // check if safe to put number in column (number 'x' already in a column)
    private boolean isSafeColumn(int colNumber, int x) {

        // for loop to check each column
        for (int i = 0; i < SIZE; i++) {
            if (board[i][colNumber] == x) {
                return false;
            }
        }
        return true;
    }

    // check if safe to put number in each 3x3 box (number 'x' already in a 3x3 box)
    private boolean isSafeBox(int rowNumber, int colNumber, int x) {

        // 3x3 matrix each start at index 0, 3, or 6
        int row = rowNumber - rowNumber % 3;
        int col = colNumber - colNumber % 3;

        // for loop to each 3x3 matrix
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] == x) {
                    return false;
                }
            }
        }
        return true;
    }

    // check if number legal to put number 'x' in all empty cell inside board
    private boolean isSafe(int rowNumber, int colNumber, int x) {
        return isSafeRow(rowNumber, x) && isSafeColumn(colNumber, x) && isSafeBox(rowNumber, colNumber, x);
    }

    // begin solving sudoku using BackTracking algorithm
    public boolean solve() {

        for (int rowNumber = 0; rowNumber < SIZE; rowNumber++) {
            for (int colNumber = 0; colNumber < SIZE; colNumber++) {
                // search empty cell inside board
                if (board[rowNumber][colNumber] == EMPTY) {
                    // try every possible numbers (1 - 9)
                    for (int x = 1; x <= SIZE; x++) {
                        if (isSafe(rowNumber, colNumber, x)) {
                            board[rowNumber][colNumber] = x;

                            if (solve()) {
                                return true;
                            } else {
                                board[rowNumber][colNumber] = EMPTY; // if number cannot be placed, the representative
                                                                     // cell will leave empty
                            }
                        }
                    }

                    return false;
                }
            }
        }
        // sudoku solved
        return true;
    }
}
