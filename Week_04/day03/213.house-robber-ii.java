/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        return Math.max(solve(nums,0,nums.length-2),solve(nums,1,nums.length-1));
    }
    public int solve(int[] nums,int start,int end){
        int[] dp=new int[end-start+5];
        for(int i=end;i>=start;i--){
            dp[i]=Math.max(dp[i+1],nums[i]+dp[i+2]);
        }
        return dp[start];
    }

}
// @lc code=end

