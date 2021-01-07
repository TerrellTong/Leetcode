/*
	算法思想：
		连通域的个数计算，通过深度优先搜索完成
		其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
		
		
题解：https://leetcode-cn.com/problems/number-of-provinces/solution/dfs-bfs-bing-cha-ji-3-chong-fang-fa-ji-s-edkl/
*/



class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        //定义 cnt 来累积遍历过的连通域的数量
        int cnt = 0;
		//一个一个城市进行遍历
        for(int i=0;i<provinces;i++){
            //如果当前顶点i未被访问，说明是一个连通域，则连通域++
            if(!visited[i]){
                cnt++;
                dfs(i,isConnected,visited);
            }
        }
        return cnt;
    }

    public void dfs(int i,int[][] isConnected,boolean[] visited){
        //对当前顶点i进行访问标记
        visited[i] = true;

        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j] == 1 && !visited[j])
                dfs(j,isConnected,visited);
        }
    }
}