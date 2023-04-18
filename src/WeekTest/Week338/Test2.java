package WeekTest.Week338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/26 12:03
 */
public class Test2 {
    List<Integer> primes;
    static final int MAX = 1000;
    private void setInit() {
        HashSet<Integer> primesSet = new HashSet<>();
        boolean[] notPrime = new boolean[MAX+1];

        for(int i=2; i<=MAX; i++) {
            if(notPrime[i])
                continue;
            primesSet.add(i);
            // 欧拉筛
            for(int j=2; j<MAX && j * i <= MAX; j++) {
                // 任意数的倍数不是 prime
                notPrime[j * i] = true;
            }
        }
        primes = new ArrayList<>(primesSet);
        primes.add(0);
        primes.sort(Integer::compareTo);
    }
    public boolean primeSubOperation(int[] nums) {
        setInit();
        int preNum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= preNum)
                return false;
            nums[i] -= binarySearch(nums[i] - preNum);
            preNum = nums[i];
        }
        return false;
    }
    // 小于target的最大prime
    private int binarySearch(int target) {
        int left = 0, right = primes.size() - 1;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(primes.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return primes.get(left);
    }


    public static void main(String[] args) {
//        Test2 t = new Test2();
//        t.primeSubOperation(new int[]{4,9,6,10});
    }
}
