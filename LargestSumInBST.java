public class LargestSumInBST {
    public  static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data=data;

        }
        public TreeNode(int data, TreeNode left, TreeNode right){
            this.data=data;
            this.left=left;
            this.right=right;
        }

    }
    public static class NodeValue {
        int minNode, maxNode, maxSize;
        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    // Helper function to recursively find the largest BST subtree.
    private  static NodeValue largestBSTSubtreeHelper(TreeNode node) {
        // Base case: if the node is null, return a default NodeValue.
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        // Recursively get values from the left and right subtrees.
        NodeValue left = largestBSTSubtreeHelper(node.left);
        NodeValue right = largestBSTSubtreeHelper(node.right);

        // Check if the current node is a valid BST node.
        if (left.maxNode < node.data && node.data < right.minNode) {
            // Current subtree is a valid BST.
            return new NodeValue(
                    Math.min(node.data, left.minNode),
                    Math.max(node.data, right.maxNode),
                    left.maxSize + right.maxSize + 1
            );
        }

        // Current subtree is not a valid BST.
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static int largestBST(TreeNode root) {
        // Initialize the recursive process and return the size of the largest BST subtree.
        return largestBSTSubtreeHelper(root).maxSize;
    }

    public static void main(String[] args) {

        // Additional test case
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        largestBST(root);
    }

}
