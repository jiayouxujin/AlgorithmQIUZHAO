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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> tmp=new ArrayList<>();
        helper(tmp,root);
        return tmp.get(k-1);
    }

    public void helper(List<Integer> tmp,TreeNode root){
        if(root==null){
            return ;
        }
        helper(tmp,root.left);
        tmp.add(root.val);
        helper(tmp,root.right);
    }
}
// @lc code=end

