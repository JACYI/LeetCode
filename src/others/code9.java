package others;

public class code9 {
    public static void main(String[] args){

    }
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int target = x;
        int y = 0;
        while(target != 0){
            y = y * 10 + target % 10;
            target /= 10;
        }
        return x == y;
    }
}
