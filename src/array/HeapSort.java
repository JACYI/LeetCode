package array;

public class HeapSort {
    public static void adjustHeap(int[] nums, int i, int length) {
        // 调整第i个节点到第length-1个节点，使其符合大根堆规则
        int temp = nums[i];

        for(int k=2*i+1; k < length; k = k * 2 + 1) {
            // 左子树小于右子树，切换到右子树对调
            if(k+1 < length && nums[k] < nums[k+1])
                k++;
            if(nums[k] > temp){
                // 子节点大于父节点值，交换
                nums[i] = nums[k];
                i = k;
            }
            else{
                // 左右子树均小于等于父节点值，返回
                break;
            }
        }
        nums[i] = temp;
    }
    public static void heapSort(int[] nums) {
        int length = nums.length;
        if(length < 2) return;
        // 遍历非叶子节点，调整Nums为大根堆
        for(int i=length/2; i>=0; i--){
            adjustHeap(nums, i, length);
        }
        for(int j=length-1; j > 0; j--){
            // 将根节点放在最后，调整新的根节点，i表示当前最小的有序索引
            int temp = nums[0];
            nums[0] = nums[j];
            nums[j] = temp;
            // 调整新的根节点使得除了第i个以及第i后面的元素之外，nums是大根堆
            adjustHeap(nums, 0, j);
        }
    }
}
