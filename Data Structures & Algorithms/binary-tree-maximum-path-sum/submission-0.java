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
int res = Integer.MIN_VALUE;
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum(root);
        return res;
    }
    private int maxSum(TreeNode node){
        if(node == null) return 0;
        int lSum = Math.max(0, maxSum(node.left));
        int rSum = Math.max(0, maxSum(node.right));
        res = Math.max(node.val + lSum + rSum, res);
        return node.val + Math.max(lSum, rSum);
    }
}
