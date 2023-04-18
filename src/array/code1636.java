package array;

import java.util.*;

public class code1636 {
    public int freqCompare(int i1, int i2, HashMap<Integer, Integer> map){
        int ct1 = map.get(i1); int ct2 = map.get(i2);
        return ct1 == ct2 ? i2 - i1 : ct1 - ct2;
    }
    public void adjustHeap(int[] nums, int start, int end, HashMap<Integer, Integer> map) {
        int temp = nums[start];
        for(int i=2*start; i<end; i=2*i){
            if(i+1 < end && freqCompare(nums[i], nums[i+1], map) < 0) i++;
            if(freqCompare(nums[i], temp, map) > 0){
                nums[start] = nums[i];
                start = i;
            }
            else{
                break;
            }
        }
        nums[start] = temp;
    }
    public void heapSort(int[] nums, HashMap<Integer, Integer> map) {
        for(int i=nums.length/2; i>=0; i--){
            adjustHeap(nums, i, nums.length, map);
        }
        for(int i=nums.length-1; i>=0; i--){
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            adjustHeap(nums, 0, i, map);
        }
    }
    public int[] frequencySort(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
//            list.add(num);
        }
        // 方案一：
//        Collections.sort(list, new Comparator<>() {
//            public int compare(Integer i1, Integer i2) {
//                int ct1 = map.get(i1);
//                int ct2 = map.get(i2);
//                return ct1 == ct2 ? i2 - i1 : ct1 - ct2;
//            }
//        });
//        for(int i=0; i<list.size(); i++)
//            nums[i] = list.get(i);
        // 方案二：
        heapSort(nums, map);
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{-1,1,-6,4,5,-6,1,4,1};
        code1636 c = new code1636();
        c.frequencySort(nums);
        System.out.println(nums);
        System.out.println(Integer.compare(1, -1));
    }
}
