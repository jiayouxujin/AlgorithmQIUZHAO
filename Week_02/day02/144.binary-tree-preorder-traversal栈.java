import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();

        if(root==null)
            return res;
        
        stack.push(root);
        while(!stack.isEmpty){
            TreeNode cur=stack.pop();
            res.add(cur.val);
            if(cur.right!=null){
                rstackes.add(cur.right);
            }
            if(cur.left!=null){
                stack.add(cur.left);
            }
        }

        return res;
    }
}
// @lc code=end

