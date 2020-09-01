/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        helper(root,sum,new LinkedList<>(),res);
        return res;
    }

    public void helper(TreeNode root,int sum,List<Integer> temp,List<List<Integer>> res){
        if(root==null)
            return ;
        temp.add(root.val);
        if(sum==root.val&&root.left==null&&root.right==null){
            res.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return ;
        }
        
        helper(root.left,sum-root.val,temp,res);
        helper(root.right,sum-root.val,temp,res);
        temp.remove(temp.size()-1);
    }
}
// @lc code=end

