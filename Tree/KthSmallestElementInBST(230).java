 //TC=O(n)
 //SC=O(height)=O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k)
    {
        int count[]=new int[1]; // counter variable to reach till k
        int ans=solve(root,count,k);
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
//using Inorder traversal
  class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return arr.get(k-1);
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
