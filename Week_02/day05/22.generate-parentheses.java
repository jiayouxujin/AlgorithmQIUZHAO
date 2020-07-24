/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        generate(res,0,0,n,"");
        return res;
    }

    public void generate(List<String> res,int left,int right,int n,String s){
        if(left==n&&right==n){
            res.add(s);
        }else{
            if(left<n){
                generate(res,left+1,right,n,s+"(");
            }

            if(right<left){
                generate(res,left,right+1,n,s+")");
            }
        }
    }
}
// @lc code=end

