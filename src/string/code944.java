package string;

public class code944 {
    public static int minDeletionSize(String[] strs) {
        int count = 0;
        for(int j=0; j<strs[0].length(); j++){
            char c = 'a';
            for(int i = 0; i<strs.length; i++){
                if(strs[i].charAt(j) - c < 0) {
                    count++;
                    break;
                }
                else
                    c = strs[i].charAt(j);
            }
        }
        return count;
    }
    public static void main(String[] args) {

    }
}
