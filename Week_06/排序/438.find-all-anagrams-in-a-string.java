/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> needMap=new HashMap<>();
        HashMap<Character,Integer> windowMap=new HashMap<>();

        List<Integer> res=new ArrayList<>();
        for(char c:p.toCharArray()){
            needMap.put(c,needMap.getOrDefault(c,0)+1);
        }

        int left=0,right=0;
        int valid=0;
        
        while(right<s.length()){
            char c=s.charAt(right);
            right++;
            if(needMap.containsKey(c)){
                windowMap.put(c,windowMap.getOrDefault(c,0)+1);
                if(windowMap.get(c).equals(needMap.get(c)))
                    valid++;
            }

            while(valid==needMap.size()){
                if(right-left==p.length()){
                    res.add(left);
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
        return res;
    }
}
// @lc code=end

