class Solution
{
    static class pair
    {
        Node node;
        int row;
        
        public pair(Node node,int row)
        {
            this.node=node;
            this.row=row;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
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
    }
}
