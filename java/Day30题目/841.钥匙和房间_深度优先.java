/*
	算法思想：
		深度优先遍历，之前对题目的意思了解不深，不知道用什么方法！
		

		
*/


class Solution {
    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        //获取所有的房间数目
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        //从第0号房间开始遍历
        dfs(rooms,0,visited);
        return count == n;
    }

    public void dfs(List<List<Integer>> rooms,int cur,boolean[] visited){
        visited[cur] = true;
        //cur房间已经被访问，count++
        count++;
        //通过room.get(),从而获取这个房间的钥匙列表，我们依次钥匙列表为基础进行dfs操作
        for(Integer key : rooms.get(cur)){
            //如果这个钥匙的房间没有被访问，则开始进行dfs深度遍历的操作
            if(!visited[key])
                dfs(rooms,key,visited);
        }
    }
}