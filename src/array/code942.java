package array;

public class code942 {
    public static int[] diStringMatch(String s) {
        int left=0, right=s.length();
        int[] res = new int[s.length()];
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(chars[i] == 'I')
                res[i] = left++;
            else if(chars[i] == 'D')
                res[i] = right--;
        }
        res[-1] = left;
        return res;
    }
    public static void main(String[] args) {

    }
}
