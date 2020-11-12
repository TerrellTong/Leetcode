/*
	算法思想：
		记忆化搜索
		
题解：https://leetcode-cn.com/problems/freedom-trail/solution/zi-you-zhi-lu-dfs-by-yxiaojian/
	https://leetcode-cn.com/problems/freedom-trail/solution/freedom-trail-by-ikaruga/

*/

class Solution {
    //存储26个字母中，ring出现的位置
    List<Integer>[] ch_index = new ArrayList[26];
	//用来记录当前表盘指在i，目标字符在j,往下找解时，因为表盘位置不同，则j也不同，这样我们就用二维数组存取
    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        int n = ring.length() , m = key.length();
        memo = new int[n][m];
        //Arrays.fill(memo,-1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j]=-1;//-1表示未求解
            }
        }

        for(int i=0;i<26;i++)
            ch_index[i] = new ArrayList();
        
        //记录每个单词出现的位置
        for(int i=0;i<n;i++)
            ch_index[ring.charAt(i) - 'a'].add(i);

        return dfs(n,0,key,0);
    }

    public int dfs(int n,int ring_pos,String key,int key_pos){
        if(key_pos == key.length())
            return 0;
        if(memo[ring_pos][key_pos] != -1)
            return memo[ring_pos][key_pos];
        //获取key中当前位置，在ring出现的位置
        List<Integer> list = ch_index[key.charAt(key_pos)-'a'];
        int res = (int)1e10;
        //遍历key中字符在ring中出现的位置
        for(Integer index:list){
            //Math.min(Math.abs(ring_pos-index),n-Math.abs(ring_pos-index))判断在当前ring_pos下，移动到目标字符，是顺时针移动的路径短还是逆时针移动的路径短
            int tmp_res = 1+Math.min(Math.abs(ring_pos-index),n-Math.abs(ring_pos-index))+dfs(n,index,key,key_pos+1);
            res = Math.min(res,tmp_res);
        }
        memo[ring_pos][key_pos] = res;
        return memo[ring_pos][key_pos];
    }
}