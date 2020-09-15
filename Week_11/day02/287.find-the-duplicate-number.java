/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int left=0,right=n;
        while(left<right){
            int mid=left+(right-left)/2;
            int count=numberCount(nums,mid);
            if(count>mid) right=mid;
            else left=mid+1;
        }
        return left;
    }

    public int numberCount(int[] nums,int target){
        int res=0;
        for(int n:nums){
            if(n<=target){
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

