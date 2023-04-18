package string;

import java.util.HashMap;

public class code691 {
    // 躺平
    public static int minStickers(String[] stickers, String target) {
        HashMap<Character, Integer> statistics = new HashMap<>();
        char[] chars = target.toCharArray();
        for(char c:chars){
            if(statistics.containsKey(c))
                statistics.put(c, statistics.get(c) + 1);
            else
                statistics.put(c, 1);
        }

        return -1;
    }
    public static void main(String[] args) {

    }
}
