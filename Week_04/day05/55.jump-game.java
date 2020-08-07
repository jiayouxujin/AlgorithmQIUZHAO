/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1){
            return true;
        }

        int curIndex=nums[0];
        for(int i=1;i<nums.length;i++){
            if(curIndex>=nums.length-1){
                return true;
            }
            if(i<=curIndex){
                curIndex=Math.max(curIndex,nums[i]+i);
            }
        }
        return false;
    }
}
// @lc code=end

