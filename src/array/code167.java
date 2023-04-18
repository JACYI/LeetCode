package array;

public class code167 {
    public int[] twoSum(int[] numbers, int target) {
        int pre = 0, fnt = numbers.length-1;
        while(pre < fnt) {
            if (target < numbers[pre] + numbers[fnt])
                fnt--;
            else if (target > numbers[pre] + numbers[fnt])
                pre++;
            else
                return new int[]{pre + 1, fnt + 1};
        }
        return new int[]{pre, fnt};
    }
}
