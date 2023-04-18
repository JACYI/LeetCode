package array;

import java.util.HashSet;

public class code4 {
    public static void main(String[] args){
        System.out.println(findMedianSortedArrays3(new int[]{1,2}, new int[]{3}));
    }
    // 时间复杂度为O(logn)的二分查找法
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2){
        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1)/2;      // m + n 是偶数时，+1没有影像，m + n 是奇数时，l位置位于合并数组的中间偏右，即中位数在l左边
        /*
        nums1: 1, 2, 3, 4,| 5
                  --------
        nums2: 3,| 4, 5, 6, 7, 8
         */
        // 关键在于找到两个数组的分割线，分割线左右两个数组元素和相等或者左边多一个，且左边最大数小于右边最小
        int left = 0, right = nums1.length-1;
        while(left<right){
            int mid1 = left + (right - left + 1)/2;
            int mid2 = l - mid1;
            if(nums1[mid1-1] > nums2[mid2])
                right = mid1-1;
            else
                left = mid1;
        }
        int i = left, j = l - left;
        int nums1Left = i==0 ? Integer.MIN_VALUE:nums1[i-1];
        int nums1Right = i==m ? Integer.MAX_VALUE:nums1[i];
        int nums2Left = j==0 ? Integer.MIN_VALUE:nums2[j-1];
        int nums2Right = j==n ? Integer.MAX_VALUE:nums2[j];
        if((m+n)%2 != 0)
            return Math.max(nums1Left, nums2Left);
        else{
            return((float)(Math.max(nums1Left, nums2Left) + Math.max(nums1Right, nums2Right)) /2.);
        }
    }

    // 先合并再找中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int n = nums1.length + nums2.length;
        int[] merge = new int[n];
        int i=0,j=0;
        int k = 0;
        while(i<nums1.length && j < nums2.length) {
            if(nums1[i] < nums2[j])
                merge[k++] = nums1[i++];
            else
                merge[k++] = nums2[j++];
        }
        if(i == nums1.length){
            while(j<nums2.length)
                merge[k++] = nums2[j++];
        }
        else{
            while(i<nums1.length)
                merge[k++] = nums1[i++];
        }

        if(n % 2 == 0)
            return (merge[n/2-1]+merge[n/2])/2.;
        else
            return merge[n/2];
    }
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 假装合并，其实并没有创建新数组
        int n = nums1.length + nums2.length;
//        int[] merge = new int[n];
        int i=0,j=0;
        int k = 0;
        int res=0;
        HashSet<Integer> set = new HashSet<>();
        if(n%2==0)
            set.add(n/2-1);
        set.add(n/2);
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] < nums2[j])
            {
                if(set.contains(k++))
                    res+=nums1[i];
                i++;
            }
            else {
                if(set.contains(k++))
                    res+=nums2[j];
                j++;
            }
        }
        if(i == nums1.length){
            while(j<nums2.length) {
                if(set.contains(k++))
                    res+=nums2[j];
                j++;
            }
        }
        else{
            while(i<nums1.length) {
                if(set.contains(k++))
                    res+=nums1[i];
                i++;
            }
        }

        if(n % 2 == 0)
            return res/2.;
        else
            return res;
    }
}
