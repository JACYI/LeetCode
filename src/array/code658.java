package array;

import java.util.ArrayList;
import java.util.List;

public class code658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(x<=arr[0]){
            for(int i=0; i<k; i++)
                res.add(arr[i]);
        }
        else if(x >= arr[arr.length-1]){
            for(int i=arr.length-k; i<arr.length; i++)
                res.add(arr[i]);
        }
        else {

            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == x) {
                    left = mid;
                    right = mid;
                } else if (arr[mid] < x)
                    left = mid + 1;
                else
                    right = mid;
            }
            // 找到目标x位置或者大于x的最小数的位置
            // left闭区间，right开区间
            if (Math.abs(arr[left - 1] - x) < Math.abs(arr[right] - x))
                left--;
            else
                right++;

            while (k > 1) {
                if (0 == left)
                    ++right;
                else if (right == arr.length)
                    --left;
                else if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right] - x))
                    --left;
                else if (Math.abs(arr[left - 1] - x) > Math.abs(arr[right] - x))
                    ++right;
                k--;
            }
            for (int i = left; i < right; i++)
                res.add(arr[i]);
        }
        return res;
    }
}
