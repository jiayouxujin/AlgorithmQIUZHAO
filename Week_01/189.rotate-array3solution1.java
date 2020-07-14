/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;

        for(int i=0;i<k;i++){
            int previous;
            int temp=nums[nums.length-1];
            for(int j=0;j<nums.length;j++){
                previous=temp;
                temp=nums[j];
                nums[j]=previous;
            }
        }
    }
}
// @lc code=end

