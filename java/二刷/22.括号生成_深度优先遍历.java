/*
	算法思想：
		深度优先遍历，二刷
		知道方法，不知道怎么实现！

https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
*/

class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }

    //进行深度优先遍历
    //left表示左括号的数量
    //right表示右括号的数量
    public void dfs(int left,int right,String cur){
        if(left == 0 && right == 0){
            res.add(cur);
            return;
        }

        //如果左括号的数量大于右括号的数量，则可以直接返回
        //必须先判断
        if(left > right)
            return;
        
        if(left > 0)
            dfs(left-1,right,cur+"(");
        if(right > 0)
            dfs(left,right-1,cur+")");
    }
}