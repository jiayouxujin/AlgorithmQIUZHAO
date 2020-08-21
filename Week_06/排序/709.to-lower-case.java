/*
 * @lc app=leetcode id=709 lang=java
 *
 * [709] To Lower Case
 */

// @lc code=start
class Solution {
    public String toLowerCase(String str) {
        char[] charStr=str.toCharArray();

        for(int i=0;i<charStr.length;i++){
            if(charStr[i]>=65&&charStr[i]<=90){
                charStr[i]=(char)(charStr[i]+32);
            }
        }
        return String.valueOf(charStr);
    }
}
// @lc code=end

