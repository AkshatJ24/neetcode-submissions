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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        height(root);
        return dia;
    }
    private int height(TreeNode node){
        if(node == null){
            return 0;
        }
        int lH = height(node.left);
        int rH = height(node.right);
        dia = Math.max(dia, lH + rH);
        return Math.max(lH, rH) + 1;
    }

}
