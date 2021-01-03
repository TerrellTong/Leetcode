/*
	算法思想：
		之前做过，好像忘记了！！
		通过计算他们的阶乘数，从而相减，完成剪枝！
		
题解：https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/

*/

class Solution {
    //判断数组是否被使用过
    boolean[] used;
    //记录阶乘数组
    int[] factorial;
    public String getPermutation(int n, int k) {
        used = new boolean[n+1];
        factorial = new int[n+1];
        //计算这n个数的阶乘,每个数的阶乘个数
        calFactorial(n);
        Arrays.fill(used,false);
        StringBuilder path = new StringBuilder();
        dfs(1,path,n,k);
        return path.toString();
    }

    public void dfs(int index,StringBuilder path,int n,int k){
        if(index == n+1){
            return;
        }

        //计算剩下的数字还有多少种排列的方式
        //例如：n为4 ,index为1  剩下三个数字的组合数目，剩下3个数的排列组合模式为多少
        int cnt = factorial[n-index];
        //i 表示要填写哪个数字
        for(int i=1;i<=n;i++){
            if(used[i])
                continue;
            //如果组合数小于k,说明我们要的位置不在下面，直接剪枝
            if(cnt < k){
                k -= cnt;
                continue;
            }

            //此时说明我们已经找到了我们想要开始遍历的节点
            path.append(i);
            used[i] = true;
            dfs(index+1,path,n,k);
            return;
        }
    }

    public void calFactorial(int n){
        factorial[0] = 1;
        for(int i=1;i<=n;i++){
            factorial[i] = factorial[i-1]*i;
        }
    }
}