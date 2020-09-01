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
        helper(res,"",0,0,n);
        return res;
    }

    public void helper(List<String> res,String s,int left,int right,int  n){
        if(left==n&&right==n){
            res.add(s);
            return ;
        }
        if(left<n){
            helper(res,s+"(",left+1,right,n);
        }
        if(right<left){
            helper(res,s+")",left,right+1,n);
        }
    }
}
// @lc code=end

