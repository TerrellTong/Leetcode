/*
	算法思想：
		深度优先遍历，提供了一种恢复现场的思路
*/
 

class Solution {
    int length;
    Stack<Integer> path;
    List<List<Integer>> res;
    boolean[] state;

    public List<List<Integer>> permute(int[] nums) {
        length = nums.length;
        res = new ArrayList();
        state = new boolean[length];
        path = new Stack();
		//从数组下标0开始遍历
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums,int pos){
        if(pos == length){
            res.add(new ArrayList(path));
            return;
        }

		//从数组起始开始遍历
        for(int i=0;i<length;i++){
            if(!state[i]){
                // 保存现场
                state[i] = true;
                path.push(nums[i]);
                
                dfs(nums, pos + 1);
                
                //恢复现场
                path.pop();
                state[i] = false;
            }
        }
    }
}











