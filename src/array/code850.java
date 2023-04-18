package array;

import java.util.*;

public class code850 {
    public int rectangleArea(int[][] rectangles) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<rectangles.length; i++){
            set.add(rectangles[i][0]);
            set.add(rectangles[i][1]);
        }
        List<Integer> coloums = new ArrayList<Integer>(set);
        Collections.sort(coloums);


        return 0;
    }
}
