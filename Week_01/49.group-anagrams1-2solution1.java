import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0) return new ArrayList();

        HashMap<String,List> map=new HashMap<>();
        int[] count=new int[26];

        for(String str:strs){
            Arrays.fill(count, 0);
            for(char c:str.toCharArray()){
                count[c-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int num:count){
                sb.append("#");
                sb.append(num);
            }
            String key=sb.toString();
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }

            map.get(key).add(str);
        }

        return new ArrayList(map.values());
    }
}
// @lc code=end

