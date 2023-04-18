package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class code854 {
    int ans;
    public String swap(String s, int i, int j){
        char[] news = s.toCharArray();
        char temp = news[i];
        news[i] = news[j];
        news[j] = temp;
        return new String(news);
    }
    public int minSwap(String s1, String s2, int pos) {
        int tot = 0;
        for (int i = pos; i < s1.length(); i++) {
            tot += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
        }
        return (tot + 1) / 2;
    }
    public void dfs(String string1, String string2, int times, int pos) {
        // pos 表示pos之前的字母都是相等的
        if(times > ans) return;
        while(pos < string1.length() && string1.charAt(pos) == string2.charAt(pos))
            pos++;

        if(pos == string1.length()){
            ans = Math.min(ans, times);
        }
        // 剪枝
        if(times + minSwap(string1, string2, pos) > times)
            return;

        for(int j=pos+1; j<string1.length(); j++){
            if(string1.charAt(j) == string2.charAt(pos)){
                String newString = swap(string1, pos, j);
                dfs(newString, string2, times+1, pos+1);
            }
        }

    }
    public int kSimilarity(String s1, String s2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) {
                string1.append(s1.charAt(i));
                string2.append(s2.charAt(i));
            }
        }
        ans = s1.length() - 1;
        dfs(string1.toString(), string2.toString(), 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "aabccb";
        String s2 = "bbcaca";
        code854 c = new code854();
//        String a = "fignga";
//        String b = c.swap(a, 0,1);
//        System.out.println(a);
//        System.out.println(b);
        System.out.println(c.kSimilarity(s1, s2));
    }
}
