//{ Driver Code Starts
/*import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
} */

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    void leftTraversal(Node node, ArrayList<Integer> ans)
    {
        if(node==null)
        {
            return;
        }
        //left leaf node
        if(node.left==null && node.right==null)
        {
            return;
        }
        ans.add(node.data);
        
        if(node.left!=null)
           leftTraversal(node.left,ans);
        else
           leftTraversal(node.right,ans);
    }
    
    void leafTraversal(Node node, ArrayList<Integer> ans)
    {
        if(node==null)
        {
            return;
        }
        if(node.left==null && node.right==null)//leaf node
        {
            ans.add(node.data);
        }
        leafTraversal(node.left,ans);
        leafTraversal(node.right,ans);
    }
    
    void rightTraversal(Node node, ArrayList<Integer> ans)
    {
        if(node==null)
        {
            return;
        }
        //left leaf node
        if(node.left==null && node.right==null)
        {
            return;
        }
        if(node.right!=null)
           rightTraversal(node.right,ans);
        else
           rightTraversal(node.left,ans);
           
           //after coming back add karo
           ans.add(node.data);
        
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    
	    if(node==null)
	    {
	        return ans;
	    }
	    ans.add(node.data);
	    
	    //print left part exclusive of left subtree
	    leftTraversal(node.left,ans);
	    
	    //print leaf nodes
	    leafTraversal(node.left,ans);
        leafTraversal(node.right,ans);
        
        //print right part exclusive of right subtree
	    rightTraversal(node.right,ans);
	    
	    return ans;
	}
}
