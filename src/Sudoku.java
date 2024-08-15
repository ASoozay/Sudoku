import java.util.*;

public class Sudoku {
    private String difficulty;
    private int[][] puzzle;

    public Sudoku(String difficulty) {
        this.difficulty = difficulty;
        puzzle = new int[9][9];
    }

    public void puzzleMaker(){
        topRightGrid();
        printGrid();
       
    }


    // method: topRightGrid();
    // purpose: creates the top-right grid for puzzle reference
    // parameters: none
    public void topRightGrid(){
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


       