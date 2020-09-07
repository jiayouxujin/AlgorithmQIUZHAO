/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        boolean[] notprime=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(notprime[i]==false){
                count++;
                if(int j=2;i*j<n;j++){
                    notprime[i*j]=true;
                }
            }
        }
        return count;
    }
}
// @lc code=end

