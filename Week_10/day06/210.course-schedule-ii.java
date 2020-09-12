/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res=new ArrayList<>();
        int[] indgree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            indgree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indgree.length;i++){
            if(indgree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int cur=queue.poll();
            res.add(cur);
            for(int i=0;i<prerequisites.length;i++){
                if(cur==prerequisites[i][1]){
                    indgree[prerequisites[i][0]]--;
                    if(indgree[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return res.size()==numCourses?ans:new int[0];
    }
}
// @lc code=end

