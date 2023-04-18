package interview;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yiyonghao
 * @Date 2022/12/6 20:13
 */

public class ZhiYu {
    /*****************************************************************
     *                     1.	函数topRange                          *
     * 函数topRange接受1个数组v为参数，对v中的每一个元素，返回其为前连续多少个 *
     * 值内的最大值。每个元素的对应的仅仅与其之前的元素相关，与其之后的元素无关。*
     * 返回一个与v相同长度的向量。请给出算法的复杂度，并且证明它。            *
     ****************************************************************/
    // 时间复杂度 O(n^2)
    // 找到小于等于 target 的最长连续子数组的长度, 到end截止
    private int findRange(double[] nums, double target, int end) {
        int i=0, j=0;
        int maxLength = 1;
        Deque<Double> queue = new ArrayDeque<>();
        while(j < end) {
            // 单调不增队列
            while(!queue.isEmpty() && Double.compare(queue.peekLast(), nums[j]) < 0)
                queue.pollLast();
            queue.offerLast(nums[j]);
            j++;

            // 当队列中有大于target的数时，收缩，直到[i, j)内全是小于或者等于target的
            while(!queue.isEmpty() && Double.compare(queue.peekFirst(), target) > 0) {
                if(nums[i++] == queue.peekFirst())
                    queue.pollFirst();
            }

            maxLength = Math.max(maxLength, j - i);

        }
        return maxLength;
    }
    public int[] topRange(double[] v) {
        int[] res = new int[v.length];
        for(int i=0; i<v.length; i++){
            res[i] = findRange(v, v[i], i+1);
        }
        return res;
    }


    /*****************************************************************
     *                     2.	内存                                  *
     ****************************************************************/
    // 时间复杂度 O(m1 + m2)
    public int[] mermoryCheck(int m1, int m2) {
        // 返回的数组元素为[time, m1Res, m2Res]
        int time = 0;
        while(true) {
            if(Math.max(m1, m2) < time)
                return new int[]{time, m1, m2};

//            int sub = Math.abs(m1 - m2);
//            int endTime = (int) Math.round((Math.sqrt((long)8 * sub + 4*time*time - 2*time + 1) - 1)/2);
//            time = endTime;
//            if(endTime > time){
//
//            }

            if(m1 >= m2)
                m1 -= time;
            else
                m2 -= time;
            time++;
        }
    }

    /*****************************************************************
     *                     3.	函数cumrank                           *
     ****************************************************************/
    // 时间复杂度 O(nlogn)
    public int[] cumrank(int[] v) {
        if(v.length < 1)
            return new int[0];
        class TreeNode {
            int val;
            int leftNum;    // 记录该节点的左子树的节点数
            TreeNode left;
            TreeNode right;
            public TreeNode(int _val, int _leftNum, TreeNode _left, TreeNode _right) {
                val = _val;
                leftNum = _leftNum;
                left = _left;
                right = _right;
            }
            public TreeNode() {

            }
        }

        int[] res = new int[v.length];
        res[0] = 1;
        // 整体思想：依次遍历数组并建立一棵二叉搜索树，保存每个节点左子树的节点数，
        // 元素位于其左边的子数组的排序位置 等价于 二叉搜索树小于当前节点的节点数
        // 存储节点中的左子树节点数，可以在本节点获取到比本节点小的节点数
        TreeNode root = new TreeNode(v[0], 0, null, null);
        for(int i=1; i<v.length; i++){
            TreeNode cur = root;
            int num = 0;    // 记录小于本节点值的节点数，即结果值
            while(true){
                // 1. 放到左子树, 本节点的leftNum自增1
                if(v[i] < cur.val) {
                    cur.leftNum++;
                    if(cur.left == null){
                        // 插入到右子树
                        cur.left = new TreeNode(v[i], 0, null, null);
                        res[i] = num;
                        break;
                    } else
                        cur = cur.left;
                } else {
                    // 2. 放到右子树，当前节点大于本节点左子树的所有节点，记录的总结点数需要加上当前节点左子树的leftNum（+1）
                    if(cur.val == v[i])
                        num += cur.leftNum;
                    else
                        num += cur.leftNum + 1; // 加上本节点
                    if(cur.right == null){
                        // 插入到右子树
                        cur.right = new TreeNode(v[i], 0, null, null);
                        res[i] = num;
                        break;
                    } else
                        cur = cur.right;
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        ZhiYu test = new ZhiYu();

        // 1. test
        int[] x = test.topRange(new double[]{13.5,13.6,13.4,13.3,13.5,13.9,13.1,20.1,20.2,20.3});
        for(int i:x)
            System.out.print(i + " ");

        // 2.test
        System.out.println();
        int[] z1 = test.mermoryCheck(2, 2);
        for(int num:z1)
            System.out.print(num + " ");

        System.out.println();
        int[] z2 = test.mermoryCheck(8, 11);
        for(int num:z2)
            System.out.print(num + " ");


        // 3. test
        System.out.println();
        int[] y = test.cumrank(new int[]{1,3,2,3,4});
        for(int num:y)
            System.out.print(num + " ");
    }
}
