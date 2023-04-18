package string;

import java.util.ArrayList;
import java.util.HashSet;

public class code821 {
    public static int[] shotestToChar(String s, char c) {
        int len = s.length();
        int[] res1 = new int[len];
        int pivot = (int)-1e5;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == c)
                pivot = i;
            res1[i] = i - pivot;
        }
        pivot = (int)1e5;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == c)
                pivot = i;
            res1[i] = Math.min(pivot - i, res1[i]);
        }
        return res1;
    }
    public static void main(String[] args){
        int[] a = shotestToChar("dhbaynqokn",'h');
        System.out.println(1e5);
    }
}
