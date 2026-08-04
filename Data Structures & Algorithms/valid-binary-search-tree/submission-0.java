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
    public boolean isValidBST(TreeNode root) {
        return check(root, null, null);
    }
    
    private boolean check(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        
        // If min exists, node.val must be strictly greater than min
        if (min != null && root.val <= min) return false;
        
        // If max exists, node.val must be strictly less than max
        if (max != null && root.val >= max) return false;
        
        return check(root.left, min, root.val) && check(root.right, root.val, max); 
    }
}