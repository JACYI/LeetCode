package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yiyonghao
 * @Date 2023/3/3 20:42
 */
public class Code49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs) {
            int[] temp = new int[26];
            for(char c : str.toCharArray()){
                temp[c - 'a'] += 1;
            }
            StringBuilder s = new StringBuilder();
            for(int i=0; i<26; i++){
                if(temp[i] != 0)
                    s.append('a' + i).append(temp[i]);
            }
            if(!map.containsKey(s.toString())) {
                List<String> newList = new ArrayList<>();
                res.add(newList);
                map.put(s.toString(), newList);
            }
            map.get(s.toString()).add(str);
        }
        return res;
    }
}
