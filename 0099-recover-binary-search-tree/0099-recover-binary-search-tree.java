class Solution {
    TreeNode first = null, second = null, prev = null;

    public void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;   // first wrong node
            }
            second = root;      // second wrong node
        }
        prev = root;

        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
