//https://www.codingninjas.com/studio/problems/_893049?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0

import java.util.List; // not 100% effcient
import java.util.*;
//TC=SC=O(n)
public class Solution
{
    public static void inorder(TreeNode root, List<Integer> arr)
    {
        if(root == null)
        return;

        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    public static List<Integer> predecessorSuccessor(TreeNode root, int key)
    {
        List<Integer> arr=new ArrayList<>(); //to store the inorder
        inorder(root,arr);

        int pre=-1;//predecessor
        int succ=-1;//Successor

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i) < key)
            pre=arr.get(i);

            if(arr.get(i) > key)
            {
            succ=arr.get(i);
            break;
            }
        }
        ans.add(pre);
        ans.add(succ);
        return ans;
    }
}

OR

    //TC=O(N)
    //SC=O(1)
  import java.util.ArrayList;
import java.util.List;
public class Solution
{
    public static List<Integer> predecessorSuccessor(TreeNode root, int key)
     {
        List<Integer> ans=new ArrayList<>();
        TreeNode temp=root;

        int pre=-1;
        int suc=-1;

        //1)reach key node 
        while(temp!=null)
        {
            if(temp.data==key)
            {
                break;
            }
            else if(temp.data>key)
            {
                //left subtree 
                suc=temp.data;//possible succ ho sakta hai kyu ki bada hai temp data 
                temp=temp.left;
            }

            else
            {
                //right subtree
                pre=temp.data;//possible pre ho sakta hai kyu ki chhota hai temp data 
                temp=temp.right;
            }
        }

        //2)prec find(left subtree max value)
        if(temp!=null && temp.left!=null)
        {
            TreeNode leftsubtree=temp.left;
            while(leftsubtree.right!=null)
            {
                leftsubtree=leftsubtree.right;
            }
            pre=leftsubtree.data;
       }


        if(temp!=null && temp.right!=null)
        {
            //3)suc find(right subtree min value)
            TreeNode rightsubtree=temp.right;
            while(rightsubtree.left!=null)
            {
                rightsubtree=rightsubtree.left;
            }
            suc=rightsubtree.data;
        }

        ans.add(pre);
        ans.add(suc);

        return ans;

    } 
}
  
