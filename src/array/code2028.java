package array;

public class code2028 {
    public static int[] missingRolls(int[] rolls, int mean, int n){
        int sum = 0;
        for(int roll:rolls)
            sum+=roll;
        int res = mean * (rolls.length + n) - sum;
        if(res > 6*n || res < n) return new int[0];
        int[] result = new int[n];
        int avg = res/n;
        int remainder = res%n;
        for(int i = 0;i<n;i++){
            if(remainder != 0)
                result[i] = avg + 1;
            else {
                result[i] = avg;
                remainder--;
            }
        }
        return result;
    }
    public static void main(String[] args){

    }
}
