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
        
        int cur=0;
        int ans=0;
        for(int i=0;i<s.length;i++){
            if(cur>=g.length){
                break;
            }
            if(s[i]>=g[cur]){
                cur++;
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

