/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+2];
        for(int i=nums.length-1;i>=0;i--){
            dp[i]=Math.max(dp[i+1],dp[i+2]+nums[i]);
        }

        return dp[0];
    }
}
// @lc code=end

