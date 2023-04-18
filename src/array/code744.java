package array;

public class code744 {
    public static char nextGreatestLetter(char[] letters, char target){
//        target = (char)(target + 1);
        if(letters[letters.length-1] < target) return letters[0];
        int left=0, right=letters.length-1;
        while(left+1<right) {
            int mid = (left + right) / 2;
            if(letters[mid] >= target){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        System.out.println("left:" + letters[left] + '\t' + "right:" + letters[right]);
        return letters[right];
    }

    public static void main(String[] args){
//        System.out.println((char)('a'+1));
        System.out.println(nextGreatestLetter(new char[]{'c', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'g', 'h'}, 'c'));
    }
}
