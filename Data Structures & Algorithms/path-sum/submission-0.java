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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int t = targetSum;
        return dfs(root,t);
    }
    public boolean dfs(TreeNode root, int t){
        if(root == null) return false;
        t-=root.val;
        if(root.left == null && root.right == null) return t == 0;
        else return dfs(root.left, t) || dfs(root.right, t);
    }
}