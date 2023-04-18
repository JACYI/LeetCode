package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class code187 {
    public Integer char2Int(Character c) {
        int res = 0;
        switch (c){
            case 'C':
                res = 1;
            case 'G':
                res = 2;
            case 'T':
                res = 3;
            default:
                res = 0;
        }
        return res;
    }
    public List<String> findRepeatedDnaSequences(String s) {
        int left = 0, right = 0;
        int windows = 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            windows += windows * 4 + char2Int(c);

            if(right - left == 10) {
                if(set.contains(windows))
                    res.add(s.substring(left, right));
                else
                    set.add(windows);


                c = s.charAt(left);
                left++;
                windows -= 36 * char2Int(c);

            }
        }
        return new ArrayList<>(res);
    }
}
