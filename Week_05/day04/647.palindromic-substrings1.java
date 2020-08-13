/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        if(s==null||s.length()==0) return 0;
        boolean[][] dp=new boolean[s.length()][s.length()];   
        int ans=s.length();

        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }

        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }

                if(dp[i][j]){
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

