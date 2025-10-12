
class Solution {
    public class pair{
        TreeNode node;
        int level;
        pair(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    private int levels(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(levels(root.left),levels(root.right));
    }
    private void BFS(TreeNode root,List<List<Integer>> ans){
        Queue<pair> q = new LinkedList<>();
        if(root!=null) q.add(new pair(root,0));
        while(q.size()>0){
            pair front = q.remove();
            TreeNode temp = front.node;
            int lvl = front.level;

            ans.get(lvl).add(temp.val);

            if(temp.left!=null) q.add(new pair(temp.left,lvl+1));
            if(temp.right!=null) q.add(new pair(temp.right,lvl+1));

        }
        
    }
     
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i=1;i<=lvl;i++){
            List<Integer> arr = new ArrayList<>();
             
            ans.add(arr);
        }
        BFS(root,ans);
        return ans;
    }
}