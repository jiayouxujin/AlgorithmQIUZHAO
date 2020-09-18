/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[]{-1,-1};
        if(nums==null||nums.length==0){
            return res;
        }
        int lo=0,hi=nums.length-1;
        while(nums[lo]<nums[hi]){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
            }else if(nums[mid]>target){
                hi=mid-1;
            }else{
                if(nums[lo]==nums[mid]){
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        if(nums[lo]==nums[hi]&&nums[hi]==target){
            res[0]=lo;
            res[1]=hi;
        }
        return res;
    }
}
// @lc code=end

