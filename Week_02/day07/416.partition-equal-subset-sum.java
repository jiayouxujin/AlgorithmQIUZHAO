/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;

        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>=0;j--){
                if(j>=nums[i]){
                    dp[j]=dp[j]|dp[j-nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
// @lc code=end

