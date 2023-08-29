 ArrayList<Integer> list=new ArrayList<>();
        if(root == null)
        {
            return list;
        }
        
        TreeMap<Integer,Integer> top=new TreeMap<>();
        
        Queue<pair> q=new LinkedList<>();
        q.offer(new pair(root,0));
        
        while(!q.isEmpty())
        {
            pair p=q.poll();
            root=p.node;
            int vertical=p.row;
            
            top.putIfAbsent(vertical,root.data);
            
            if(root.left!=null)
            q.offer(new pair(root.left,vertical-1));
            
            if(root.right != null)
            q.offer(new pair(root.right,vertical+1));
        }
        list.addAll(top.values());
        return list;
//OR
class Solution
{
   
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
         ArrayList<Integer> ans=new ArrayList<>();
        TreeMap<Integer,int[]> hm=new TreeMap<>();
        help(root,0,0,hm);
        for(var i:hm.entrySet())
        {
            ans.add(i.getValue()[0]);
        }
        return ans;
        
        
    }
    public void help(Node root,int level,int verlevel,TreeMap<Integer,int[]> hm){
        if(root==null)return;
        if(!hm.containsKey(verlevel)||hm.get(verlevel)[1]<=level)
        hm.put(verlevel,new int[]{root.data,level});
        help(root.left,level+1,verlevel-1,hm);
        help(root.right,level+1,verlevel+1,hm);
    }
}
