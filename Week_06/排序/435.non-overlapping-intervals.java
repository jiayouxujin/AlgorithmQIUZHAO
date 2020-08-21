/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length<=1) return 0;

        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

        int count=0;
        int[] newInterval=intervals[0];

        for(int j=1;j<intervals.length;j++){
            if(intervals[j][0]<newInterval[1]){
                count++;
                if(intervals[j][1]<newInterval[1]){
                    newInterval=intervals[j];
                } 
            }else if(intervals[j][1]>newInterval[1]){
                newInterval=intervals[j];
            } 
            
        }
        return count;
    }
}
// @lc code=end

