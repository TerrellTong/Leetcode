/*
	算法思想：
		约瑟夫环，倒推
		
链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
		

*/

class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        //从第二轮开始倒推，因为最后一轮只剩一人，它的下标一定为0
        for(int i=2;i<=n;i++)
            ans = (ans + m)%i;
        return ans;
    }
}








