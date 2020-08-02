/*
 * @lc app=leetcode id=367 lang=java
 *
 * [367] Valid Perfect Square
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        if(num<2){
            return true;
        }

        int left=1,right=num/2,ans=0;
        while(left<=right){
            int mid=left+(right-left)/2;
            if((long)mid*mid<=num){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans*ans==num;
    }
}
// @lc code=end

