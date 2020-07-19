import java.util.ArrayList;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        ArrayList<Integer> result=new ArrayList<>();

        for(int i=0;i<=nums.length-k;i++){
            int maxTemp=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                maxTemp=Math.max(maxTemp,nums[j]);
            }
            result.add(maxTemp);
        }

        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }

        return ans;
    }
}
// @lc code=end

