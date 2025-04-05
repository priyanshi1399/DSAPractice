import java.util.*;
public class DistanceAtKinBinaryTree {

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
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(6);
        root.left.right=new TreeNode(2);
        root.left.right.left=new TreeNode(7);
        root.left.right.right=new TreeNode(4);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(8);
        TreeNode target=root.left;
        int k=2;
        distanceK(root,target,k);

    }

    private static Map<TreeNode,TreeNode> parentMap=new HashMap<>();
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
    public static void BFS(TreeNode root, TreeNode target, int k,List<Integer> result){

        Queue<TreeNode> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        q.add(target);
        visited.add(target.val);
        while(!q.isEmpty()){
            int n=q.size();
            if(k==0){
                break;
            }
            while(n-- >0){
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
                    TreeNode value=parentMap.get(curr);
                    q.add(parentMap.get(curr));
                    visited.add(value.val);
                }
            }
            k--;
        }
        while(!q.isEmpty()){
            result.add(q.poll().val);
        }
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        inorder(root);

        List<Integer> result =new ArrayList<>();
        BFS(root,target,k,result);
        return result;

    }
}
