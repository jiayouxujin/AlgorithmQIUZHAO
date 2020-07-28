/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        //明确状态 可比较的字符
        //明确选择 相同跳过，不同的话从三个操作中选择一个
        //解释dp[i][j] word1的前i个字符，word2的前j个字符一样的编辑距离
        //明确base case:dp[i..n][0]=i  dp[0][i..n]=n

        int len1=word1.length(),len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=0;i<=len1;i++){
            dp[i][0]=i;
        }

        for(int i=0;i<=len2;i++){
            dp[0][i]=i;
        }

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                }
            }
        }

        return dp[len1][len2];
    }

    public int min(int i,int j,int k){
        return Math.min(i,Math.min(j,k));
    }
}
// @lc code=end

