/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1) return 0;
        int[] dp=new int[s.length()];
        int ans=0;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=i>=2?dp[i-2]+2:2;
                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+(i-dp[i-1]>=2?dp[i-dp[i-1]-2]+2:2);
                }
            }

            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
// @lc code=end

