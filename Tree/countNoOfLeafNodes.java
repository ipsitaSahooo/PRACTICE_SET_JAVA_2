/*******************************************************
    Following is the Binary Tree Node class structure.
    class BinaryTreeNode<T> {
      T data;
      BinaryTreeNode<T> left;
      BinaryTreeNode<T> right;
      
      public BinaryTreeNode(T data) {
        this.data = data;
      }
    }
*******************************************************/

public class Solution 
{
  
	public static int noOfLeafNodes(BinaryTreeNode<Integer> root) 
  {
    if(root == null)
    return 0;

    if(root.right==null && root.left==null)
    {
      return 1;
    }
    else{
    int c=0;
    c=noOfLeafNodes(root.left)+noOfLeafNodes(root.right);
    return c;
    }
	}
}
