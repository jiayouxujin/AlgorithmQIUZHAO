/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
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
    public int rob(TreeNode root) {
        int[] res=dp(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dp(TreeNode root){
        if(root==null){
            return new int[]{0,0};
        }
        int[] left=dp(root.left);
        int[] right=dp(root.right);

        int rob_it=root.val+left[0]+right[0];
        int no_rob=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{no_rob,rob_it};
    }
}
// @lc code=end

