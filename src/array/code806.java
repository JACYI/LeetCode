package array;

public class code806 {
    public static int[] numberOfLines(int[] widths, String s){
        int lines = 1;
        int lastWidth = 0;
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(widths[c-'a'] + lastWidth > 100) {
                lines++;
                lastWidth = 0;
            }
            lastWidth += widths[c - 'a'];
        }
        return new int[]{lines, lastWidth};
    }
    public static void main(String[] args){

    }
}
