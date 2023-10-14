// you can do it same way as Kth Smallest Element in bst (230) .
// kth largest element is same as ((n-k)+1)th smallest elemnt in bst

//TC=SC=O(n)

class Solution {
    public int kthLargest(TreeNode root, int k)
    {
        int count[]=new int[1]; // counter variable to reach till k
        int ans=solve(root,count,n-k+1);
        return ans;
    }
    public int solve(TreeNode root,int count[],int k)
    {
        if(root == null)
        return -1;

        //first left - since we need th smallest one
        int left=solve(root.left,count,k);
        if(left != -1)
        return left; // got ans in left

        //else see the root 
        count[0]++;
        if( count[0] == k)
        return root.val;

        // right - if it is neither in left nor in root , then it will be in right
        return solve(root.right,count,k);

    }
}


OR
  class solution
  {
    public int KthLargest(TreeNode root,int k)
    {
      int count[]=new int[1];
      int ans=solve(root,k,count)
        return ans;
    }
    public int solve(TreeNode root, int k, int count[])
    {
      if(root == null)
        return -1;
      //check in right for largest as right contains all the elements that are grtr than root
    int right=solve(root.right,k,count);
      if(right != null)
        return right;

    //check in root
    count[0]++;
      if(count[0]==k)
        return root.val;

    //check in left
      return solve(root.left,k,count);
    }
  }

OR
  class Solution {
    public int kthLargest(TreeNode root, int k)
  {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return arr.get(n-k);
    }
    public static void inorder(TreeNode root,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}
