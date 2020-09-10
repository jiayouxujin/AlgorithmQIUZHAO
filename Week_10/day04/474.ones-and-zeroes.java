/*
 * @lc app=leetcode id=474 lang=java
 *
 * [474] Ones and Zeroes
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs==null||strs.length==0) return 0;
        int[][] dp=new int[m+1][n+1];

        dp[0][0]=0;

        for(String str:strs){
            int[] count=CountNum(str);
            for(int i=m;i>=count[0];i--){
                for(int j=n;j>=count[1];j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-count[0]][j-count[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] CountNum(String str){
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

