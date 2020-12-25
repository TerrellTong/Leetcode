/*
	算法思想：
		排序+贪心
*/

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        boolean[] g_used = new boolean[g.length];
        boolean[] s_used = new boolean[s.length];
        int count = 0;
        for(int i=0;i<s.length;i++){
            for(int j=0;j<g.length;j++){
                if(s_used[i])
                    break;
                if(s[i] >= g[j]  && !g_used[j]){
                    g_used[j] = true;
                    s_used[i] = true;
                    count++;
                }
            }
        }
        return count;
    }
}