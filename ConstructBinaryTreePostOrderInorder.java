public class ConstructBinaryTreePostOrderInorder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        buildTree(inorder, postorder);

    }

    public static TreeNode solve(int[] inorder, int[] postorder, int start, int end, int[] idx) {
        if (start > end) {
            return null;

        }
        TreeNode root = new TreeNode(postorder[idx[0]]);
        int i = start;
        for (; i <= end; i++) {
            if (inorder[i] == root.val) {
                break;
            }
        }

        idx[0]--;
        root.right = solve(inorder, postorder, i + 1, end, idx);
        root.left = solve(inorder, postorder, start, i - 1, idx);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length - 1;
        int[] idx = {n};

        return solve(inorder, postorder, 0, n, idx);
    }
}
