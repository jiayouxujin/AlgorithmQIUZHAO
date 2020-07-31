/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);

        for(int i=0,j=0;i<g.length&&j<s.length;){
            if(s[j]>=g[i]){
                j++;
                i++;
                count++;
            }else{
                j++;
            }
        }

        return count;
    }
}
// @lc code=end

