/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int length=0;
        int temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp=nums[length];
                nums[length]=nums[i];
                nums[i]=temp;
                length++;
            }
        }
    }
}
// @lc code=end

