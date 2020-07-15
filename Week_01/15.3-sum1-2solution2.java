import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<=2){
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result=new LinkedHashSet<>();

        for(int i=0;i<nums.length-2;i++){
            int head=i+1;
            int tail=nums.length-1;
            while(head<tail){
                int sum=-(nums[head]+nums[tail]);
                if(sum==nums[i]){
                    result.add(Arrays.asList(nums[i],nums[head],nums[tail]));
                }
                if(sum<=nums[i]){
                    tail--;
                }else{
                    head++;
                }
            }
        }
        return new ArrayList(result);
    }
}
// @lc code=end

