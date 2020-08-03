/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];

        int max=dp[0];

        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],0)+nums[i];
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
// @lc code=end

