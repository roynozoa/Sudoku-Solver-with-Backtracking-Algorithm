/*
    Java sudoku solver with backtracking algorithm
    by : Muhammad Adisatriyo Pratama

*/

package com.sudokusolver;

public class Main {

    public static void main(String[] args) {

        int[][] boardOne = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };

        // Create a new sudoku object with 9x9 matrices
        Sudoku sudoku = new Sudoku(boardOne);

        System.out.println("=====JAVA SUDOKU SOLVER WITH BACKTRACKING ALGORITHM=====");
        System.out.println("Unsolved Sudoku : ");
        sudoku.display();

        if (sudoku.solve()) {
            System.out.println("Sudoku solved with backtracking algorihm");
            System.out.println("Result : ");
            sudoku.display();
        } else {
            System.out.println("Sudoku Unsolved");
        }
    }
}
