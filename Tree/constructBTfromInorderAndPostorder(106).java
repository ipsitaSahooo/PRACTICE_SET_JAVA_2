
class Solution 
{
    int postIndex;
    Map<Integer,Integer> inIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        postIndex=postorder.length-1;

        //create hashmap to get the relation between value and index
        inIndex=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            inIndex.put(inorder[i],i);
        }
        return arrayToTree(postorder,0,postorder.length-1);
    }
    public TreeNode arrayToTree( int[] postorder,int left,int right)
    {
        if(left>right)//mo elements
        return null;

        int rootValue=postorder[postIndex--];
        TreeNode root=new TreeNode(rootValue);

        root.right=arrayToTree(postorder,inIndex.get(rootValue)+1,right);
        root.left=arrayToTree(postorder,left,inIndex.get(rootValue)-1);

        return root;
    }
}
