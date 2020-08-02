/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int left=0,right=A.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(A[mid]<A[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return right;
    }
}
// @lc code=end

