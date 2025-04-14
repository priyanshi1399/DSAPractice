import java.util.*;
public class VerticalOrderTraversal {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;


    public TreeNode(int val){
        this.val=val;
    }

    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    }

    public static void main(String [] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(10);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(10);
        root.left.left.right=new TreeNode(5);
        root.left.left.right.right=new TreeNode(6);
        verticalTraversal(root);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(root,0,0));
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>  map=new TreeMap<>();
        while(!q.isEmpty()){
            Tuple t=q.poll();
            TreeNode node=t.node;
            int x=t.x;
            int y=t.y;
            map.putIfAbsent(x,new TreeMap<>());
            map.get(x).putIfAbsent(y,new PriorityQueue<>());
            map.get(x).get(y).add(node.val);

            if(node.left!=null){
                q.add(new Tuple(node.left,x-1,y+1));
            }

            if(node.right!=null){
                q.add(new Tuple(node.right,x+1,y+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> yMap: map.values()){
            List<Integer> temp=new ArrayList<>();
            for(PriorityQueue<Integer> nodes: yMap.values()){
                while(!nodes.isEmpty()){
                    temp.add(nodes.poll());
                }
            }
            result.add(temp);
        }
        return result;
    }

    public static class Tuple{
        TreeNode node;
        int x;
        int y;

        public Tuple(TreeNode node){
            this.node=node;
        }
        public Tuple(TreeNode node,int x,int y){
            this.node=node;
            this.x=x;
            this.y=y;
        }
    }

}
