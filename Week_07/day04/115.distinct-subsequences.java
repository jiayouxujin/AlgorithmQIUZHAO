/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int len1=s.length(),len2=t.length();
        int[][] dp=new int[len2+1][len1+1];
        for(int i=0;i<=len1;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                if(t.charAt(i-1)==s.charAt(j-1)){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[len2][len1];
    }
}
// @lc code=end

