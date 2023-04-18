package array;

import java.util.HashMap;

public class code1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int e:target) {
            if(!map.containsKey(e))
                map.put(e, 1);
            else
                map.put(e, map.get(e)+1);
        }
        for(int e:arr){
            if(!map.containsKey(e) || map.get(e) == 0)
                return false;
            map.put(e, map.get(e)-1);
        }
        return true;
    }
}
