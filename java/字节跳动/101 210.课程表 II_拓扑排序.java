/*
	算法思想：
		拓扑排序，采用BFS，
		先算每一个课程的入度，然后将入度为0的点，添加到队列中，然后依次出队，出队代表修完课程，并将其添加到res中，当某个课程的入度为0，则添加到队列中

*/


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
            return new int[0];
        //入度表的声明
        int[] inDegrees = new int[numCourses];
        //将每一数组的入度求出来
        for(int[] p : prerequisites)
            inDegrees[p[0]]++;
        //声明一个队列，用BFS完成拓扑排序，节点为0的点入度
        Queue<Integer> queue = new LinkedList();
        for(int i=0;i<inDegrees.length;i++){
            if(inDegrees[i] == 0)
                queue.offer(i);
        }
        int count = 0;//计数
        int[] res = new int[numCourses];//记录已经学完的课程
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            //遍历prerequisites，看哪个课程的先修是cur
            for(int[] p : prerequisites){
                if(p[1] == cur){
                    //p[0]节点--
                    inDegrees[p[0]]--;
                    if(inDegrees[p[0]] == 0)
                        queue.offer(p[0]);
                }
            }
        }
        if(count == numCourses)
            return res;
        
        return new int[0];
    }
}