/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        //init
        dp[0][0]=0;
        int ans=0;

        for(String str:strs){
            int[] countNum=count(str);
            for(int i=m;i>=countNum[0];i--){
                for(int j=n;j>=countNum[1];j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-countNum[0]][j-countNum[1]]+1);
                    ans=Math.max(dp[i][j],ans);
                }
            }
        }
        return ans;
    }

    public int[] count(String str){
        int[] res=new int[2];
        for(char c:str.toCharArray()){
            if(c=='0'){
                res[0]++;
            }else{
                res[1]++;
            }
        }
        return res;
    }
}
// @lc code=end

