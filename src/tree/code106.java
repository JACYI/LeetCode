package tree;

import java.util.HashMap;

public class code106 {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private TreeNode build(int[] inorder, int inStart, int inEnd,
                      int[] postorder, int postStart, int postEnd) {
        if(inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int mid = map.get(postorder[postEnd]);
        int size = inEnd - mid;
        root.left = build(inorder, inStart, mid - 1, postorder, postStart, postEnd - size - 1);
        root.right = build(inorder, mid + 1, inEnd, postorder, inEnd - size, postEnd - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}
