package daytest;

public class day907 {
    public static void main(String[] args){

    }
    public static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int vote = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] == 'L') vote++;
            else if(chars[i] == 'R') vote--;

            if(vote == 0) res++;
        }
        return res;
    }
}
