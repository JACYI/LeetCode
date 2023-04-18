package tree;

import com.sun.source.tree.Tree;

import java.util.*;

public class code652 {
    public StringBuilder tree2String(TreeNode root, StringBuilder s) {
        if(root == null) return s;
        s.append(Integer.toString(root.val) + ' ');
        if(root.left != null)
            s = tree2String(root.left, s);
        else
            s.append('n');
        if(root.right != null)
            s = tree2String(root.right, s);
        else
            s.append('n');
        return s;
    }
    public void dfs(TreeNode root, HashMap<String, Integer> map, List<TreeNode> res) {
        if(root == null) return;
        // 将该子树存入map
        String stringTree = tree2String(root, new StringBuilder()).toString();
        int times = map.getOrDefault(stringTree, 0) + 1;
        map.put(stringTree, times);
        if(times == 2)
            res.add(root);
        // 是叶子结点
//        if(root.left == null && root.right == null)
//            map.put(map.get())
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null || (root.left==null && root.right==null))
            return new ArrayList<>();
        // 使用字符串存储子树
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();

        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            dfs(cur, map, res);
            cur = cur.right;
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        code652 c = new code652();
        TreeNode root = new TreeNode(11, new TreeNode(1), new TreeNode(11));
        System.out.println(c.tree2String(root, new StringBuilder()));
    }
}
