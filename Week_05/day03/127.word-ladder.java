/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet=new HashSet<>();
        Set<String> endSet=new HashSet<>();
        Set<String> wordSet=new HashSet<>(wordList);
        Set<String> visited=new HashSet<>();

        if(!wordSet.contains(endWord)){
            return 0;
        }
        beginSet.add(beginWord);
        endSet.add(endWord);

        int step=1;
        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            if(beginSet.size()>endSet.size()){
                Set<String> set=beginSet;
                beginSet=endSet;
                endSet=set;
            }

            Set<String> nextBeginSet=new HashSet<>();
            for(String str:beginSet){
                char[] tempStr=str.toCharArray();
                for(int i=0;i<tempStr.length;i++){
                    char originChar=tempStr[i];
                    for(char c='a';c<='z';c++){
                        if(c!=originChar){
                            tempStr[i]=c;
                            String newStr=String.valueOf(tempStr);
                            if(wordSet.contains(newStr)){
                                if(endSet.contains(newStr)){
                                    return step+1;
                                }
                                if(!visited.contains(newStr)){
                                    visited.add(newStr);
                                    nextBeginSet.add(newStr);
                                }
                            }
                        }
                    }
                    tempStr[i]=originChar;
                }
            }
            beginSet=nextBeginSet;
            step++;
        }
        return 0;
    }
}
// @lc code=end

