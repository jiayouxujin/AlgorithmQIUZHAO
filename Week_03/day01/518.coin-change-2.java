/*
 * @lc app=leetcode id=518 lang=java
 *
 * [518] Coin Change 2
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        //状态 前i个硬币凑成总数的方案数
        //选择 要么选，要么不选，但是总的方案数应该是前面提到的这两个总和
        //dp[i][j] i个硬币组成总额为j
        //base case:dp[i..n][0]=1 这种方案就是都不选择

        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }
}
// @lc code=end

