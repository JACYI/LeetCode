package string;

import java.util.*;

public class code692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word:words){
            if(map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() > o2.getValue())
                    return 1;
                else if(o1.getValue() < o2.getValue())
                    return -1;
                else
                    return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Map.Entry<String, Integer> a:map.entrySet()){
            queue.offer(a);
            if(queue.size() > k)
                queue.poll();
        }
        List<String> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll().getKey());
        }
//        Collections.reverse(res);
        return res;
    }
}
