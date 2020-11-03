/*
	算法思想：
		双指针，上坡++，下坡++，如果上坡为0，说明要前移动！！
		
题解：https://leetcode-cn.com/problems/longest-mountain-in-array/solution/
*/

class Solution {
    public int longestMountain(int[] A) {
        // 如果写到这里，当出现爬上坡，下坡，上坡时，会出现死循环，因此当成功进行一次上坡，下坡时，要置为0,而且出现过一次up>0,down=0，
        // 我们还要重新计数，将up,down置为0！！不然会出现死循环
        // int up = 0;
        // int down = 0;
        int i = 0;
        int len = A.length;
        int ans = 0;
        while(i < len){
            //每一轮企图上山前，都要将up,down 置为0！！！
            //不能出现上山前，up,down 中任意一个非0
            int up = 0 , down = 0;
            //一直向山上爬
            while(i < len-1 && A[i] < A[i+1]){
                up++;
                i++;
                continue;
            }
            //如果成功上山，那么就可以判断下山了
            if(up > 0){
                while(i < len-1 && A[i] > A[i+1]){
                    down++;
                    i++;
                    continue;
                }
            }

            //如果上山失败，则移动i指针
            if(up == 0){
                i++;
            }

            if(up > 0 && down > 0){
                ans = Math.max(up+down+1,ans);
            }
        }
        return ans;
    }
}
