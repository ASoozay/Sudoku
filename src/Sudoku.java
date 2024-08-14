import java.util.*;

public class Sudoku {
    private String difficulty;
    private int[][] puzzle;

    public Sudoku(String difficulty) {
        this.difficulty = difficulty;
        puzzle = new int[9][9];
    }

    public void puzzleMaker(){
        List<Integer> numbersLeft = fullNumberList();
        List<Integer> numbersUsed = new ArrayList<>();

        for(int row = 0; row <= 8; row ++){
            
        }


    }



    public List<Integer> fullNumberList(){
        List<Integer> fullList = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            fullList.add(i);
        }
        return fullList;
    }


}



