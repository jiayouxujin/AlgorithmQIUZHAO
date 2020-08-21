/*
 * @lc app=leetcode id=541 lang=java
 *
 * [541] Reverse String II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] c=s.toCharArray();
        for(int start=0;start<c.length;start+=2*k){
            int i=start,j=Math.min(start+k-1,c.length-1);
            while(i<j){
                char tmp=c[i];
                c[i++]=c[j];
                c[j--]=tmp;
            }
        }
        return new String(c);
    }
}
// @lc code=end

