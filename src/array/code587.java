package array;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class code587 {
    public static double distance(int[] point1, int[] point2) {
        return Math.sqrt((point1[0]-point2[0])*(point1[0]-point2[0]) + (point1[1]-point2[1])*(point1[1]-point2[1]));
    }
    public static int[][] outerTrees(int[][] trees) {
        HashSet<int[]> res = new HashSet<>();
        int[] head = trees[0];
        HashSet<int[]> set = new HashSet<>();
        for(int[] tree:trees) {
            if (tree[0] < head[0])
                head = tree;
            set.add(tree);
        }
        int[] cur = head;
        res.add(head);
        int[] pre = new int[]{cur[0], 0};
        do{
            double a = distance(cur, pre);
            double cos = 0.;
            ArrayList<int[]> temp = new ArrayList<>();
            int[] next = new int[2];
            for(int[] tree:set){
                double b = distance(cur, tree);
                double c = distance(pre, tree);
                double curCos = (a*a + b*b - c*c)/(2*a*b);
                if(temp.isEmpty()){
                    next = tree;
                    cos = curCos;
                    temp.add(tree);
                    continue;
                }
                if((curCos-cos < 0.0001 && curCos-cos > -0.0001) || curCos==-cos){
                    temp.add(tree);
                    if(distance(next, cur) < b)
                        next = tree;
                }
                else if(curCos < cos) {
                    temp = new ArrayList<>(Arrays.asList(tree));
                    next = tree;
                    cos = curCos;
                }
            }
            set.removeAll(temp);
            res.addAll(temp);
            pre = cur;
            cur = next;
        }while(cur != head);
        return res.toArray(new int[][]{});
    }
    public static void main(String[] args) {
        int[][] a= new int[][]{{1,2},{2,2},{4,2}};
        int[][] res = outerTrees(a);
        for(int i=0; i<res.length; i++){
                System.out.println(String.valueOf(res[i][0]) + '\t' + String.valueOf(res[i][1]));
        }
    }
}
