import java.util.Arrays;
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
        Arrays.sort(nums);
        Set<List<Integer>> set=new LinkedHashSet<>();

        for(int i=0;i<nums.length-2;i++){
            for(int left=i+1,right=nums.length-1;left<right;){
                int sum=-(nums[left]+nums[right]);
                
                if(sum==nums[i]){
                    List<Integer> temp=Arrays.asList(nums[i],nums[left++],nums[right--]);
                    set.add(temp);
                }else if(sum<nums[i]){
                    right--;
                }else{
                    left++;
                }
            }
        }

        return new ArrayList(set);
    }
}
// @lc code=end

