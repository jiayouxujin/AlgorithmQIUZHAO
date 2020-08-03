/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0) return 0;
        int[][] dp=new int[nums.length][2];
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        int res=dp[0][0];

        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0]*nums[i],Math.max(dp[i-1][1]*nums[i],nums[i]));
            dp[i][1]=Math.min(dp[i-1][0]*nums[i],Math.min(dp[i-1][1]*nums[i],nums[i]));
            if(res<dp[i][0]) res=dp[i][0];
        }
        return res;
    }
}
// @lc code=end

