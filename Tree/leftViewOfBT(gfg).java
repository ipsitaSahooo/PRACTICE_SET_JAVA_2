class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        solve(root,ans,0);
        return ans;
    }
    void solve(Node root, ArrayList<Integer> ans,int level)
    {
        if(root==null)
        return;
        
        //entered into new level
        if(level==ans.size())
        ans.add(root.data);
        
        solve(root.left,ans,level+1);
        solve(root.right,ans,level+1);
    }
}
