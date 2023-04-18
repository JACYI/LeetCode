package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PrintTree {
    int height;
    int dfs_depth(TreeNode root, int depth) {
        if(null == root) return depth;
        return Math.max(dfs_depth(root.left, depth+1), dfs_depth(root.right, depth+1));
    }
    void dfs_print(TreeNode root, List<List<String>> res, int row, int col) {
        if(null == root) return;
        res.get(row).set(col, Integer.toString(root.val));
        dfs_print(root.left, res, row+1, col - (1 << (height - row - 1)));
        dfs_print(root.right, res, row + 1, col + (1 << (height - row - 1)));
    }
    public List<List<String>> printTree(TreeNode root) {
        height = dfs_depth(root, -1);
        int m = height+1;
        int n = (1<<(height+1))-1;
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        System.out.println(m);
        System.out.println(n);
        dfs_print(root, res, 0, 2^height-1);
        return res;
    }

}
class test{
    public static void main(String[] args) {
        PrintTree printTree = new PrintTree();
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1, left, right);
        List res = printTree.printTree(root);

    }
}
