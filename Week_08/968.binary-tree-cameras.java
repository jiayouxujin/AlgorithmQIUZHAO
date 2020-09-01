/*
 * @lc app=leetcode id=968 lang=java
 *
 * [968] Binary Tree Cameras
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
    int ans=0;
    public int minCameraCover(TreeNode root) {
        if(root==null) return 0;
        helper(root,ans);
        return ans;
    }

    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        //put in root
        int inRoot=1+helper(root.left.left)+helper(root.left.right)+helper(root.right)
    }
}
// @lc code=end

