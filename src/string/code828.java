package string;

import java.util.HashMap;

public class code828 {
    public int uniqueLetterString(String s) {
        HashMap<String, Integer> map = new HashMap<>();

        int res = 0;
        for(int i=1; i<s.length(); i++){
            for(int j=i; j>0; j--){
                String subs = s.substring(j, i);
                if(!map.containsKey(subs)){
                    map.put(subs, 1);
                    res += 1;
                }
                else{
                    map.put(subs, map.get(subs)+1);
                    res -= 1;
                }
            }
        }
        return res;
    }
}
