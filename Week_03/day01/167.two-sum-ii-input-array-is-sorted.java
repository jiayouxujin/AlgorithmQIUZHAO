/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res=new int[2];

        for(int i=0;i<numbers.length;i++){
            int temp=target-numbers[i];
            if(map.containsKey(temp)){
                res[0]=map.get(temp)+1;
                res[1]=i+1;
                return res;
            }
            map.put(numbers[i],i);
        }
        return res;
    }
}
// @lc code=end

