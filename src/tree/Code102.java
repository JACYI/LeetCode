package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author yiyonghao
 * @Date 2023/3/12 16:15
 */
public class Code102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> level = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        level.offer(root);
        while(!level.isEmpty()){
            List<Integer> curVals = new ArrayList<>();
            int size = level.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = level.poll();
                curVals.add(cur.val);
                if(cur.left != null)
                    level.offer(cur.left);
                if(cur.right != null)
                    level.offer(cur.right);
            }
            res.add(curVals);
        }
        return res;
    }
}
