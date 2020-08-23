/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> needMap=new HashMap<>();
        HashMap<Character,Integer> windowMap=new HashMap<>();

        for(char c:t.toCharArray()){
            needMap.put(c,needMap.getOrDefault(c,0)+1);
        }

        int left=0,right=0;
        int valid=0;
        int start=0,len=Integer.MAX_VALUE;

        while(right<s.length()){
            char c=s.charAt(right);
            right++;

            if(needMap.containsKey(c)){
                windowMap.put(c,windowMap.getOrDefault(c,0)+1);
                if(windowMap.get(c).equals(needMap.get(c)))
                    valid++;
            }

            while(valid==needMap.size()){
                if(right-left<len){
                    start=left;
                    len=right-left;
                }

                char d=s.charAt(left);
                left++;
                if(needMap.containsKey(d)){
                    if(windowMap.get(d).equals(needMap.get(d)))
                        valid--;
                    windowMap.put(d,windowMap.get(d)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
// @lc code=end

