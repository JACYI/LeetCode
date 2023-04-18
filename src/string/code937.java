package string;

import java.util.Arrays;

public class code937 {
    public static String[] recorderLogFiles(String[] logs) {
        Arrays.sort(logs, ((o1, o2) -> compare(o1, o2)));
        return logs;
    }
    public static int stringCompare(String s1, String s2){
        if(s1.equals(s2)) return 0;
        for(int i=0; i<s1.length(); i++){
            if(i >= s2.length())
                return 1;
            if(s1.charAt(i) - s2.charAt(i) != 0)
                return s1.charAt(i)-s2.charAt(i)>0 ? 1:-1;
        }
        return -1;
    }
    public static int compare(String o1, String o2){
        int first1 = o1.indexOf(' ') + 1;
        int first2 = o2.indexOf(' ') + 1;
        if(Character.isDigit(o1.charAt(first1)) && Character.isDigit(o2.charAt(first2)))
            return 0;
        if(Character.isDigit(o2.charAt(first2)))
            return -1;
        else if(Character.isDigit(o1.charAt(first1)))
            return 1;
        else{
            int res = stringCompare(o1.substring(first1), o2.substring(first2));
            if(res == 0)
                res = stringCompare(o1.substring(0, first1), o2.substring(0, first2));
            return res;
        }

    }
    public static void main(String[] args) {

    }
}
