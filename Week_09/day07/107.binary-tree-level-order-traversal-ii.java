/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        
        LinkedList<TreeNode> queue=new LinkedList<>();
        if(root==null) return res;
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> tmp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.pollFirst();
                tmp.add(cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            res.add(tmp);
        }

        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

