/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int zero=0,second=nums.length-1;
        for(int i=0;i<=second;i++){
            while(nums[i]==2&&i<second) swap(nums,i,second--);
            while(nums[i]==0&&i>zero) swap(nums,i,zero++);
        }
    }

    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
// @lc code=end

