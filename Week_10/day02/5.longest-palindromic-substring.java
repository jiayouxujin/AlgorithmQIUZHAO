/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) return s;
        
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }

        int begin=0,maxlen=1;
        for(int j=1;j<s.length();j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else{
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxlen){
                    begin=i;
                    maxlen=j-i+1;
                }
            }
        }
        return s.substring(begin,begin+maxlen);
    }
}
// @lc code=end

