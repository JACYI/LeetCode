package others;

public class interview_17_19 {
    public int[] missingTwo(int[] nums) {
        int sum = 0;
        int squareSum = 0;
        for(int num:nums){
            sum += num;
            squareSum += (num * num);
        }
        int len = nums.length + 2;
        int sumSub = len * (len+1)/2 - sum;
        int squareSub = len * (len+1) * (2*len+1) / 6 - squareSum;
        int one = sumSub/2 + (int)Math.sqrt(squareSub/2 - sumSub*sumSub/4);
        return new int[]{one, sumSub - one};
    }

    public static void main(String[] args) {
        interview_17_19 interview = new interview_17_19();
        int[] res = interview.missingTwo(new int[]{1,3,4, 5, 6, 7, 8, 9});
    }
}
