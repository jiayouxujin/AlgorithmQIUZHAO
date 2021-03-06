/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int left=1,right=x/2;
        if(x<2){
            return x;
        }

        while(left<=right){
            int mid=left+(right-left)/2;
            if((long)mid*mid<=x){
                left=mid+1;
            }else if(mid*mid>x){
                right=mid-1;
            }else{
                return mid;
            }
        }
        return right;
    }
}
// @lc code=end

