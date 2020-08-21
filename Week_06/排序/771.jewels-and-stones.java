/*
 * @lc app=leetcode id=771 lang=java
 *
 * [771] Jewels and Stones
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character,Integer> map=new HashMap<>();

        for(char c:J.toCharArray()){
            map.put(c,1);
        }

        int res=0;
        for(char c:S.toCharArray()){
            if(map.containsKey(c)){
                res++;
            }
        }
        return res;
    }
}
// @lc code=end

