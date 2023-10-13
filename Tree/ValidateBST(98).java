

 //approach 1
 //find inorder (inorder in BST is always in ascending order)
 //check if it is in ascen order
class Solution
{
    public boolean isValidBST(TreeNode root)
    {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);        
    }
    public boolean isValidBST(TreeNode root, long min, long max)
    {
        if(root == null)
        return true;

        if(root.val >= max || root.val <= min)
        return false;
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }

}
//TC=SC=O(n)
