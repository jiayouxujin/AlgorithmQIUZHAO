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

    public int helper(int[][] dp,int K,int N){
        if(N<=1){
            return N;
        }
        if(K==1){
            return N;
        }
        if(dp[K][N]>0){
            return dp[K][N];
        }

        int left=1,right=N,result=N;
        while(left<right){
            int mid=(left+right)/2;
            int low=helper(dp,K-1,mid-1);
            int hight=helper(dp,K,N-mid);

            result=Math.min(result,Math.max(low,hight)+1);
            if(low==hight){
                break;
            }else if(low<hight){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        dp[K][N]=result;
        return result;
    }
}
// @lc code=end

