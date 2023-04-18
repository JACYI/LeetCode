package Algorithm;

import javax.swing.text.Segment;

// 线段树求区间最大值，使用数组存储
// 设当前根节点（索引）为 r，左子树索引为2r，右子树索引为2r+1
//
class SegmentNums {
    int[] segment;  // 存储区间最大值
    SegmentNums(int[] nums){
        segment = new int[4*nums.length];
        build(0, nums.length-1, nums, 1);
    }

    void build(int left, int right, int[] nums, int r) {
        // 递归中止，叶子结点
        if(left == right) {
            segment[r] = nums[left];
            return;
        }
        int mid = (right+left)/2;

        // 递归构建左右子树
        if(2*r < segment.length)
            build(left, mid, nums, 2*r);
        if(2*r+1 < segment.length)
            build(mid+1, right, nums, 2*r+1);

        // 回溯更新树节点
        int leftMax = 2*r < segment.length ? segment[2*r] : Integer.MIN_VALUE;
        int rightMax = 2*r+1 < segment.length ? segment[2*r+1] : Integer.MIN_VALUE;
        segment[r] = Math.max(leftMax, rightMax);
    }
    // left 和 right 表示当前区间，start 和 end 表示查询区间，默认值 left<=start<=end<=right
    int query(int left, int right, int start, int end, int r) {
        if(start == left && end == right)
            return segment[r];

        //
        int mid = left + (right-left)/2;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        // 当前区间和查询区间有以下三种情况
        // 情况1：查询区间不被当前区间包含，直接返回整数最小值 (本代码中不会出现)
        // 情况2：查询区间不包含当前区间中点，即在区间的左子树或者右子树，仅需要查询单个子树
        // 情况3：当前区间中点在查询区间内，需要在当前区间左右子树分别查询

        // 左子树区间查找
        if(start <= mid){
            if(end <= mid)      // 情况2:在左子树查询即可
                leftMax = query(left, mid, start, end, 2*r);
            else                // 情况3
                leftMax = query(left, mid, start, mid, 2*r);
        }
        // 右子树区间查找
        if(end > mid){
            if(start > mid)     // 情况2：在右子树查询即可
                rightMax = query(mid+1, right, start, end, 2*r+1);
            else                // 情况3
                rightMax = query(mid+1, right, mid+1, end, 2*r+1);
        }

        return Math.max(leftMax, rightMax);
    }
}

// 线段树求数组区间和示例，使用二叉树存储
public class SegmentTree {
    static class SegmentTreeNode {
        int start;
        int end;
        // 区间目标值（和、最大值、最小值）
        int sum;

        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end, int[] nums) {
        // 递归中止条件
        if(start == end)
            return new SegmentTreeNode(start, end, nums[start]);

        SegmentTreeNode curNode = new SegmentTreeNode(start, end, 0);
        // 递归建立左右子树
        int mid = start + (end - start)/2;
        curNode.left = build(start, mid, nums);
        curNode.right = build(mid+1, end, nums);

        // 回溯更新目标值
        if(curNode.left != null)
            curNode.sum += curNode.left.sum;
        if(curNode.right != null)
            curNode.sum += curNode.right.sum;

        return curNode;
    }
    // 查询区间[start, end]
    public int query(SegmentTreeNode root, int start, int end) {
        // 递归中止条件
        if(start == root.start && end == root.end)
            return root.sum;

        int sum = 0;
        // 左右子树递归查找
        int mid = root.start + (root.end-root.start)/2;
        // 需要到root的左子树进行查询
        if(start <= mid){
            if(end < mid)   // 情况1：左子树包含查询区间
                sum += query(root.left, start, end);
            else            // 情况2：左子树与查询区间相交
                sum += query(root.left, start, mid);
        }
        // 需要到root的右子树查询
        if(end > mid){
            if(start > mid) // 情况3：右子树包含查询区间
                sum += query(root.right, start, end);
            else            // 情况4：右子树与查询区间相交
                sum += query(root.right, mid+1, end);
        }

        return sum;
    }
    public int modify(SegmentTreeNode root, int start, int end) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,8,9,10};
        SegmentNums segmentNums = new SegmentNums(nums);
        System.out.println(segmentNums.query(0, nums.length-1, 5, 5, 1));
//        System.out.println(segmentTree.query(treeSum, 0, 9));
//        System.out.println(segmentTree.query(treeSum, 2, 4));
    }
}
