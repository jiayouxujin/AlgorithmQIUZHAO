/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
    public int fib(int N) {
        if(N==0){
            return 0;
        }
        if(N<=2){
            return 1;
        }

        int a=1,b=1,c=1;
        for(int i=3;i<=N;i++){
            a=b+c;
            c=b;
            b=a;
        }
        return a;
    }
}
// @lc code=end

