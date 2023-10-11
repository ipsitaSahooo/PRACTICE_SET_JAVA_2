class solution
  {
    // QUES- RETURN THE MINIMUM VALUE NODE IN BST
    public Node minValue(Node root) 
    {
      Node temp=root;
       while(temp != null)
         {
           temp=temp.left;
         }
      return temp;
    }
  }


class solution
  {
    // QUES- RETURN THE MAXIMUM VALUE NODE IN BST
    public Node maxValue(Node root) 
    {
      Node temp=root;
       while(temp != null)
         {
           temp=temp.right;
         }
      return temp;
    }
  }
      
