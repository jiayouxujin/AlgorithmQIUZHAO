/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        if(s==null||s.length()==0) return s;
        int left=0,right=s.length()-1;
        while(left<=right&&s.charAt(left)==' ') left++;
        while(left<=right&&s.charAt(right)==' ') right--;

        Deque<String> d=new ArrayDeque();
        StringBuilder word=new StringBuilder();

        while(left<=right){
            char c=s.charAt(left);
            if((word.length()!=0)&&(c==' ')){
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if(c!=' '){
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());
        return String.join(" ",d);
    }
}
// @lc code=end

