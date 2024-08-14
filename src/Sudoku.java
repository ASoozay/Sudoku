import java.util.*;

public class Sudoku {
    private String difficulty;
    private int[][] puzzle;

    public Sudoku(String difficulty) {
        this.difficulty = difficulty;
        puzzle = new int[9][9];
    }

    public void puzzleMaker(){
        
        System.out.println("Making Puzzle");
        for(int row = 0; row <= 6; row += 3){
            for(int col = 0; col <= 6; col+= 3){
                gridMaker(row, col);
            }
        }
        System.out.println("Done!");
        printPuzzle();
    }

    public static int digitPlacer(Random rand, List<Integer> rowUsed, List<Integer> colUsed, List<Integer> gridNumberUsed){
        int digit = rand.nextInt(9)+1;
        while(rowUsed.contains(digit) || colUsed.contains(digit) || gridNumberUsed.contains(digit)){
            digit = rand.nextInt(9)+1;
        }

        rowUsed.add(digit);
        gridNumberUsed.add(digit);

        return digit;
    }

    public void gridMaker(int row1,  int col1){
        List<Integer> gridUsed = new ArrayList<>();
        List<Integer> rowUsed = new ArrayList<>();
        List<Integer> colUsed = new ArrayList<>();
        Random rand = new Random();

        for(int row = row1; row <= row1+2; row++){
            rowFinder(row, rowUsed);
            for(int col = col1; col <= col1+2; col++){
                colFinder(col, colUsed);
                int digit = digitPlacer(rand, rowUsed, colUsed, gridUsed);
                System.out.println(digit);
                puzzle[row][col] = digit;
            }
        }
    }

    public List<Integer> fullNumberList(){
        List<Integer> fullList = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            fullList.add(i);
        }
        return fullList;
    }

    public void rowFinder(int row, List<Integer> rowUsed){
        for(int col = 0; col <= 8; col++){
            int number = puzzle[row][col];
            rowUsed.add(number);
        }

    }


    public void colFinder(int col, List<Integer> colUsed){
        for(int row = 0; row <= 8; row ++){
            int number = puzzle[row][col];
            colUsed.add(number);
        }
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
                int digit = puzzle[row][col];
                System.out.print(digit);
            }
            System.out.println();
        }
    }
}



