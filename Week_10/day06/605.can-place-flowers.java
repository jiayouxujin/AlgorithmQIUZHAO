/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len=flowerbed.length;
        int count=0;
        for(int i=0;i<len&&count<n;i++){
            if(flowerbed[i]==1){
                continue;
            }
            int pre=i==0?0:flowerbed[i-1];
            int next=i==len-1?0:flowerbed[i+1];
            if(pre==0&&next==0){
                flowerbed[i]=1;
                count++;
            }
        }
        return count==n;
    }
}
// @lc code=end

