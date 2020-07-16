/*
	算法思想：
		深度优先搜索，染色问题！如何染？
		在遍历的过程中，如果我们通过节点u遍历到了节点v (即u和V在图中有一边直接相连)，那么会有两种情况: .
			如果v未被染色，那么我们将其染成与u不同的颜色，并对V直接相连的节点进行遍历;
			如果v被染色,并且颜色与u相同，那么说明给定的无向图不是二分图。我们可以直接退出遍历并返回False作为答案。
	
https://leetcode-cn.com/problems/is-graph-bipartite/solution/pan-duan-er-fen-tu-by-leetcode-solution/
*/
class Solution {
    private static final int UNCOLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;
    private int[] color;
    private boolean valid;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        valid = true;
        color = new int[n];
        //用UNCOLORED填充数组
        Arrays.fill(color,UNCOLORED);
        //为了防止第一行出现为[](某一行为[])，空数组，因此要用for数组循环
        for(int i=0;i<n && valid; i++){
            //从某一个结点开始遍历，如果该结点为UNCOLORED，则从RED开始遍历
            if(color[i] == UNCOLORED)
                dfs(i,RED,graph);
        }
        return valid;
    }

    public void dfs(int node,int c,int[][] graph){
        //将此节点的颜色记录下来
        color[node] = c;
        //如果c的颜色是红色，则其相邻结点就应该是绿色
        int cNei = c == RED?GREEN:RED;
        //遍历graph[node]中的结点
        for(int neighbor: graph[node]){
            //如果某个结点未被染色，则继续向下递归
            if(color[neighbor] == UNCOLORED){
                dfs(neighbor,cNei,graph);
                //如果此时valid变为false，直接返回
                if(!valid)
                    return;
            } 
            //如果结点被染色了，但是染色的颜色与相邻的颜色不同
            else if(color[neighbor] != cNei){
                valid = false;
                return;
            }
        }

    }
}





