import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.add(')');
            }else if(c=='{'){
                stack.add('}');
            }else if(c=='['){
                stack.add(']');
            }else if(stack.isEmpty()||stack.pop()!=c){
                return false;
            }
        }

        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
// @lc code=end

