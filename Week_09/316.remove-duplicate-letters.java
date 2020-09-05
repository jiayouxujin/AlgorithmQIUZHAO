/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count=new int[256];
        for(char c:s.toCharArray()){
            count[c]++;
        }

        Stack<Character> stack=new Stack<>();
        boolean[] inStack=new boolean[256];

        for(char c:s.toCharArray()){
            count[c]--;
            if(inStack[c]) continue;

            while(!stack.isEmpty()&&stack.peek()>c){
                if(count[stack.peek()]==0){
                    break;
                }
                inStack[stack.pop()]=false;
            }

            stack.push(c);
            inStack[c]=true;
        }

        StringBuilder res=new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
// @lc code=end

