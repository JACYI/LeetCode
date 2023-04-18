import java.util.ArrayList;

public class
test01 {
    // 调整当前节点到end节点的子树
    public void adjustHeap(int[] nums, int start, int end) {
        int temp = nums[start];
        for(int i = 2*start; i < end; i = 2*i){
            // 比较左右子树
            if(i+1 < end && nums[i] < nums[i+1])
                i++;
            // 子树大于根节点，则倒置，相等则跳出循环
            if(nums[i] > temp){
                nums[start] = nums[i];
                start = i;
            }
            else
                break;
        }
        nums[start] = temp;
    }
    public void heapSort(int[] nums) {
        // 遍历以根节点建立大根堆，
        for(int i=nums.length/2; i >= 0; i--){
            // 时间复杂度为 O(n)
            adjustHeap(nums, i, nums.length);
        }
        for(int i=nums.length-1; i>=0; i--){
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjustHeap(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        long l = 1L;
        int l2i = (int) l;
        ArrayList<Integer> arrayList = new ArrayList<>();
        String s; StringBuilder stringBuilder; StringBuffer stringBuffer;
        int sum = 123;
        int cnt = 0;
        while(sum != 0) {
            cnt++;
            sum--;
            if(cnt % 11 == 0)
                sum++;

        }
        System.out.println(cnt);
//        System.out.println((Number) d.equals ((Number) i));
    }
}
