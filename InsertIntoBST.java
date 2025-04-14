import com.sun.source.tree.Tree;

public class InsertIntoBST {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.val=data;
        }
        public TreeNode(int data,TreeNode left,TreeNode right){
            this.val=data;
            this.left=left;
            this.right=right;
        }

    }

    public static  void main(String [] args){
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        int val=5;
    insertIntoBST(root,val);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        else if(root.val<val){
            root.right=insertIntoBST(root.right,val);
        }
        else if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }
}
