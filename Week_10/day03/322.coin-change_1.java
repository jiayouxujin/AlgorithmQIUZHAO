/*
 * @lc app=leetcode id=322 lang=java
 *
 * [322] Coin Change
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<0) return 0;
        return helper(coins,amount,new int[amount]);
    }

    public int helper(int[] coins,int rem,int[] dp){
        if(rem<0) return -1;
        if(rem==0) return 0;
        if(dp[rem-1]!=0) return dp[rem-1];
        int min=Integer.MAX_VALUE;
        for(int coin:coins){
            int sub=helper(coins,rem-coin,dp);
            if(sub>=0&&sub+1<min){
                min=sub+1;
            }
        }
        dp[rem-1]=min==Integer.MAX_VALUE?-1:min;
        return dp[rem-1];
    }
}
// @lc code=end

