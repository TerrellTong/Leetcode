/*
	算法思想：
		贪心
		考虑过贪心，不知道怎么贪，要依据题干来贪！！  我是随心所欲的翻转，按照自己的感觉！
		由于要取最大，因此我们希望1越多越好，而在题中，首先需要高位为1，因此我们对高位为0的所有行进行翻转
		对于列，我们希望1越多越好，因此当0的个数小于1时，我们要对其进行翻转。
		
*/

class Solution {
    public int matrixScore(int[][] A) {
        
        //让最左边的值必须为1
        for(int i=0;i<A.length;i++){
            if(A[i][0] == 0){
                //翻转这一行
                for(int j=0;j<A[i].length;j++)
                    A[i][j] = A[i][j] == 1 ? 0 : 1;
                
            }
        }

        //找列进行翻转
        for(int j=1;j<A[0].length;j++){
            int count = 0;
            //计算0的数量
            for(int i=0;i<A.length;i++){
                if(A[i][j] == 0)
                    count++;
            }
            //如果0的数量大于1的数量，则翻转
            if(count > (A.length)/2){
                for(int i=0;i<A.length;i++)
                    A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }

        //计算
        int num = 0;
        for(int j=0;j<A[0].length;j++){
            int tmp = (int)Math.pow(2,A[0].length-j-1);
            for(int i=0;i<A.length;i++)
                num += A[i][j] * tmp;
        }
        return num;
    }
}