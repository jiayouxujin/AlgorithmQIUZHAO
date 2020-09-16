/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1){
            return 0;
        }
        // 0 buy 1 sell 
        int[][] dp=new int[prices.length][2];
        //init
        dp[0][0]=-prices[0];
        dp[1][0]=-Math.min(prices[0],prices[1]);
        dp[0][1]=0;
        dp[1][1]=Math.max(0,dp[0][0]+prices[1]);

        for(int i=2;i<prices.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-2][1]-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
}
// @lc code=end

