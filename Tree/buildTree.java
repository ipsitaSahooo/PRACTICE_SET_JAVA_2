public static Node buildTree(Node root)
  {
  Scanner s=new Scanner(System.in);
 int data=s.nextInt();

root=new Node(data);
 if(data == -1)
   return null;

root.left=buildTree(root.left);
root.right=buildTree(root.right);
return root
  }
