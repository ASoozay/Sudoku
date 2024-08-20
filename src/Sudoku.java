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
        printTLGrid();
        gridMaker(0,3);
        //gridMaker(0,6);
        //gridMaker(3,0);
        //gridMaker(3,3);
        //gridMaker(3,6);
        //gridMaker(6,0);
        //gridMaker(6,3);
        //gridMaker(6,6);
        //printGrid();
       
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
                removeDigit(digit, gridLeft);
                
            }
        }
    }


    public void gridMaker(int rowS, int colS){
        Random rand = new Random();
        List<Integer> rowTopPoss = possNum(rowS);
        List<Integer> rowMiddlePoss = possNum(rowS+1);
        List<Integer> rowBottomPoss = possNum(rowS+2);

        System.out.println();
        printPossRow(rowTopPoss);
        printPossRow(rowMiddlePoss);
        printPossRow(rowBottomPoss);

        // use possNum for possible rows, randomly pick a #, check if column has that digit, if not add it and remove possible number from other rows

        // fill top row
        rowFiller(rowS, colS, rowTopPoss, rowMiddlePoss, rowBottomPoss);
        System.out.println("Top Row Done");

        printPossRow(rowMiddlePoss);
        // fill middle and bottom rows
        if(rowMiddlePoss.size() == rowBottomPoss.size()){
            rowFiller(rowS+1, colS, rowMiddlePoss, rowTopPoss, rowBottomPoss);
            rowFiller(rowS+2, colS, rowBottomPoss, rowTopPoss, rowMiddlePoss);
        } 

        System.out.println();
        printRow(rowS, colS, "Top");
        printRow(rowS+1, colS, "Middle");
        printRow(rowS+2, colS, "Bottom");

    }


    public List<Integer> uniqueDigits(List<Integer> list1, List<Integer> list2){
        List<Integer> unique = new ArrayList<>();
        for(int digit : list1){
            if(!list2.contains(digit)){
                unique.add(digit);
                removeDigit(digit, list1);
            }
        }

        return unique;
    }


    public void printPossRow(List<Integer> list){
        System.out.print("Poosible Numbers for Row: ");
        for(int digit : list){
            System.out.print(digit + " ");
        }
        System.out.println();
    }

    public void printRow(int row, int colS, String place){
        System.out.print(place + " Row:");
        for(int col = colS; col <= colS+2; col++){
            System.out.print(puzzle[row][col] + " ");
        }
        System.out.println();
    }

    public void rowFiller(int row, int colS, List<Integer> rowFill, List<Integer> altRow1, List<Integer> altRow2){
        for(int col = colS; col <= colS+2; col++){
            List<Integer> colUsed = colUsed(col);
            int digit = randomNumber(rowFill);
            while(colUsed.contains(digit)){
                digit = randomNumber(rowFill);
            }
            puzzle[row][col] = digit;
            System.out.println("Digit Chosen: " + digit);
            removeDigit(digit, rowFill);
            removeDigit(digit, altRow1);
            removeDigit(digit, altRow2);

            System.out.println();
        }
        
    }


    // method: removeDigit (void)
    // purpose: removes a digit from a list, if it contains it
    // parameters:  (1) digit (int): digit to be removed
    //              (2) list (List<Integer>): list to remove the digit from
    public void removeDigit(int digit, List<Integer> list){
        if(list.contains(digit)){
            int index = list.indexOf(digit);
            list.remove(index);
        }
    }


    // method: randomNumber (int)
    // purpose: selects a random number in a list
    // parameters:  (1) possNum (List<Integer>): list of numbers
    public int randomNumber(List<Integer> possNum){
        Random rand = new Random();
        int size = possNum.size();
        int index = rand.nextInt(size);
        int number = possNum.get(index);

        return number;
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

    // method: colUsed (List<Integer>)
    // purpose: finds and returns the digits already used in a column
    // parameters:  (1) col (int): column to check;
    public List<Integer> colUsed(int col){
        List<Integer> colUsed = new ArrayList<>();
        
        for(int row = 0; row <= 8; row++){
            int digit = puzzle[row][col];
            colUsed.add(digit);
        }

        return colUsed;
    }


    public void printGrid(){
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

    public void printTLGrid(){
        for(int row = 0; row <= 2; row++){
            for(int col = 0; col <= 2; col++){
                System.out.print(puzzle[row][col] + " ");
            }
            System.out.println();
        }
    }

}


       