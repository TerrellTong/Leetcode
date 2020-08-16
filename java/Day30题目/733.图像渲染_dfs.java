/*
	算法思想：
		深度优先遍历，添加了一个visited数组，成功做出来了
		

*/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //初始点的像素值
        int init_image = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        //通过深度优先遍历更改对应的值
        dfs(image,sr,sc,init_image,newColor,visited);
        return image;
    }

    public void dfs(int[][] image, int x, int y,int init_image, int newColor,boolean[][] visited){
        //判断递归终止条件
        if(image[x][y]!=init_image){
            visited[x][y] = true;
            return;
        }
        image[x][y] = newColor;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        //上下左右四边进行dfs
        for(int i=0;i<4;i++){
            int new_x = x+dx[i];
            int new_y = y+dy[i];
            //如果不满足x,y的条件，或者该点已经被访问（防止重复调用进入到了死循环），则继续下一步
            if(new_x<0 || new_x>=image.length || new_y<0 || new_y>=image[0].length || visited[new_x][new_y])
                continue;
            //将visited数组声明为true，表示该点已经被访问
            visited[new_x][new_y] = true;
            dfs(image,new_x,new_y,init_image,newColor,visited);
        }
        
    }
}