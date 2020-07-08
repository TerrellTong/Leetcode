/*
	算法思想：
		暴力o(n^2)会出现超时
		数学问题：
			将普通的情况可以转化成等差数列。（第一项为short*K，差值是longer-shorter）
		
*/
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        //如果K为0，则直接返回空数组
        if(k == 0)
            return new int[0];
        //如果长木板和短木板的长度相等，则返回短木板*k
        if(shorter == longer)
            return new int[]{shorter * k};
        //如果长短木板不一致，由题意知是等差数列
        int[] result = new int [k+1];
        for(int i=0;i<=k;i++){
            result[i] = shorter*k + (longer-shorter)*i;
        }
        return result;
    }
}





