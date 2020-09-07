/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int j=partition(nums,lo,hi);
            if(j<k){
                lo=j+1;
            }else if(j>k){
                hi=j-1;
            }else{
                break;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums,int lo,int hi){
        int i=lo,j=hi+1;
        while(true){
            while(i<hi&&nums[++i]<nums[lo]);
            while(j>lo&&nums[lo]<nums[--j]);
            if(i>=j){
                break;
            }
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }
        int tmp=nums[j];
        nums[j]=nums[lo];
        nums[lo]=tmp;
        return j;
    }
}
// @lc code=end

