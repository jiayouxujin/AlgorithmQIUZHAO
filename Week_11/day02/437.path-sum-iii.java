/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    public int helper(TreeNode root,int sum){
        if(root==null) return 0;
        return (root.val==sum?1:0)+helper(root.left,sum-root.val)+helper(root.right,sum-root.val);
    }
}
// @lc code=end

