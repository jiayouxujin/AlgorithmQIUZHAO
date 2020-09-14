/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        helper(root);
        return res;
    }
    public void helper(TreeNode root){
        if(root.left!=null) helper(root.left);
        count--;
        if(count==0){
            res=root.val;
            return ;
        }
        if(root.right!=null) helper(root.right);
    }
}
// @lc code=end

