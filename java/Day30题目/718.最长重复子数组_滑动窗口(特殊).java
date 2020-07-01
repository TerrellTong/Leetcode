/*
	算法思想：
		滑动窗口，两个字符串的滑动窗口！！！，窗口的高变大了
*/
class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length,m=B.length;
        int ret = 0;
        //B不动，A移动，然后A依次向后移动，一一与B进行比较
        for(int i=0;i<n;i++){
            int len = Math.min(m,n-i);
            int maxlen = maxLength(A,B,i,0,len);
            ret = Math.max(ret,maxlen);
        }
        //A不动，B移动，然后B依次向后移动，一一与A进行比较
        for(int i=0;i<m;i++){
            int len = Math.min(n,m-i);
            int maxlen = maxLength(A,B,0,i,len);
            ret = Math.max(ret,maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A,int[] B,int addA,int addB,int len){
        int ret = 0,k=0;
        for(int i=0;i<len;i++){
            if(A[addA+i] == B[addB+i])
                k++;
            else
                k=0;
            ret = Math.max(ret,k);
        }
        return ret;
    }
}
    





