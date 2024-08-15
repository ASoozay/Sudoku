import java.util.*;

public class Sudoku {
    private String difficulty;
    private int[][] puzzle;

    public Sudoku(String difficulty) {
        this.difficulty = difficulty;
        puzzle = new int[9][9];
    }

    public void puzzleMaker(){
        topLeftGrid();
        printGrid();
        gridMaker(0,3);
       
    }


    // method: topLeftGrid();
    // purpose: creates the top-left grid for puzzle reference
    // parameters: none
    public void topLeftGrid(){
        List<Integer> gridLeft = fullList();
        Random rand = new Random();

        for(int row = 0; row <= 2; row++){
            for(int col = 0; col <= 2; col++){
                int length = gridLeft.size();
                int index = rand.nextInt(length);
                int digit = gridLeft.get(index);
                puzzle[row][col] = digit;
                removeDigit(gridLeft, digit);
                
            }
        }
    }


    public void gridMaker(int rowS, int colS){
        Random rand = new Random();
        List<Integer> rowTopPoss = possNum(rowS);
        List<Integer> rowMiddlePoss = possNum(rowS+1);
        List<Integer> rowBottomPoss = possNum(rowS+2);

        // use possNum for possible rows, randomly pick a #, check if column has that digit, if not add it and remove possible number from other rows

    }


    public static void printPoss(List<Integer> list){
        System.out.println();
        System.out.print("Poss. Nums for Row: ");
        for(int digit : list){
            System.out.print(digit + " ");
        }
        System.out.println();
    }

    // method: fullList (List<Integer>)
    // purpose: creates a list of numbers 1-9, used for grids
    // parameters: none
    public List<Integer> fullList(){
        List<Integer> fullList = new ArrayList<>();
        for(int i = 1; i <= 9; i++){
            fullList.add(i);
        }
        return fullList;
    }


    // method: possNum (List<Integer>)
    // purpose: finds the possible numbers for a row in a grid
    // parameters:  (1) row (int): row to find
    public List<Integer> possNum(int row){
        List<Integer> rowUsed = rowUsed(row);
        List<Integer> fullList = fullList();
        List<Integer> possNums = new ArrayList<>();

        for(int digit : fullList){
            if(!rowUsed.contains(digit)){
                possNums.add(digit);
            }
        }

        return possNums;
    }


    // method: rowUsed (List<Integer>)
    // purpose: finds the digits already used in the row
    // parameters:  (1) row (int) row to check
    public List<Integer> rowUsed(int row){
        List<Integer> rowUsed = new ArrayList<>();
        for(int col = 0; col <= 8; col++){
            int digit = puzzle[row][col];
            rowUsed.add(digit);
        }
        return rowUsed;
    }


    // method: removeDigit (void)
    // purpose: removes a specified digit from the list
    // parameters:  (1) list (List<Integer>): list to remove from
    //              (2) digit (int): digit to be removed
    public static void removeDigit(List<Integer> list, int digit){
        for(int index = 0; index <= list.size(); index++){
            int number = list.get(index);
            if(number == digit){
                list.remove(index);
                return;
            }
        }
    }

    public void printGrid(){
        for(int row = 0; row <= 2; row++){
            for(int col = 0; col <= 2; col++){
                System.out.print(puzzle[row][col] + " ");
            }
            System.out.println();
        }
    }

}


       