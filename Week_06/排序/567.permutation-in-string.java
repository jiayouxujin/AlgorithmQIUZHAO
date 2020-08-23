/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> needMap=new HashMap<>();
        HashMap<Character,Integer> windowMap=new HashMap<>();

        for(char c:s1.toCharArray()){
            needMap.put(c,needMap.getOrDefault(c,0)+1);
        }

        int left=0,right=0;
        int valid=0;
        int start=0,len=0;

        while(right<s2.length()){
            char c=s2.charAt(right);
            right++;

            if(needMap.containsKey(c)){
                windowMap.put(c,windowMap.getOrDefault(c,0)+1);
                if(needMap.get(c).equals(windowMap.get(c)))
                    valid++;
            }

            while(valid==needMap.size()){
                //比较是否存在
                if(right-left==s1.length()){
                    return true;
                }

                char d=s2.charAt(left);
                left++;

                if(needMap.containsKey(d)){
                    if(needMap.get(d).equals(windowMap.get(d)))
                        valid--;
                    windowMap.put(d,windowMap.get(d)-1);
                }
            }
        }
        return false;
    }
}
// @lc code=end

