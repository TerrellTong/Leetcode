/*
	算法思想：
		全排列的剪枝思想，昨天把全排列思考了一会应该怎么做
		通过判断元素个数的全排列数量，来找到K的位置
		找到之后，我们就直接一次递归即可，不需要回溯！！！
	
解题原理：https://leetcode-cn.com/problems/permutation-sequence/solution/hui-su-jian-zhi-python-dai-ma-java-dai-ma-by-liwei/
视频优化：https://leetcode-cn.com/problems/permutation-sequence/solution/javachao-hao-li-jie-ti-gong-zhu-shi-xiang-xi-de-yo/
		
*/


class Solution {
    //判断数是否使用过
    boolean[] used;
    int[] factorial;
    public String getPermutation(int n, int k) {
        //计算每个数的阶乘，然后存起来
        calculateFactorial(n);
        used = new boolean[n+1];

        StringBuilder path = new StringBuilder();
        dfs(1,path,n,k);
        return path.toString();
    }

    public void dfs(int index , StringBuilder path,int n,int k){
        if(index == n+1)
            return;
        
        //计算还未确定的数字的全排列个数
        //例如：index是1，n是4，4-1=3，表明剩下的三个数的全排列个数
        int cnt = factorial[n-index];
        for(int i=1;i<=n;i++){
            if(used[i])
                continue;
            //如果count < k ，说明此时的i不是自己想要的位置，需要剪枝
            if(cnt < k){
                k -= cnt;
                continue;
            }
            //此时已经剪枝到想要的位置了
            path.append(i);
            used[i] = true;
            dfs(index+1,path,n,k);
            // 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
            return;
        }
    }

    //计算阶乘
    public void calculateFactorial(int n){
        factorial = new int[n+1];
        factorial[0] = 1;
        for(int i=1;i<=n;i++)
            factorial[i] = factorial[i-1]*i;
    }
}


/*
	全排列的做法
		state[]，用于表示被访问没，防止最后回弹不出去
		例如：123，如果没有state，最后不会弹到132		
*/
class Solution {
    List<String> res = new ArrayList();
    boolean[] state;
    public String getPermutation(int n, int k) {
        state = new boolean[n+1];
        dfs(1,n,"");
        return res.get(k-1);
    }

    public void dfs(int start ,int n,String cur){
        // cur += start;
        if(start == n+1){
            res.add(cur);
            return;
        }


        for(int i=1;i<=n;i++)
        //state[i]用来标志哪些数字已经被访问了！，以免重复访问
        if(!state[i]){
            state[i] = true;
            cur += i;
            dfs(start+1,n,cur);
            //移除最后一位
            cur = cur.substring(0,cur.length()-1);
            state[i] = false;
        }
    }
}