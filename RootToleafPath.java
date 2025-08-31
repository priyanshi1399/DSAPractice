import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class RootToleafPath {
    public void solve(TreeNode root, List<String> res, StringBuilder curr) {
        if (root == null) return;

        int len = curr.length();  // Store length for backtracking

        // Append current node value
        curr.append(root.val);

        // If leaf node → add path to result
        if (root.left == null && root.right == null) {
            res.add(curr.toString());
        } else {
            // Add arrow and recurse for children
            curr.append("->");
            solve(root.left, res, curr);
            solve(root.right, res, curr);
        }

        // Backtrack to previous state
        curr.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        solve(root, res, new StringBuilder());
        return res;
    }


    public static void main(String[] args) {
        // Create test binary tree
        //       1
        //      / \
        //     2   3
        //      \
        //       5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        // Call solution
        RootToleafPath solution = new RootToleafPath();
        List<String> result = solution.binaryTreePaths(root);

        // Print result
        System.out.println("All root-to-leaf paths:");
        for (String path : result) {
            System.out.println(path);
        }
    }
}
