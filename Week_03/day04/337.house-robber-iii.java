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
    HashMap<TreeNode,Integer> map=new HashMap<>();

    public int rob(TreeNode root) {
        if(root==null){
            return 0;
        }

        if(map.containsKey(root)){
            return map.get(root);
        }

        int do_it=root.val+(root.left==null?0:rob(root.left.left)+rob(root.left.right))+(root.right==null?0:rob(root.right.right)+rob(root.right.left));
        int no_do=rob(root.left)+rob(root.right);
        int res=Math.max(do_it,no_do);
        map.put(root,res);
        return res;
    }
}
// @lc code=end

