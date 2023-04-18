package string;

public class code796 {
    public static boolean rotateString(String s, String goal){
        if(s.length() != goal.length()) return false;
        char[] c1 = s.toCharArray();
        char[] c2 = s.toCharArray();
        for(int i=0;i<c1.length;i++){
            if(isRotateString(i, c1, c2)) return true;
        }
        return false;
    }
    public static boolean isRotateString(int k, char[] c1, char[] c2){
        for(int i = 0; i<c2.length; i++){
            if(c1[i] != c2[(i+k)%c1.length]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("abc".substring(1) + "abc".charAt(0));
    }
}
