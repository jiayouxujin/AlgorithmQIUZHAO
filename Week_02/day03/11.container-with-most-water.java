/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max=0;
        for(int left=0,right=height.length-1;left<right;){
            int minHeight=height[left]<height[right]?height[left++]:height[right--;
            int area=minHeight*(right-left+1);
            max=Math.max(max, area);
        }
        return max;
    }
}
// @lc code=end

