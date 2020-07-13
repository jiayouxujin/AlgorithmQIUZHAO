import java.util.Arrays;

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp=m;
        for(int i=0;i<n;i++){
            nums1[temp++]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}
// @lc code=end

