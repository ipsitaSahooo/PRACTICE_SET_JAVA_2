class Solution 
{
    public int pathSum(TreeNode root, int targetSum) 
  {
        if(root == null)
            return 0;
        
        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + helper(root, 0, targetSum);
    }
    
    int helper(TreeNode root, int current, int target) {
        if(root == null)
            return 0;
        
        current += root.val;
        
        return (current == target ? 1 : 0) + helper(root.left, current, target) + helper(root.right, current, target);
    }
}

//OR

class Solution
{
    int count=0;
    public int sumK(Node root,int k){
        // code here 
        HashMap<Integer, Integer> hm = new HashMap<>();
        solve(root, k, 0, hm);
        return count;
    }
    
    public void solve(Node root, int k, int sum, HashMap<Integer, Integer> hm){
        if(root==null)
            return;
            
        sum+=root.data;
        count+=hm.getOrDefault(sum-k, 0);
        if(sum==k)
            count++;
        
        hm.put(sum, hm.getOrDefault(sum, 0)+1);
        
        solve(root.left, k, sum, hm);
        solve(root.right, k, sum, hm);
        
        hm.put(sum, hm.getOrDefault(sum, 0)-1);
    }
}
