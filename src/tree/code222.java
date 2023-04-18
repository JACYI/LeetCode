package tree;

/**
 * @Author yiyonghao
 * @Date 2023/1/11 21:47
 */
public class code222 {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;

        TreeNode tmp = root.left;
        int lc = 0, rc = 0;
        while(tmp != null){
            tmp = tmp.left;
            lc++;
        }
        tmp = root.right;
        while(tmp != null){
            tmp = tmp.right;
            rc++;
        }

        if(lc == rc)
            return 2 * lc + 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);

    }
}
