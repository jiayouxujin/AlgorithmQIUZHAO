/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generate("",res,0,0,n);
        return res;
    }
    public void generate(String s,List<String> res,int left,int right,int n){
        if(left==n&&right==n){
            res.add(s);
            return ;
        }

        if(left<n){
            generate(s+"(",res,left+1,right,n);
        }
        if(right<left){
            generate(s+")",res,left,right+1,n);
        }
    }
}
// @lc code=end

