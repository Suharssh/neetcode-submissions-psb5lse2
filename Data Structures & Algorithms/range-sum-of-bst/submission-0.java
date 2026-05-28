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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return dfs(root, low, high);
    }
    public int dfs(TreeNode root, int l, int h){
        if(root == null) return 0;
        int currentval = (root.val >= l && root.val <= h) ? root.val : 0;
        int leftsum = dfs(root.left, l, h);
        int rightsum = dfs(root.right, l, h);        
        return currentval + leftsum + rightsum;
    }
}