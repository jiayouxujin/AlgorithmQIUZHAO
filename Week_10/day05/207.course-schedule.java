/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            numCourses--;
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==cur){
                    indgree[prerequisites[i][0]]--;
                    if(indgree[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses==0;
    }
}
// @lc code=end

