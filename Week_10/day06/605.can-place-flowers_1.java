/*
 * @lc app=leetcode id=605 lang=java
 *
 * [605] Can Place Flowers
 */

// @lc code=start
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed==null||flowerbed.length==0||(flowerbed.length==1&&flowerbed[0]==0&&n==1)){
            return true;
        }

        for(int i=0;i<flowerbed.length;){
            if(n==0) return true;
            if(flowerbed[i]==0&&check(flowerbed,i)){
                n--;
                i+=2;
            }else{
                i+=1;
            }
        }
        return n==0;
    }

    public boolean check(int[] flowerbed,int i){
        if(i==0){
            return flowerbed[i+1]==0;
        }
        if(i==flowerbed.length-1){
            return flowerbed[i-1]==0;
        }
        return flowerbed[i-1]==0&&flowerbed[i+1]==0;
    }
}
// @lc code=end

