/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()==0)
            return true;
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')'){
                if(stack.isEmpty()||stack.pop()!='('){
                    return false;
                }
            }else if(c=='}'){
                if(stack.isEmpty()||stack.pop()!='{'){
                    return false;
                }
            }else if(c==']'){
                if(stack.isEmpty()||stack.pop()!='['){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

