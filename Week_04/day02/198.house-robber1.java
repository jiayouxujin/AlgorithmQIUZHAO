/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        if(nums==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i>=2){
                dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
            }else{
                dp[i]=Math.max(dp[i-1],nums[i]);
            }
        }
        return dp[nums.length-1];
    }
}
// @lc code=end

