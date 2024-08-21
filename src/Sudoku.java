import java.util.*;

public class Sudoku {
    private String difficulty;
    private int[][] puzzle;

    public Sudoku(String difficulty) {
        this.difficulty = difficulty;
        puzzle = new int[9][9];
    }

    public void puzzleMaker(){
       numberFiller(1);
       numberFiller(2);
       numberFiller(3);
       //numberFiller(4);
       //numberFiller(5);
       //numberFiller(6);
       //numberFiller(7);
       //numberFiller(8);
       //numberFiller(9);
       printPuzzle();
    }

    public void numberFiller(int digit){
        // 1) in each grid, check rows for any openings, add to list if have them and row already doesn't have number
        // 2) randomly pick a row from the list
        // 3) when have row, check for potential columns, add those that have an opening and dont have number already
        // 4) randomly pick column from the list
        // 5) add digit to the spot
    

    }


    public List<Integer> rowUsed(int row){
        List<Integer> rowUsed = new ArrayList<>();
        
        for(int col = 0; col <= 8; col++){
            rowUsed.add(puzzle[row][col]);
        }

        return rowUsed;
    }


    public List<Integer> colUsed(int col){
        List<Integer> colUsed = new ArrayList<>();
        
        for(int row = 0; row <= 8; row++){
            colUsed.add(puzzle[row][col]);
        }

        return colUsed;
    }

    public List<Integer> possColumns(int row, int colLeft){
        List<Integer> clearCols = new ArrayList<>();

        for(int col = colLeft; col <= colLeft+2; col++){
            int digitAtSpot = puzzle[row][col];
            if(digitAtSpot == 0){
                clearCols.add(col);
            }
        }

        return clearCols;
    }


    public List<Integer> possRows(int rowTop, int colLeft){
        List<Integer> clearRows = new ArrayList<>();

        for(int row = rowTop; row <= rowTop+2; row++){
            for(int col = colLeft; col <= colLeft+2; col++){
                int digit = puzzle[row][col];
                if(digit == 0){
                    clearRows.add(row);
                    break;
                }
            }
        }

        return clearRows;
    }


    public void printPuzzle(){
        for(int row = 0; row <= 8; row++){
            if(row % 3 == 0){
                System.out.println();
            }
            for(int col = 0; col <= 8; col++){
                if(col % 3 == 0){
                    System.out.print(" ");
                }
                System.out.print(puzzle[row][col]);
            }
            System.out.println();
        }
    }

}


    