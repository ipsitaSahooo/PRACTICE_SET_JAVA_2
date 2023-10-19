class Solution
{
    public void inorder(TreeNode root,ArrayList<Integer> arr)
    {
        if(root == null)
        return;

        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }

    public TreeNode inorderToBST(int s, int e,ArrayList<Integer> arr)
    {
        if(s>e)
        return null;

        int mid=(s+e)/2;
        TreeNode root=new TreeNode(arr.get(mid));

        root.left=inorderToBST(s,mid-1,arr);
        root.right=inorderToBST(mid+1,e,arr);
        return root;
    }
    public TreeNode balanceBST(TreeNode root)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);

        return inorderToBST(0,arr.size()-1,arr);
    }
}
