/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        if(n==0){
            return res;
        }
        helper(res,new StringBuilder(),n,n);
        return res;
    }

    public void helper(List<String> res,StringBuilder temp,int left,int right){
        if(left==0&&right==0){
            res.add(temp.toString());
            return ;
        }
        if(left>0){
            temp.append('(');
            helper(res,temp,left-1,right);
            temp.setLength(temp.length()-1);
        }
        if(right>left){
            temp.append(')');
            helper(res,temp,left,right-1);
            temp.setLength(temp.length()-1);
        }
    }
}
// @lc code=end

