/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    private List<String> res=new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generate(0,0,n,""); 
        return res;   
    }

    public void generate(int left,int right,int max,String s){
        if(left==max&&right==max){
            res.add(s);
            return ;
        }

        if(left<max){
            generate(left+1, right, max, s+"(");
        }

        if(left>right){
            generate(left, right+1, max, s+")");
        }
    }
}
// @lc code=end

