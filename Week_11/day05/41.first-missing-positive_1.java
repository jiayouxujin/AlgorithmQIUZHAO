/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        int i=0;
        while(i<len){
            if(nums[i]==i+1||nums[i]<=0||nums[i]>len){
                i++;
            }else if(nums[nums[i]-1]!=nums[i]){
                swap(nums,nums[i]-1,i);
            }else{
                i++;
            }
        }

        i=0;
        while(i<len&&nums[i]==i+1) i++;
        return i+1;
    }

    public void swap(int[] nums,int a,int b){
        int tmp=nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }
}
// @lc code=end

