class Solution
{
    //Function to return the maximum sum of non-adjacent nodes.
    static class pair
    {
        int inc; // includes the root value sum
        int exc; //excludes the root value sum
        
        pair(int inc,int exc)
        {
            this.inc=inc;
            this.exc=exc;
        }
    }
    
    static pair solve(Node root)
    {
        if(root==null) // if root is null then return a pair wiht both sum as 0
        return new pair(0,0);
        
        pair leftans=solve(root.left);
        pair rightans=solve(root.right);
        
        // Calculating the sums for the current node, considering inclusion and exclusion
        pair ans=new pair(0,0);
        ans.inc=root.data+leftans.exc+rightans.exc; // // Include root value
        ans.exc=Math.max(leftans.inc,leftans.exc) + Math.max(rightans.inc,rightans.exc); //exclude root value;
        
        return ans;
    }
    static int getMaxSum(Node root)
    {
        pair ans=solve(root);
        return Math.max(ans.inc,ans.exc);
    }
}
