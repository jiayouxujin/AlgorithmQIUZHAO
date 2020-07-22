import java.util.List;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length-k+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                max=Math.max(nums[i+j],max);
            }
            res.add(max);
        }

        int[] result=new int[res.size()];
        for(int i=0;i<res.size();i++){
            result[i]=res.get(i);
        }
        return result;
    }
}
// @lc code=end

