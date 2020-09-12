/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s==null||s.length()==0){
            return true;
        }
        
        int cur=0;
        for(int i=0;i<t.length()&&cur<s.length();i++){
            if(s.charAt(cur)==t.charAt(i)){
                cur++;
            }
        }
        return cur==s.length();
    }
}
// @lc code=end

