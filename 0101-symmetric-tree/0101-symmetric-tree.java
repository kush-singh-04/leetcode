
class Solution {
    public void invert(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
        if(p.val!=q.val) return false;
        if(isSameTree(p.left,q.left)==false) return false;
        if(isSameTree(p.right,q.right)==false) return false;
        return true;

    }
    private TreeNode copyTree(TreeNode root){
        if(root==null) return null;
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = copyTree(root.left);
        newNode.right = copyTree(root.right);
        return newNode;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode copy = copyTree(root);   // make a copy of original
        invert(copy);                     // invert the copy
        return isSameTree(root, copy);
    }
}