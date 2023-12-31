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
    public TreeNode insertIntoBST(TreeNode root, int val)
    {
        if(root==null)
        {
            root=new TreeNode(val);
            return root;
        }
        
        //if value is grtr than node then add it to right
        if(val > root.val)
        {
            root.right=insertIntoBST(root.right,val);
        }
        else //if value is less than node then add it to left
        {
            root.left=insertIntoBST(root.left,val);
        }

        return root;
    }
}
//TC=O(logN)
//SC=O(1)
