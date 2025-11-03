import java.util.*;
public class AmoutOfTimeForBinaryTreeToBeinfected {
    
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val=val;
        }
        public TreeNode (int val,TreeNode left,TreeNode right ){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static void main(String [] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(5);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(9);
        root.left.right.right=new TreeNode(2);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(6);
        int start=3;
        amountOfTime(root,start);
    }

    private static HashMap<TreeNode,TreeNode> parentMap=new HashMap<>();
    public static void inorder(TreeNode root){

        if(root==null){
            return;
        }

        if(root.left!=null){
            parentMap.put(root.left,root);
        }
        inorder(root.left);
        if(root.right!=null){
            parentMap.put(root.right,root);
        }
        inorder(root.right);
    }
    public static TreeNode makeNode(TreeNode root,int start){
        if(root==null){
            return null;
        }
        if(root.val==start){
            return root;
        }

        TreeNode left=makeNode(root.left,start);
        if(left!=null){
            return left;
        }
        return makeNode(root.right,start);
    }
    public static int amountOfTime(TreeNode root, int start) {
        inorder(root);
        Queue<TreeNode> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        int count=0;
        TreeNode startNode=makeNode(root,start);
        q.add(startNode);
        visited.add(startNode.val);
        while(!q.isEmpty()){
            int n=q.size();

            while(n -->0){
                TreeNode curr=q.poll();
                if(curr.left!=null && (!visited.contains(curr.left.val))){
                    q.add(curr.left);
                    visited.add(curr.left.val);
                }
                if(curr.right!=null && (!visited.contains(curr.right.val))){
                    q.add(curr.right);
                    visited.add(curr.right.val);
                }
                if(parentMap.containsKey(curr) && (!visited.contains(parentMap.get(curr).val))){
                    TreeNode temp=parentMap.get(curr);
                    q.add(parentMap.get(curr));
                    visited.add(temp.val);
                }
            }
            count++;
        }
        return count-1;
    }
}
