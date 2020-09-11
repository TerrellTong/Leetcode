/*
	算法思想：
		回溯，一次成功，三个全家桶！
		
*/


class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,k,n,new ArrayList(),0);
        return res;
    }

    public void dfs(int begin,int k,int n,List<Integer> cur,int sum){
        if(sum == n){
            if(cur.size() == k)
                res.add(new ArrayList(cur));
            return;
        }

        if(sum > n)
            return;

        for(int i=begin;i<=9;i++){
            cur.add(i);
            sum += i;
            dfs(i+1,k,n,cur,sum);
            sum -= i;
            cur.remove(cur.size()-1);
        }
    }
}