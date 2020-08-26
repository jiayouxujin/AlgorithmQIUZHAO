/*
 * @lc app=leetcode id=746 lang=java
 *
 * [746] Min Cost Climbing Stairs
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        dp[0]=cost[0];
        dp[1]=cost[1];

        for(int i=2;i<=cost.length;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2]);
            if(i<cost.length){
                dp[i]+=cost[i];
            }
        }
        return dp[cost.length];
    }
}
// @lc code=end

