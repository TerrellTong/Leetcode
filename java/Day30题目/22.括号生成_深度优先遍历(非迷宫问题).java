/*
	算法思想：
		深度优先遍历（非迷宫问题）
				
*/

class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
		//从空字符串开始dfs
        dfs(n,n,"");
        return res;
    }
    public void dfs (int left,int right,String cur){
        if(left == 0 && right == 0){
            res.add(cur);
            return;
        }
		//括号是（），因此只要left>0,可以一直（（
        if(left > 0){
            dfs(left-1 , right ,cur+"(" );
        }
		//右边比左边多，说明存在能够相匹配的“）”
        if(right > left){
            dfs(left,right-1,cur+")");
        }
    }
}












