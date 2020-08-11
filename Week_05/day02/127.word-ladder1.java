/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        LinkedList<String> queue=new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int count=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String cur=queue.poll();
                if(cur.equals(endWord)){
                    return count;
                }
                for(int k=0;k<cur.length();k++){
                    StringBuilder sb=new StringBuilder(cur);
                    for(char c='a';c<='z';c++){
                        if(c!=cur.charAt(k)){
                            sb.setCharAt(k,c);
                            if(!visited.contains(sb.toString())&&wordSet.contains(sb.toString())){
                                queue.add(sb.toString());
                                visited.add(sb.toString());
                            }
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
// @lc code=end

