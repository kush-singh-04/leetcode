 
class Solution {
    public int levels(TreeNode root, boolean[] ans){
        if(root==null) return 0;
        int leftLevels = levels(root.left,ans);
        int rightLevels = levels(root.right,ans);
        int diff = Math.abs(leftLevels-rightLevels);
        if(diff>1) ans[0] = false;
        return 1+Math.max(leftLevels,rightLevels);


    }
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = {true};
        levels(root,ans);
        return ans[0];
    }
}