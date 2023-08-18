//Time complexity:O(n)
//Space complexity:O(n)
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
class Solution 
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        boolean flag=false;

        if(root==null)
        {
            return ans;
        }
        q.add(root);

        while(!q.isEmpty())
        {
            List<Integer> list=new LinkedList<>();
            int n=q.size();

            for(int i=0;i<n;i++)
            {
                if(q.peek().left!=null)
                q.add(q.peek().left);

                if(q.peek().right!=null)
                q.add(q.peek().right);

                list.add(q.remove().val);
            }
            if(flag==true)
            Collections.reverse(list);

            flag=!flag;
            ans.add(list);
        }
        return ans;
    }
}
