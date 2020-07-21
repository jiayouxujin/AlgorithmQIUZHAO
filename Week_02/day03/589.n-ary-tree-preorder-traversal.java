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
        Stack<Node> stack=new Stack<>();

        if(root==null){
            return res;
        }

        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            res.add(cur.val);

            for(int i=cur.children.size()-1;i>=0;i--){
                stack.push(cur.children.get(i));
            }
        }

        return res;
    }
}
// @lc code=end

