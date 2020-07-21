import java.util.List;

/*
 * @lc app=leetcode id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
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
    public List<Integer> preorder(Node root) {
        List<Integer> res=new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(Node root,List<Integer> res){
        if(root==null){
            return ;
        }
        res.add(res.val);
        for(Node node:root.children){
            helper(node, res);
        }
    }
}
// @lc code=end

