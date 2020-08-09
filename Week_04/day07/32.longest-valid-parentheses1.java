/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<2){
            return 0;
        }

        Stack<Integer> stack=new Stack<>();
        stack.push(-1);
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    if(res<i-stack.peek()){
                        res=i-stack.peek();
                    }
                }
            }
        }
        return res;
    }
}
// @lc code=end

