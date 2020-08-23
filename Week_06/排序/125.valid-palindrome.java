/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        String lowStr=s.toLowerCase();

        int left=0,right=lowStr.length()-1;
        while(left<=right){
            char cleft=lowStr.charAt(left);
            char cright=lowStr.charAt(right);

            if(!Character.isLetterOrDigit(cleft)){
                left++;
            }else if(!Character.isLetterOrDigit(cright)){
                right--;
            }else if(cleft!=cright){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
// @lc code=end

