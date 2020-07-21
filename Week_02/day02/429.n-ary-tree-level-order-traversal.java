import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode id=429 lang=java
 *
 * [429] N-ary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        if(root==null){
            return res;
        }

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node cur=queue.poll();
                level.add(cur.val);
                queue.addAll(cur.children);
            }
            res.add(level);
        }
        return res;
    }
}
// @lc code=end

