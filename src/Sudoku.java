import java.util.*;

public class Sudoku {
    private String difficulty;
    private int[][] puzzle;

    public Sudoku(String difficulty) {
        this.difficulty = difficulty;
        puzzle = new int[9][9];
    }

    public void puzzleMaker() {
        if (fillGrid(0, 0) == true) {
            printPuzzle();
        }
    }


    public boolean fillGrid(int row, int col) {
        if (row == 9) {
            return true; // Grid is filled
        }

        if (col == 9) {
            return fillGrid(row + 1, 0); // Move to the next row
        }

        List<Integer> digits = generateRandomDigits();

        for (int digit : digits) {
            if (canPlaceDigit(row, col, digit) == true) {
                puzzle[row][col] = digit;
                if (fillGrid(row, col + 1) == true) {
                    return true;
                }
                puzzle[row][col] = 0; // Backtrack
            }
        }

        return false; // Trigger backtracking
    }

    public List<Integer> generateRandomDigits() {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.add(i);
        }
        Collections.shuffle(digits);
        return digits;
    }

    public boolean canPlaceDigit(int row, int col, int digit) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == digit) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (puzzle[i][col] == digit) {
                return false;
            }
        }

        // Check 3x3 grid
        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                if (puzzle[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public void printPuzzle() {
        for (int row = 0; row <= 8; row++) {
            if (row % 3 == 0) {
                System.out.println();
            }
            for (int col = 0; col <= 8; col++) {
                if (col % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(puzzle[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku("medium");
        sudoku.puzzleMaker();
    }
}



    