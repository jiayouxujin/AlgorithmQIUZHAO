/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //明确状态 对比的字符串
        //明确选择 字符相等，字符不相等
        //解释dp[i][j] 表示text1的前i个字符和text2的前j个字符公共子序列
        int len1=text1.length(),len2=text2.length();
        int[][] dp=new int[len1+1][len2+1];

        //base case
        for(int i=0;i<=len1;i++){
            dp[i][0]=0;
        }

        for(int j=0;j<=len2;j++){
            dp[0][j]=0;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

