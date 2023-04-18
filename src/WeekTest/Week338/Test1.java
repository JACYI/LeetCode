package WeekTest.Week338;

/**
 * @Author yiyonghao
 * @Date 2023/3/26 12:00
 */
public class Test1 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int res = 0;
        while(k > 0) {
            while(k > 0 && numOnes > 0) {
                res += 1;
                numOnes--;
                k--;
            }
            while(k > 0 && numZeros > 0) {
                numZeros--;
                k--;
            }
            while(k > 0 && numNegOnes > 0) {
                numNegOnes--;
                res -= 1;
                k--;
            }
        }
        return res;
    }
}
