/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points==null||points.length==0) return 0;
        Arrays.sort(points,(o1,o2)->Integer.compare(o1[1],o2[1]));
        int[] curPoint=points[0];
        int ans=1;
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=curPoint[1]){
                if(points[i][1]<curPoint[1]){
                    curPoint=points[i];
                }
            }else{
                curPoint=points[i];
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

