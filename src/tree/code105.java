package tree;

public class code105 {
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int mid = inStart;
        for(; mid<=inEnd; mid++){
            if(inorder[mid] == root.val)
                break;
        }
        // 注意：子树的preStart、preEnd必须由中序遍历数组元素数确认
        int size = mid - inStart;
        root.left = build(preorder, preStart + 1, preStart + size,
                inorder, inStart, mid - 1);
        root.right = build(preorder, preStart + size + 1, preEnd,
                inorder, mid + 1, inEnd);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }
}
