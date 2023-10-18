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
    public boolean findTarget(TreeNode root, int k)
    {
        ArrayList<Integer> arr=new ArrayList<>(); //store the inorder array
        inorder(root,arr);

        int sum=0;
        int i=0;
        int j=arr.size()-1;

        while(i<j)
        {
            sum=arr.get(i)+arr.get(j);

            if(sum == k)
            return true;

            if(sum > k)
            j--;

            if(sum < k)
            i++;
        }

        return false;
    }
}

//TC=SC=O(N)
