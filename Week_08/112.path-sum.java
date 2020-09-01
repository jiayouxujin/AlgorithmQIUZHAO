/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return helper(root,sum);
    }

    public boolean helper(TreeNode root,int sum){
        if(root==null) return false;
        sum-=root.val;
        if(sum==0&&root.left==null&&root.right==null) return true;
        return helper(root.left,sum)||helper(root.right,sum);
    }
}
// @lc code=end

