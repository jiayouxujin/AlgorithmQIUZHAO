/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] t=new int[26];
        for(char c:tasks){
            t[c-'A']++;
        }
        Arrays.sort(t);
        int time=0;
        while(t[25]>0){
            int i=0;
            while(i<=n){
                if(t[25]==0){
                    break;
                }
                if(i<26&&t[25-i]>0){
                    t[25-i]--;
                }
                i++;
                time++;
            }
            Arrays.sort(t);
        }
        return time;
    }
}
// @lc code=end

