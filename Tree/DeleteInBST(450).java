class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) 
        return null;
        
        if(key<root.val) //check in left subtree
        {                            
            root.left = deleteNode(root.left,key);
            return root;
        }
        
        else if(key>root.val) //check in the right subtree
        {
            root.right = deleteNode(root.right,key);
            return root;
        }
        
        else //root is the node then there will be 3 cases
        {
            if(root.left==null) //1st-left root is null,delete root & return right
            {
                return root.right;
            }
            else if(root.right==null)//2nd-right root is null,delete root & return left
            {
                return root.left;
            }
            else //neither left nor right root is null,delete root but maintain BST
            {
                TreeNode min = root.right; //so that root is grtr than all nodes in left and smaller than all nodes in right
                while(min.left!=null) //get the leftmost node of the right subtree
                {
                    min = min.left;
                }
                
                root.val = min.val;//deleteing root value and replace it by min val
                root.right = deleteNode(root.right,min.val); //so now just pass that right subtree in which the value is present with that nodes value which will be now the target
                return root;
            }
        }
    }
}
