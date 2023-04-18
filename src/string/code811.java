package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s:cpdomains){
            String[] data = s.split(" ");
            int times = Integer.parseInt(data[0]);
            int index = 0;
            map.put(data[1], times + map.getOrDefault(data[1], 0));
            while(index < data[1].length()){
                if(data[1].charAt(index) == '.') {
                    String temp = data[1].substring(index+1);
                    map.put(temp, map.getOrDefault(temp, 0) + times);
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry:map.entrySet()){
            res.add(new String(entry.getValue() + " " + entry.getKey()));
        }
        return res;
    }
}
