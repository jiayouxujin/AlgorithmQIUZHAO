/*
 * @lc app=leetcode id=581 lang=java
 *
 * [581] Shortest Unsorted Continuous Subarray
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int[] temp=nums.clone();
        Arrays.sort(nums);
        int start=0;
        while(start<n&&temp[start]==nums[start]) start++;
        int end=n-1;
        while(end>start&&temp[end]==nums[end]) end--;
        
        return end-start+1;
    }
}
// @lc code=end
