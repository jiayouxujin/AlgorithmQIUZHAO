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
        Set<String> visited=new HashSet<>();
        Set<String> beginSet=new HashSet<>();
        Set<String> endSet=new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);

        int len=1;
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> set=beginSet;
                beginSet=endSet;
                endSet=set;
            }

            Set<String> nextBeginSet=new HashSet<>();
            for(String word:beginSet){
                char[] tempWord=word.toCharArray();
                for(int i=0;i<tempWord.length;i++){
                    char originChar=tempWord[i];
                    for(char c='a';c<='z';c++){
                        if(c!=originChar){
                            tempWord[i]=c;
                            String nextStr=String.valueOf(tempWord);
                            if(wordSet.contains(nextStr)){
                                if(endSet.contains(nextStr)){
                                    return len+1;
                                }
                                if(!visited.contains(nextStr)){
                                    visited.add(nextStr);
                                    nextBeginSet.add(nextStr);
                                }
                            }
                        }
                    }
                    tempWord[i]=originChar;
                }
            }
            beginSet=nextBeginSet;
            len++;
        }

        return 0;
    }
}
// @lc code=end

