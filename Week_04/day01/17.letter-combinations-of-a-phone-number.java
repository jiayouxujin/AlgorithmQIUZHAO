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
        if(digits==null||digits.length()==0){
            return res;
        }

        generate(res,map,digits,"");
        return res;
    }
    public void generate(List<String> res,Map<Integer,String> map,String digits,String temp){
        if(temp.length()==digits.length()){
            res.add(temp);
            return ;
        }
        String str=map.get(digits.charAt(temp.length())-'0');
        for(int i=0;i<str.length();i++){
            generate(res,map,digits,temp+str.charAt(i));
        }
    }
}
// @lc code=end

