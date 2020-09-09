/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums==null||nums.length==0){
            return 0;
        }
        return helper(nums,S,0);
    }

    public int helper(int[] nums,int s,int index){
        if(index==nums.length){
            return s==0?1:0;
        }

        return helper(nums,s-nums[index],index+1)+helper(nums,s+nums[index],index+1);
    }
}
// @lc code=end

