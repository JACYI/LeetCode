package array;

import java.util.Arrays;

public class code1728 {
    public static void arrive(int[] start, int[] end, char[][] grid){

    }
    public static boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int step = 0;
        char[][] array= (char[][]) Arrays.stream(grid).toArray();
        int rows = array.length;
        int cols = array[0].length;
        int[] food, mouse, cat;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++) {
                if(array[i][j] == 'F')
                    food = new int[]{i, j};
                if(array[i][j] == 'C')
                    cat = new int[]{i, j};
                if(array[i][j] == 'M')
                    mouse = new int[]{i, j};
            }
        }
        while(step < 1000){
            // mouse move


            // update grid
            // cat move
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
