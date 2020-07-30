/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        int left=0,right=S.length()-1;
        StringBuilder sb=new StringBuilder(S);
        while(left<right){
            if(!Character.isLetter(S.charAt(left))){
                left++;
            }else if(!Character.isLetter(S.charAt(right))){
                right--;
            }else{
                sb.setCharAt(left,S.charAt(right));
                sb.setCharAt(right--,S.charAt(left++));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

