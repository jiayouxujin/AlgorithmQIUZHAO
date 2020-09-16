/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet=new HashSet<>(wordDict);
        return helper(s,0,wordSet,new HashSet<>());
    }

    public boolean helper(String s,int index,Set<String> wordSet,HashSet<Integer> set){
        if(index==s.length()){
            return true;
        }
        if(set.contains(index)){
            return false;
        }
        for(int i=index+1;i<=s.length();i++){
            String str=s.substring(index,i);
            if(wordSet.contains(str)){
                if(helper(s,i,wordSet,set)){
                    return true;
                }else{
                    set.add(i);
                }
            }
        }
        set.add(index);
        return false;
    }
}
// @lc code=end

