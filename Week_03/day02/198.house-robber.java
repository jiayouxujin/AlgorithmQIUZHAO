/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+2];

        for(int i=n-1;i>=0;i--){
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }

        return dp[0];
    }
}
// @lc code=end

