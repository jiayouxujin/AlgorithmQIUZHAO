/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    public List<TreeNode> generateTrees(int n) {
        if(n<1) return new LinkedList<>();
        return gen(1,n);
    }

    public List<TreeNode> gen(int s,int e){
        List<TreeNode> res=new LinkedList<>();
        if(s>e){
            res.add(null);
            return res;
        }
        for(int i=s;i<=e;i++){
            List<TreeNode> leftTree=gen(s,i-1);
            List<TreeNode> rightTree=gen(i+1,e);
            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
// @lc code=end

