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
    public int height(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftHt=height(root.left);
        int rightHt=height(root.right);

        if(leftHt==-1 || rightHt==-1)
        return -1;

        if(Math.abs(leftHt-rightHt)>1)
        return -1;
        
        int ht=Math.max(leftHt,rightHt)+1;
        return ht;
    }
    public boolean isBalanced(TreeNode root) 
    {
        if(root == null)
        return true;

        if(height(root) == -1)
        return false;
        else
        return true;
    }
}
