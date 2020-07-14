/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums,int start,int end){
        if(start>end) return ;

        int temp;
        for(int i=start,j=end;i<=j;i++,j--){
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
// @lc code=end

