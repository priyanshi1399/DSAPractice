public class DiameterOfBT {
    private static int result=Integer.MIN_VALUE;
    public static class Node{
        int data;
        Node left;
        Node right;
        
        public Node(int data){
            this.data=data;
        }
        
        public Node(int data,Node left,Node right){
            this.data=data;
            this.left=left;
            this.right=right;
        }
        
    }
    
    public static void main(String [] args) {

        Node root = new Node(1);
        root.left = new Node(5);
        root.left.left = new Node(8);
        root.left.right = new Node(6);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(7);
        root.left.right.left = new Node(9);
        diameter(root);
    }
       public static  int solve(Node root){
            if(root==null){
                return 0;
            }
            int left=solve(root.left);
            int right=solve(root.right);

            result=Math.max(result,left+right); //updating result everytime

            return 1+Math.max(left,right); //what it resturns from left,right(max)
        }

        public static int diameter(Node root) {

            solve(root);
            return result;

        }



        
    }
    
    

