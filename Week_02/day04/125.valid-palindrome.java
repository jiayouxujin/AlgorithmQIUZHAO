/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }

        int left=0,right=s.length()-1;
        char cleft,cright;

        while(left<=right){
            cleft=s.charAt(left);
            cright=s.charAt(right);

            if(!Character.isLetterOrDigit(cleft)){
                left++;
            }else if(!Character.isLetterOrDigit(cright)){
                right--;
            }else{
                if(Character.toLowerCase(cleft)!=Character.toLowerCase(cright)){
                    return false;
                }

                left++;
                right--;
            }
        }
        return true;
    }
}
// @lc code=end

