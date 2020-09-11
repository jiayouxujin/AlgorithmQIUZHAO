/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
       List<Integer> perfectSquares=gen(n);
       Queue<Integer> queue=new LinkedList<>();
       boolean[] mark=new boolean[n+1];
       queue.add(n);
       mark[n]=true;
       int ans=1;
       while(!queue.isEmpty()){
           int size=queue.size();
           for(int i=0;i<size;i++){
               int cur=queue.poll();
               for(int num:perfectSquares){
                   int next=cur-num;
                   if(next<0) break;
                   if(next==0) return ans;
                   if(mark[next]) continue;
                   queue.add(next);
                   mark[next]=true;
               }
           }
           ans++;
       }
       return -1;
    }

    public List<Integer> gen(int n){
        List<Integer> res=new ArrayList<>();
        int square=1;
        int diff=3;
        while(square<=n){
            res.add(square);
            square+=diff;
            diff+=2;
        }
        return res;
    }
}
// @lc code=end

