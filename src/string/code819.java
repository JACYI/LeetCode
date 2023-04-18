package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class code819 {
    public static String mostCommonWord (String paragraph, String[] banned) {
        int max = 0;
        String res = "";
        HashSet<Character> marks = new HashSet<>(Arrays.asList('!', '?', '\'', ',', ';', '.'));
        HashSet<String> bans = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> results = new HashMap<>();
        String[] strings = paragraph.split(" ");
        for(String string:strings) {
            string = string.toLowerCase();
            if(marks.contains(string.charAt(string.length()-1)))
                string = string.substring(0, string.length()-1);
            if(!bans.contains(string)){
                int curTimes = results.containsKey(string)?results.get(string)+1:1;
                if(curTimes > max){
                    res = string;
                    max = curTimes;
                }
                results.put(string, curTimes);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "AB v21, yes me.";
        String[] strings = s.split(" ");
        for(String s1:strings) {
            System.out.println(s1);
        }
    }
}
