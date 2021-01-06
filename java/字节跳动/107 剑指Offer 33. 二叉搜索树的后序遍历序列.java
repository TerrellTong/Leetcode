/*
	算法思想：
		由于后序遍历的最后一个位置是根结点，根结点左子树都要比这个节点小，右子树都要比根结点的值大。
		我们从左到右，找到第一个比根结点大的值，如果这个节点之后，一直到根结点之前，存在一个小于根结点的值，则说明该树一定不是二叉搜索树。
		
题解思路：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/di-gui-he-zhan-liang-chong-fang-shi-jie-jue-zui-ha/ 递归

*/

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder,0,postorder.length-1);
    }

    public boolean dfs(int[] postorder,int left,int right){
        if(left>right)
            return true;
        //找到根结点的值
        int root = postorder[right];
        //从左边往右边找，找第一个比根结点大的值
        int mid = left;
        while(postorder[mid] < root)
            mid++;
        int temp = mid;
        //如果当前位置的后面存在一个数比mid小，说明不是二叉搜索树
        while(temp < right){
            if(postorder[temp++] < root)
                return false;
        }
        //mid只是一个参考，没有使用，right-1是因为最后一个right已经使用了，我们要将它移除
        return dfs(postorder,left,mid-1)&&dfs(postorder,mid,right-1);
    }
}