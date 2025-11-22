class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        // If node value is greater than high, check only left subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // If node value is smaller than low, check only right subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Otherwise, include this node and search both subtrees
        return root.val 
             + rangeSumBST(root.left, low, high) 
             + rangeSumBST(root.right, low, high);
    }
}
