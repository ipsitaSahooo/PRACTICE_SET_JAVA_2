//TC=O(n^2)
class Solution 
{
    public int maxDepth(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        int leftHt=maxDepth(root.left);
        int rightHt=maxDepth(root.right);

        int ht=Math.max(leftHt,rightHt)+1;
        return ht; 

    }
    public int diameterOfBinaryTree(TreeNode root) 
    {
        if(root == null)
        return 0;

        //three ways to find diameter
        int diam1=diameterOfBinaryTree(root.left);//diam is in left subtree
        int diam2=diameterOfBinaryTree(root.right);//diam is in right subtree
        int diam3=maxDepth(root.left) + maxDepth(root.right)+1;//diameter from left subtree to right subtree

        return Math.max(diam3,Math.max(diam2,diam1));
    }
}
