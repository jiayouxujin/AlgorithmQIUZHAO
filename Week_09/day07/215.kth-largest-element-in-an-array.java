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
            while(i<hi&&less(nums[++i],nums[lo]));
            while(j>lo&&less(nums[lo],nums[--j]));
            if(i>=j){
                break;
            }
            exch(nums,i,j);
        }
        exch(nums,lo,j);
        return j;
    }
    
    public void exch(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public boolean less(int v,int w){
        return v<w;
    }
}
// @lc code=end

