/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }

        int position=0;
        for(int i=0;i<nums.length;i++){
            if(i<=position){
                position=Math.max(position,nums[i]+i);
                if(position>=nums.length-1){
                    return true;
                }
            }
        }
        return false;
    }
}
// @lc code=end

