import java.util.HashMap;

public class PathSum3 {
    
    private static int sum=0;
    private static HashMap<Integer,Integer> map=new HashMap<>();
    private static int ans=0;

    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }

        public Node(int data,Node left, Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
    }
    public static void main(String [] args) {

        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(-3);
        root.left.left=new Node(3);
        root.left.left.left=new Node(3);
        root.left.left.right=new Node(-2);
        root.left.right=new Node(2);
        root.left.right.right=new Node(1);
        root.right.right=new Node(11);
        int k=8;
        sumK(root,k);

        System.out.println("Maximum Path Sum: " + ans);
    }




    
    public static void solve(PathSum3.Node root, int k){
        if(root==null){
            return;
        }

        sum+=root.data;
        if(map.containsKey(sum-k)){
            ans+=map.get(sum-k);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        solve(root.left,k);
        solve(root.right,k);
        map.put(sum,map.get(sum)-1);
        sum=sum-root.data;
    }


    public static  int sumK(Node root, int k) {
        map.put(0,1);
        solve(root,k);
        return ans;


    }
}
