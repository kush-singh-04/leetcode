/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 1, ans = 1, max = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            int sum = 0;
            for (int i = q.size(); i > 0; i--) {
                TreeNode n = q.poll();
                sum += n.val;
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            if (sum > max) { max = sum; ans = level; }
            level++;
        }
        return ans;
    }
}
