/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
       return isValidateBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidateBST(TreeNode root,long min,long max){
        if(root==null) return true;
        if(root.val<=min||root.val>=max){
            return false;
        }

        return isValidateBST(root.left,min,root.val)&&isValidateBST(root.right,root.val,max);
    }
}
// @lc code=end

