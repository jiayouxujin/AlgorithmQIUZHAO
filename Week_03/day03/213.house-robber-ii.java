/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(solve(nums,0,nums.length-2),solve(nums,1,nums.length-1));
    }

    public int solve(int[] nums,int start,int end){
        int dp_i=0,dp_i1=0,dp_i2=0;
        for(int i=end;i>=start;i--){
            dp_i=Math.max(dp_i1,dp_i2+nums[i]);
            dp_i2=dp_i1;
            dp_i1=dp_i;
        }
        return dp_i;
    }
}
// @lc code=end

