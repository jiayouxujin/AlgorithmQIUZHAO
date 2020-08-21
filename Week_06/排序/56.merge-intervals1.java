/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }

        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[0],i2[0]));

        List<int[]> result=new ArrayList<>();
        int[] newintervals=intervals[0];
        result.add(newintervals);

        for(int[] interval:intervals){
            if(interval[0]<=newintervals[1]){
                newintervals[1]=Math.max(interval[1],newintervals[1]);
            }else{
                newintervals=interval;
                result.add(newintervals);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

