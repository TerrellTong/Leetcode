/*
	算法思想：
		递归，我想成分治了
		题目要求：不能用if，for等关键字
		
	短路效应
	if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false

	if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true


	
*/
 
class Solution {
    int res = 0;
    public int sumNums(int n) {
		//下面的语句就是实现了 n == 1时终止递归
		//由于短路效应，因此当x == 1 不会继续向下递归了
        boolean x= n > 1 && (n += sumNums(n-1)) > 0;
        return n;
    }
}









