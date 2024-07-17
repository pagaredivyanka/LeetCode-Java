/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for ( int i: to_delete) {
            set.add(i);
        }
        List<TreeNode> ans = new ArrayList<>();
        if(!set.contains(root.val)) ans.add(root);
        traverse(root, set, ans, null, false);
        return ans;

    }

    private void traverse(TreeNode root, Set<Integer> set, List<TreeNode> ans, TreeNode parent, boolean isLeft) {
        if (root == null) return;
        if (set.contains(root.val)) {
            if(parent != null) {
                if(isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (root.left != null && !set.contains(root.left.val)) {
                ans.add(root.left);
            }
            if (root.right != null && !set.contains(root.right.val)) {
                ans.add(root.right);
            }
        }
        traverse(root.left, set, ans, root, true);
        traverse(root.right, set, ans, root, false);
    }
}
