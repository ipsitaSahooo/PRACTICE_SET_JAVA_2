/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public void path(TreeNode root,String str,LinkedList<String> list)
    {
        if(root!=null)
        {
            str+=Integer.toString(root.val);

            if(root.left==null && root.right==null)//if reach leaf
            {
                list.add(str);
            }
            else
            {
                str+="->";
                path(root.left,str,list);
                path(root.right,str,list);
            }
        }
    }
    public List<String> binaryTreePaths(TreeNode root) 
    {
        LinkedList<String> list=new LinkedList<>();
        path(root , "" , list);
        return list;
    }
}
