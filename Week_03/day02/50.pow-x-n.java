/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return fastPow(x,n);
    }

    public double fastPow(double x,int n){
        if(n==0){
            return 1.0;
        }
        double res=fastPow(x,n/2);
        if(n%2==0){
            return res*res;
        }else{
            return res*res*x;
        }
    }
}
// @lc code=end

