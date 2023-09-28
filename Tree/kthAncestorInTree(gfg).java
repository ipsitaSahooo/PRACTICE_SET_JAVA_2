class Solution
{
    int value=-1;
    public int kthAncestor(Node root, int k, int node)
    {
        solve(root,k,node,0); //distance=0
        return value;
    }
    
    public int solve(Node root,int k, int node,int dist)
    {
        if(root==null)
        return 0;
        
        if(root.data==node)
        return 1;
        
        int left=solve(root.left,k,node,dist);
        int right=solve(root.right,k,node,dist);
        
        if(left==0 && right==0)
        return 0;
        
        dist=left+right+1;
        
        if(dist == k+1)
        value=root.data;
        
        
        return dist;
    }
}
