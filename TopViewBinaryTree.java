import java.util.*;
public class TopViewBinaryTree {

    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static void main(String [] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        topView(root);
    }

    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Pair<Node,Integer>> q=new LinkedList<>();
        if(root==null){
            return result;
        }
        TreeMap<Integer,Integer> map=new TreeMap<>();
        q.add(new Pair<>(root,0)); //pushing the root
        while(!q.isEmpty()){
            Pair<Node,Integer> pair=q.poll();
            Node node=pair.getKey();
            int line=pair.getValue();

            if(!map.containsKey(line)){
                map.put(line,node.val);
            }

            if(node.left!=null){
                q.add(new Pair<>(node.left,line-1));
            }
            if(node.right!=null){
                q.add(new Pair<>(node.right,line+1));
            }
        }
        for(int value:map.values()){
            result.add(value);
        }
        return result;

    }
    public  static class Pair<F,S>{
        private final F First;
        private final S Second;

        Pair(F first, S second){
            this.First=first;
            this.Second=second;
        }

        public F getKey(){
            return First;
        }
        public S getValue(){
            return Second;
        }

    }
}
