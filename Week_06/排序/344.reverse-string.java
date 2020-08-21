/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
    public void reverseString(char[] s) {
        if(s==null||s.length<=1) return ;

        int left=0,right=s.length-1;

        while(left<right){
            char cleft=s[left];
            s[left]=s[right];
            s[right]=cleft;
            left++;
            right--;
        }
        return ;
    }
}
// @lc code=end

