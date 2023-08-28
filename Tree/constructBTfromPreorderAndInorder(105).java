class Solution 
{
    int preIndex;
    Map<Integer,Integer> inIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        preIndex=0;
        //build a hashmap to store value and index relations
        inIndex=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inIndex.put(inorder[i],i);
        }
        return arrayToTree(preorder,0,preorder.length-1);
    }
    public TreeNode arrayToTree(int[] preorder,int left,int right)
    {
        if(left>right)//no elements
        return null;

        //select the preorder index element as root and increment 
        int rootValue=preorder[preIndex++];
        TreeNode root=new TreeNode(rootValue);

        root.left=arrayToTree(preorder,left,inIndex.get(rootValue)-1);
        root.right=arrayToTree(preorder,inIndex.get(rootValue)+1,right);

        return root;
    }
}
