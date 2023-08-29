class Solution 
{
    public List<Integer> rightSideView(TreeNode root) 
    {
        ArrayList<Integer> ans=new ArrayList<>();
        solve(root,ans,0);
        return ans;
    }
    public void solve(TreeNode root, ArrayList<Integer> ans,int level)
    {
        if(root==null)
        return;
        
        //entered into new level
        if(level==ans.size())
        ans.add(root.val);
        
        solve(root.right,ans,level+1);
        solve(root.left,ans,level+1);
    }
}
