import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.sun.corba.se.impl.orbutil.graph.Node;

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
        Stack<Node> stack=new Stack<>();

        if(root==null){
            return res;
        }
        stack.push(root);

        while(!stack.isEmpty()){
            Node cur=stack.pop();
            res.add(cur.val);
            for(Node node:cur.children){
                stack.push(node);
            }
        }

        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

