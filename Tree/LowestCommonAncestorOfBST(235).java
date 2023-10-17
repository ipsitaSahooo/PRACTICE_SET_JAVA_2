

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
        return null;

        if(root.val<p.val && root.val<q.val) //so p and q are in right
        return lowestCommonAncestor(root.right,p,q);

        if(root.val>p.val && root.val>q.val) ////so p and q are in left
        return lowestCommonAncestor(root.left,p,q);

        return root;
    }
}
