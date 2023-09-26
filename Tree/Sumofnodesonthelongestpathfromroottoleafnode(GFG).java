//TC=O(N)
//SC=O(N)
// link= https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1
class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution
{
    static int maxLen;
    static int maxSum;
     
    // function to find the sum of nodes on the
    // longest path from root to leaf node
    static void sumOfLongRootToLeafPath(Node root, int sum,int len)
    {
        // if true, then we have traversed a
        // root to leaf path
        if (root == null) {
            // update maximum length and maximum sum
            // according to the given conditions
            if (maxLen < len) 
            {
                maxLen = len;
                maxSum = sum;
            } 
            else if (maxLen == len && maxSum < sum)
                maxSum = sum;
            return;
        }
         
         
        // recur for left subtree
        sumOfLongRootToLeafPath(root.left, sum + root.data,
                                len + 1);
         
        sumOfLongRootToLeafPath(root.right, sum + root.data,
                                len + 1);
         
    }
      
    // utility function to find the sum of nodes on
    // the longest path from root to leaf node
    static int sumOfLongRootToLeafPath(Node root)
    {
        // if tree is NULL, then sum is 0
        if (root == null)
            return 0;
      
        maxSum = Integer.MIN_VALUE;
        maxLen = 0;
      
        // finding the maximum sum 'maxSum' for the
        // maximum length root to leaf path
        sumOfLongRootToLeafPath(root, 0, 0);
      
        // required maximum sum
        return maxSum;
    }
}
