/*
 * @lc app=leetcode id=917 lang=java
 *
 * [917] Reverse Only Letters
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        StringBuilder sb=new StringBuilder(S);
        int left=0,right=S.length()-1;
        while(left<right){
            if(!Character.isLetter(sb.charAt(left))){
                left++;
            }else if(!Character.isLetter(sb.charAt(right))){
                right--;
            }else{
                sb.setCharAt(left,s.charAt(right));
                sb.setCharAt(right--,s.charAt(left++));
            }
        }
        return sb.toString();
    }
}
// @lc code=end

