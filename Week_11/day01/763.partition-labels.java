/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res=new ArrayList<>();
        if(S==null||S.length()==0){
            return res;
        }
        int[] map=new int[26];
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a']=i;
        }

        int last=0;
        int start=0;
        for(int i=0;i<S.length();i++){
            last=Math.max(last,map[S.charAt(i)-'a']);
            if(last==i){
                res.add(last-start+1);
                start=last+1;
            }
        }
        return res;
    }
}
// @lc code=end

