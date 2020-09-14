/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
//1 2 3 4
//1 1 2 6
//24 12 4 1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0) return new int[0];
        int len=nums.length;
        int[] leftToRight=new int[len];
        int[] rightToLeft=new int[len];
        
        leftToRight[0]=1;
        rightToLeft[len-1]=1;
        for(int i=1;i<len;i++){
            leftToRight[i]=nums[i-1]*leftToRight[i-1];
        }
        for(int j=len-2;j>=0;j--){
            rightToLeft[j]=nums[j+1]*rightToLeft[j+1];
        }

        int[] res=new int[len];
        for(int i=0;i<len;i++){
            res[i]=leftToRight[i]*rightToLeft[i];
        }
        return res;
    }
}
// @lc code=end

