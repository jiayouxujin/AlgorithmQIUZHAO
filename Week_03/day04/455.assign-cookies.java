/*
 * @lc app=leetcode id=455 lang=java
 *
 * [455] Assign Cookies
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count=0;
        for(int glen=0,slen=0;glen<g.length&&slen<s.length;){
            if(g[glen]<=s[slen]){
                count++;
                glen++;
                slen++;
            }else{
                slen++;
            }
        }
        return count;
    }
}
// @lc code=end

