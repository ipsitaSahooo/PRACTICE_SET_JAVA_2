//https://www.codingninjas.com/studio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=1
public class Solution
{
    public static void inorder(TreeNode<Integer> root,ArrayList<Integer> arr)
    {
        if(root == null)
        return;

        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public static TreeNode<Integer> flatten(TreeNode<Integer> root)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        int size=arr.size();

        TreeNode<Integer> newRoot=new TreeNode<>(arr.get(0));
        TreeNode<Integer> curr=newRoot;

        for(int i=1;i<size;i++)
        {
            TreeNode<Integer> temp=new TreeNode<>(arr.get(i));

            curr.left=null;
            curr.right=temp;//make link
            curr=temp;
        }

        curr.left=null;//remove link
        curr.right=null;//last node will pt to null

        return newRoot;
    }
}
