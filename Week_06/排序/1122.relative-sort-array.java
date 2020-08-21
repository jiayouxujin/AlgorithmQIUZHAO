/*
 * @lc app=leetcode id=1122 lang=java
 *
 * [1122] Relative Sort Array
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt=new int[1001];
        
        for(int n:arr1){
            cnt[n]++;
        }

        int i=0;
        for(int n:arr2){
            while(cnt[n]-->0){
                arr1[i++]=n;
            }
        }

        for(int j=0;j<cnt.length;j++){
            while(cnt[j]-->0){
                arr1[i++]=j;
            }
        }
        return arr1;
    }
}
// @lc code=end

