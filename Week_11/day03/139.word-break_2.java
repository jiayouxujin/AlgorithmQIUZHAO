/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet=new HashSet<>(wordDict);
        if(wordSet.contains(s)) return true;

        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.add(0);
        visited.add(0);

        while(!queue.isEmpty()){
            int cur=queue.poll();
            for(int i=cur+1;i<=s.length();i++){
                if(visited.contains(i)) continue;
                String str=s.substring(cur,i);
                if(wordSet.contains(str)){
                    if(i==s.length()) return true;
                    queue.add(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }
}
// @lc code=end

