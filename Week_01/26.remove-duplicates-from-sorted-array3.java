/*
 * @lc app=leetcode id=26 lang=java
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int length=nums.length==0?0:1;
        for(int i=1;i<nums.length;i++){
            if (nums[i]>nums[length-1]){
                nums[length++]=nums[i];
            }
        }
        return length;
    }
}
// @lc code=end

