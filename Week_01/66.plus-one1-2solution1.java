/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]+=1;

        for(int i=digits.length-1;i>0;i--){
            digits[i-1]+=digits[i]/10;
            digits[i]=digits[i]%10;
        }

        if(digits[0]>=10){
            digits=new int[digits.length+1];
            digits[0]=1;
        }

        return digits;
    }
}
// @lc code=end

