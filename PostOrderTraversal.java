import java.util.*;
public class PostOrderTraversal {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }
        public TreeNode(int data,TreeNode l,TreeNode r){
            this.val=data;
            this.left=l;
            this.right=r;
        }
    }

    public static void main(String [] args){
    TreeNode root=new TreeNode(1);
    root.right=new TreeNode(2);
    root.right.left=new TreeNode(3);
    postorderTraversal(root);
    }

    public static  List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stck=new Stack<>();
        TreeNode node =root;
        stck.push(node);
        while(!stck.isEmpty()){
            node=stck.peek();
            stck.pop();
            result.add(node.val);
            if(node.left!=null){
                stck.push(node.left);
            }

            if(node.right!=null){
                stck.push(node.right);
            }

        }
        Collections.reverse(result);
        return result;
    }


}
