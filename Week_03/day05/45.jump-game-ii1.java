/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int position=nums.length-1;
        int step=0;
        while(position>0){
            for(int i=0;i<position;i++){
                if(nums[i]+i>=position){
                    position=i;
                    step++;
                }
            }
        }
        return step;
    }
}
// @lc code=end

