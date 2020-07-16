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

        Set<List<Integer>> result=new LinkedHashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            int head=i+1,tail=nums.length-1;
            while(head<tail){
                int num=-(nums[head]+nums[tail]);
                if(num==nums[i]){
                    List<Integer> temp=Arrays.asList(nums[i],nums[head],nums[tail]);
                    result.add(temp);
                }
                if(num<nums[i]){
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

