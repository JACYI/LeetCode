package interview;


import java.util.Random;

class Solution {
    int[] preSum;

    Random random;
    public Solution(double[] w) throws Exception {
        if(w.length < 1)
            throw new Exception("数组过小");
        int adNumbers = w.length;
        int[] weights = new int[adNumbers];
        for(int i = 0; i<adNumbers; i++)
            weights[i] = (int) (w[i] * 100000);


        random = new Random();
        int n = w.length;

        preSum = new int[n + 1];
        preSum[0] = 0;
        // 构造概率前缀和数组
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + weights[i - 1];
        }
        System.out.println(preSum[n]);
        if(preSum[n] != 100000)
            throw new Exception("概率数组值和不为1");
    }
    // 返回不等概率选择的广告下标 0~n-1
    public int pickIndex() {
        int n = preSum.length;


        int target = random.nextInt(preSum[n - 1]) + 1;

        return left_bound(preSum, target) - 1;
    }

    // 搜索左侧边界的二分搜索
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

}

public class LuKe {

    private static final int TIMES = 10000;
    public static void main(String[] args) {
        double[] inputs = new double[]{0.1, 0.8, 0.1};
        int[] results = new int[inputs.length];
        try {
            // 对该对象数组创建解决方案, 初始化
            Solution solution = new Solution(inputs);

            int index = 0;
            while(index < TIMES) {
                // 每次生成广告可调用生成不等概率值的广告索引

                int chose = solution.pickIndex();
                if (chose == -1)
                    throw new Exception("数组错误");
//                System.out.println("选择第"+chose+"广告");

                // 记录
                results[chose]++;
                index++;
            }

            // 输出概率
            for(int i=1; i<=results.length; i++)
                System.out.println("第" + i +"条广告输出概率是" + (double)results[i-1] / TIMES);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
