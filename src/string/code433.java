package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class code433 {
    static HashSet<String> set;
    static String des;
    static HashSet<Integer> wrong;
    static int res;
    public static void rec(StringBuffer cur, int count){
        if(cur.toString().equals(des))
            res = Math.min(res, count);
        for(int idx:wrong){
            char temp = cur.charAt(idx);
            cur.setCharAt(idx, des.charAt(idx));
            if(set.contains(cur.toString())){
                wrong.remove(idx);
                rec(cur, count+1);
                wrong.add(idx);
            }
            cur.setCharAt(idx, temp);
        }
    }

    public static int minMutation(String start, String end, String[] bank) {
        set = new HashSet<>(Arrays.asList(bank));
        des = end;
        wrong = new HashSet<>();
        res = Integer.MAX_VALUE;
        for(int i=0; i<start.length(); i++) {
            if (start.charAt(i) != end.charAt(i))
                wrong.add(i);
        }
        StringBuffer cur = new StringBuffer(start);
        rec(cur, 0);
        return res;
    }
    public static void main(String[] args) {
        System.out.println(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }
}
