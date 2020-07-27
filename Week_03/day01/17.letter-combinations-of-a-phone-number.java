/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        generate("",digits,0,res,map);
        return res;
    }

    public void generate(String s,String digits,int level,List<String> res,Map<Integer,String> map){
        if(level==digits.length()){
            res.add(s);
            return ;
        }

        String ss=map.get(digits.charAt(level)-'0');
        for(int i=0;i<ss.length();i++){
            generate(s+ss.charAt(i),digits,level+1,res,map);
        }
    }
}
// @lc code=end

