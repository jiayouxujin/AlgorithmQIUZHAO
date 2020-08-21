/*
 * @lc app=leetcode id=493 lang=java
 *
 * [493] Reverse Pairs
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int[] nums,int begin,int end){
        if(begin>=end) return 0;
        int mid=begin+(end-begin)/2;
        int cnt=mergeSort(nums,begin,mid)+mergeSort(nums,mid+1,end);

        for(int i=begin,j=mid+1;i<=mid;i++){
            while(j<=end&&nums[i]/2.0>nums[j]) j++;
            cnt+=j-(mid+1);
        }
        Arrays.sort(nums,begin,end+1);
        return cnt;
    }
}
// @lc code=end

