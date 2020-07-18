import java.util.Stack;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min_stack;


    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        min_stack=new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty()||min_stack.peek()>=x){
            min_stack.push(x);
        }
    }
    
    public void pop() {
        if(stack.pop().equals(min_stack.peek())){
            min_stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

