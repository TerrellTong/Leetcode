/*
	算法思想：
		深度优先遍历
				
*/

class Solution {
    //访问数组，判断是否被访问
    private boolean[][] visited;
    private int ans=0 ;
    private int[] directX = {-1, 0, 1, 0};
    private int[] directY = {0, 1, 0, -1};
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        visited[0][0] = true;
        ans++;
        //头结点传入
        dfs(0,0,m,n,k);
        return ans;
    }

    public void dfs (int curX,int curY,int m,int n,int k){
        //如果条件大于k,则退出
            if((curX/10+curX%10+curY/10+curY%10+curX/100+curY/100) > k){
                ans--;
                return;
            }

            for (int i = 0; i < 4; i++){
                int nextX = curX + directX[i];
                int nextY = curY + directY[i];
                //满足条件就遍历
                if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]){
                    ans++;
                    visited[nextX][nextY] = true;
                    dfs(nextX, nextY,m, n, k);
                }
            }
    }
}












