/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        generate("",res,map,digits,0);
        return res;
    }

    public void generate(String s,List<String> res,Map<Integer,String> map,String digits,int level){
        if(level==digits.length()){
            res.add(s);
            return ;
        }

        String ss=map.get(digits.charAt(level)-'0');
        for(char c:ss.toCharArray()){
            generate(s+c,res,map,digits,level+1);
        }
    }
}
// @lc code=end

