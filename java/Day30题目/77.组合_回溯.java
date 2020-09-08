/*
	算法思想：
		回溯，这个题目不像全排列，有的位置是需要剪枝的
		此时的start，作为i的起始变量，不想当与全排列的，i是index
		我是按照全排列的思想做的，没有剪枝！！
		要学会如何剪枝！！
	

*/


class Solution {
    List<List<Integer>> res = new ArrayList();
    boolean[] visited ;
    public List<List<Integer>> combine(int n, int k) {
        visited = new boolean[n+1];
        List<Integer> cur = new ArrayList();
        dfs(1,cur,n,k);
        return res;
    }

    public void dfs(int start,List<Integer> cur,int n,int k){
        if( cur.size() == k){
            res.add(new ArrayList(cur));
            return;
        }

        //从1-n开始遍历
        for(int i=start;i<=n;i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(i);
                dfs(i+1,cur,n,k);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }
}