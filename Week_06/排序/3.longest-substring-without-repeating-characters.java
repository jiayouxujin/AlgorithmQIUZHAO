/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();

        int left=0,right=0;
        int start=0,res=0;
        
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.get(c)>1){
                char d=s.charAt(left);
                left++;
                map.put(d,map.get(d)-1);
            }
            res=Math.max(res,right-left);
        }
        return res;
    }
}
// @lc code=end

