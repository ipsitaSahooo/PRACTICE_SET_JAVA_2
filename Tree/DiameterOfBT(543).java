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
//TC=O(N)
class Solution 
{
    int ans=-1;
    public int diameterOfBinaryTree(TreeNode root) 
    {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root)
    {
        if(root == null)
        return -1;

        int left = 1+dfs(root.left);
        int right = 1+dfs(root.right);
        ans=Math.max(ans,(left+right));
        return Math.max(left,right);
    }
}
