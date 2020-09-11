/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<>(wordList);
        HashSet<String> beginSet=new HashSet<>();
        HashSet<String> endSet=new HashSet<>();
        HashSet<String> visitSet=new HashSet<>();

        if(!wordSet.contains(endWord)){
            return 0;
        }
        beginSet.add(beginWord);
        visitSet.add(beginWord);
        endSet.add(endWord);
        visitSet.add(endWord);
        int ans=2;

        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                HashSet<String> tmp=beginSet;
                beginSet=endSet;
                endSet=tmp;
            }

            HashSet<String> newBeginSet=new HashSet<>();
            for(String s:beginSet){
                char[] tmps=s.toCharArray();
                for(int i=0;i<tmps.length;i++){
                    char originChar=tmps[i];
                    for(char newChar='a';newChar<='z';newChar++){
                        tmps[i]=newChar;
                        String tmpstr=new String(tmps);
                        if(endSet.contains(tmpstr)){
                            return ans;
                        }
                        if(wordSet.contains(tmpstr)&&!visitSet.contains(tmpstr)){
                            newBeginSet.add(tmpstr);
                            visitSet.add(tmpstr);
                        }
                    }
                    tmps[i]=originChar;
                }
            }
            beginSet=newBeginSet;
            ans++;
        }
        return 0;
    }
}
// @lc code=end

