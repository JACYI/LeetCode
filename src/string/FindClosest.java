package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindClosest {
    // 优化时间复杂度
    public int findClosest(String[] words, String word1, String word2){
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<words.length; i++){
            if(map.containsKey(words[i])) {
                ArrayList<Integer> idxs = new ArrayList<>(Arrays.asList(i));
                map.put(words[i], idxs);
            }
            map.get(words[i]).add(i);
        }
        ArrayList<Integer> list1 = map.get(word1);
        ArrayList<Integer> list2 = map.get(word2);
        int index1=0, index2=0;
        int distance = words.length;
        while(index1<list1.size() && index2<list2.size()){
            int dis = list1.get(index1) - list2.get(index2);
            distance = Math.min(Math.abs(dis), distance);
            if(dis>0)
                index2++;
            else
                index1++;
        }
        return 0;
    }
//    public int findClosest(String[] words, String word1, String word2){
//        int index1=-1, index2=-1;
//        int distance=words.length;
//        for(int i=0; i<words.length; i++){
//            if(words[i].equals(word1))
//                index1 = i;
//            if(words[i].equals(word2))
//                index2 = i;
//            if(index1 >=0 && index2 >=0)
//                distance = Math.min(Math.abs(index1-index2), distance);
//        }
//        return distance;
//    }
    public static void main(String[] args){
        FindClosest findClosest = new FindClosest();
        findClosest.findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"}, "a", "student");
    }
}
