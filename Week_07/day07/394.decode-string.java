/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        LinkedList<String> stack_res=new LinkedList<>();
        LinkedList<Integer> stack_multi=new LinkedList<>();
        int multi=0;

        for(Character c:s.toCharArray()){
            if(c=='['){
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi=0;
                res=new StringBuilder();
            }else if(c==']'){
                StringBuilder tmp=new StringBuilder();
                int curMulti=stack_multi.removeLast();
                for(int i=0;i<curMulti;i++){
                    tmp.append(res);
                }
                res=new StringBuilder(stack_res.removeLast()+tmp);
            }else if(c>='0'&&c<='9'){
                multi=multi*10+Integer.parseInt(c+"");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }
}
// @lc code=end

