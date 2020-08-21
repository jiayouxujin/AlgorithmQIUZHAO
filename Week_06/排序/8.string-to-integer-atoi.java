/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        int sign=1,base=0,i=0;
        while(i<str.length()&&str.charAt(i)==' ') i++;
        if(i<str.length()&&(str.charAt(i)=='-'||str.charAt(i)=='+')){
            if(str.charAt(i++)=='-'){
                sign=-1;
            }else{
                sign=1;
            }
        }
        while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            if(base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10&&str.charAt(i)-'0'>7)){
                if(sign==1) return Integer.MAX_VALUE;
                else return Integer.MIN_VALUE;
            }
            base=10*base+(str.charAt(i++)-'0');
        }
        return base*sign;
    }
}
// @lc code=end

