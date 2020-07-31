/*
 * @lc app=leetcode id=874 lang=java
 *
 * [874] Walking Robot Simulation
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        int x=0,y=0;
        int dir_index=0;
        int ans=0;
        HashSet<String> set=new HashSet<>();

        for(int i=0;i<obstacles.length;i++){
            set.add(obstacles[i][0]+","+obstacles[i][1]);
        }

        for(int i=0;i<commands.length;i++){
            if(commands[i]==-1){
                dir_index=(dir_index+1)%4;
            }else if(commands[i]==-2){
                dir_index=(dir_index+3)%4;
            }else if(commands[i]>0){
                for(int j=1;j<=commands[i];j++){
                    int dx=x+dir[dir_index][0];
                    int dy=y+dir[dir_index][1];
    
                    if(set.contains(dx+","+dy)){
                        break;
                    }else{
                        x=dx;
                        y=dy;
                        ans=Math.max(ans,x*x+y*y);
                    }
                }
            }
        }
        return ans;
    }
}
// @lc code=end

