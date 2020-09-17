/*
	算法思想：
		并查集，新思想！！
		并查集主要是解决图论中“动态连通性”的问题！

解题思路：https://leetcode-cn.com/problems/redundant-connection-ii/solution/java-bing-cha-ji-by-luma730-2/
并查集思想：https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E8%AF%A6%E8%A7%A3.md
		https://blog.csdn.net/qq_41593380/article/details/81146850
*/


class Solution {
    int[] result = new int[2];
    int doubleRoot = 0;
    int[] hadRoot;
    int[][] rootResult = new int[2][2];

    public int[] findRedundantDirectedConnection(int[][] edges) {
        hadRoot = new int[edges.length+1];
        int[] father = new int[edges.length+1];
        //每个人都是独立的掌门，即自己就是掌门人
        for(int i=0;i<father.length;i++){
            father[i] = i;
        }

        for(int[] edge : edges){
            //计算某个结点的入度
            hadRoot[edge[1]]++;
            //如果某个结点入度是2，说明不满足条件：其他节点都是根结点的后继
            //记录下来,此时记录的是第二次出现这个值的数组了
            if(hadRoot[edge[1]] == 2){
                doubleRoot = edge[1];
                rootResult[1] = edge;
            }else{
                //进行帮派联合
                union(father,edge[1],edge[0]);
            }
        }

        //说明存在入度为2的情况
        if(doubleRoot != 0){
            //找到入度为2的点
            for(int[] edge:edges){
                //找到第一次出现这个入度的值
                if(edge[1] == doubleRoot){
                    rootResult[0] = edge;
                    break;
                }
            }
            int root = 0;
            for(int i=1;i<father.length;i++){
                if(root == 0){
                    //找到i的掌门
                    root = findXFather(father,i);
                }
                if(root != findXFather(father,i))
                    return rootResult[0];
            }
            return rootResult[1];
        }
        return result;
    }

    //找到它的掌门人
    public int findXFather(int[] father,int x){
        while(father[x] != x){
            //路径压缩
            father[x] = father[father[x]];
            x = father[x];
        }
        return x;
    }

    //帮派联合
    public void union(int[] father,int x,int y){
        int xFather = findXFather(father,x);
        int yFather = findXFather(father,y);
        //如果两者的掌门人都不同，说明可以合并
        //否则说明它们两者是连通的
        if(xFather != yFather){
            father[xFather] = yFather;
        }else{
            //说明两者有连通性
            result[0] = y;
            result[1] = x;
        }
    }
}