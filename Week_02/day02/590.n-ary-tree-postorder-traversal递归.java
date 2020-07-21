import java.util.List;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res=new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(Node root,List<Integer> res){
        if(root==null){
            return ;
        }

        for(Node node:root.children){
            helper(node, res);
        }

        res.add(root.val);
    }
}
// @lc code=end

