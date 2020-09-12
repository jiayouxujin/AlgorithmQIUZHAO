/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null||intervals.length<=1) return 0;
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0],o2[0]));
        int ans=0;
        int[] curInterval=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=curInterval[1]){
                curInterval=intervals[i];
            }else{
                ans++;
                if(intervals[i][1]<curInterval[1]){
                    curInterval=intervals[i];
                }
            }
        }
        return ans;
    }
}
// @lc code=end

