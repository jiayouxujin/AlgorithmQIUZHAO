/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[][] dp=new int[nums.length][2];
        if(nums==null||nums.length==0){
            return 0;
        }
        dp[0][0]=nums[0];
        dp[0][1]=nums[0];
        int ans=nums[0];

        for(int i=1;i<nums.length;i++){
            dp[i][0]=Math.max(dp[i-1][0]*nums[i],Math.max(dp[i-1][1]*nums[i],nums[i]));
            ans=Math.max(dp[i][0],ans);
            dp[i][1]=Math.min(dp[i-1][0]*nums[i],Math.min(dp[i-1][1]*nums[i],nums[i]));
        }
        return ans;
    }
}
// @lc code=end

