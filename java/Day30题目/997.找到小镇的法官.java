 /*
	算法思想：
	用图的思想，即找一个入度为N-1,出度为0的人数
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        //构建两个一维数组，用来存放入度和出度
        int[] indegree = new int[N+1];
        int[] outdegree = new int[N+1];
        for(int[] p : trust){
            int start = p[0];
            int end = p[1];
            //记录第i个人的入度和出度
            indegree[end]++;
            outdegree[start]++;
        }
        //对入度和出度的数组进行遍历
        for(int i=1; i<=N;i++){
            if(indegree[i] == N-1 && outdegree[i] == 0)
                return i;
        }
        return -1;
    }
}



     




