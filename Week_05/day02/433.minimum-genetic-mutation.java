/*
 * @lc app=leetcode id=433 lang=java
 *
 * [433] Minimum Genetic Mutation
 */

// @lc code=start
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] G=new char[]{'A','C','G','T'};
        Set<String> bankSet=new HashSet<>();
        for(String s:bank){
            bankSet.add(s);
        }
        if(!bankSet.contains(end)){
            return -1;
        }
        Set<String> visited=new HashSet<>();
        Set<String> beginSet=new HashSet<>();
        Set<String> endSet=new HashSet<>();

        beginSet.add(start);
        endSet.add(end);

        int step=0;
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
                    for(int j=0;j<G.length;j++){
                        if(G[j]!=originChar){
                            tempStr[i]=G[j];
                            String newStr=String.valueOf(tempStr);
                            if(bankSet.contains(newStr)){
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
        return -1;
    }
}
// @lc code=end

