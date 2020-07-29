/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();

        if(root==null){
            return res;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> temp=new ArrayList<>();
            while(size>0){
                TreeNode cur=queue.poll();
                temp.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
                size--;
            }
            res.add(temp);
        }
        return res;
    }
}
// @lc code=end

