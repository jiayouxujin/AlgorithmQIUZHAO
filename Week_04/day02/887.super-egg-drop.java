/*
 * @lc app=leetcode id=887 lang=java
 *
 * [887] Super Egg Drop
 */

// @lc code=start
class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp=new int[K+1][N+1];
        return helper(dp,K,N);
    }

    public int helper(int[][] dp,int k,int n){
        if(n<=1){
            return n;
        }

        if(k==1){
            return n;
        }

        if(dp[k][n]>0){
            return dp[k][n];
        }

        int low=1,hight=n,result=n;
        while(low<hight){
            int mid=(low+hight)/2;
            int left=helper(dp,k-1,mid-1);
            int right=helper(dp,k,n-mid);
            result=Math.min(result,Math.max(left,right)+1);
            if(left==right){
                break;
            }else if(left<right){
                low=mid+1;
            }else{
                hight=mid;
            }
        }
        dp[k][n]=result;
        return dp[k][n];
    }
}
// @lc code=end

