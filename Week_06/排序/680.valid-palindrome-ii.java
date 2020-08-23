/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int l=-1,r=s.length();
        while(++l<--r){
            if(s.charAt(l)!=s.charAt(r)) return isPalindromic(s,l,r+1)||isPalindromic(s,l-1,r);
        }
        return true;
    }

    public boolean isPalindromic(String s,int l,int r){
        while(++l<--r)
            if(s.charAt(l)!=s.charAt(r)) return false;
        return true;
    }
}
// @lc code=end

