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
            while(j>lo&&nums[--j]>nums[lo]);
            if(i>=j){
                break;
            }
            swap(nums,i,j);
        }
        swap(nums,lo,j);
        return j;
    }

    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
// @lc code=end

